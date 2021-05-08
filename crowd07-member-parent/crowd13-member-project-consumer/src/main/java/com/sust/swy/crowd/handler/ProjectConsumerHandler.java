package com.sust.swy.crowd.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sust.swy.crowd.api.MySQLRemoteService;
import com.sust.swy.crowd.config.OSSProperties;
import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.entity.po.MemberPO;
import com.sust.swy.crowd.entity.vo.DetailProjectVO;
import com.sust.swy.crowd.entity.vo.MemberConfirmInfoVO;
import com.sust.swy.crowd.entity.vo.MemberLoginVO;
import com.sust.swy.crowd.entity.vo.ProjectVO;
import com.sust.swy.crowd.entity.vo.ReturnVO;
import com.sust.swy.crowd.exception.AccessForCreateException;
import com.sust.swy.crowd.util.CrowdUtil;
import com.sust.swy.crowd.util.ResultEntity;

@Controller
public class ProjectConsumerHandler {
	@Autowired
	private OSSProperties ossProperties;

	@Autowired
	private MySQLRemoteService mySQLRemoteService;
	
	@RequestMapping("/delete/project/detail/{projectId}")
	public String deleteProjectDetail(@PathVariable("projectId") String projectId) {
		mySQLRemoteService.deleteProjectDetailByProjectId(projectId);
		return "redirect:http://localhost/member/my/crowd/create";
	}
	

	@RequestMapping("/agree/protocol/page/{memberId}")
	public String toAgreeProtocolPage(@PathVariable("memberId") String memberId) {
		ResultEntity<MemberPO> resultEntity = mySQLRemoteService.getMemberPOByMemberid(memberId);
		MemberPO memberPO = resultEntity.getQueryData();
		if (memberPO != null || memberPO.getAuthstatus() != null) {
			if (memberPO.getAuthstatus() == 2) {
				return "project-agree";
			} else {
				throw new AccessForCreateException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
			}
		} else {
			throw new AccessForCreateException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
		}
	}

	@RequestMapping("/get/project/detail/{projectId}")
	public String getProjectDetail(@PathVariable("projectId") Integer projectId, Model model) {
		ResultEntity<DetailProjectVO> resultEntity = mySQLRemoteService.getDetailProjectVORemote(projectId);
		if (ResultEntity.SUCCESS.equals(resultEntity.getOperationResult())) {
			DetailProjectVO detailProjectVO = resultEntity.getQueryData();
			model.addAttribute("detailProjectVO", detailProjectVO);
		}
		return "project-show-detail";
	}

	@RequestMapping("/create/confirm")
	public String saveConfirm(ModelMap modelMap, HttpSession session, MemberConfirmInfoVO memberConfirmInfoVO) {
		ProjectVO projectVO = (ProjectVO) session.getAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT);
		if (projectVO == null) {
			throw new RuntimeException(CrowdConstant.MESSAGE_TEMPLE_PROJECT_MISSING);
		}
		projectVO.setMemberConfirmInfoVO(memberConfirmInfoVO);
		MemberLoginVO memberLoginVO = (MemberLoginVO) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
		Integer memberId = memberLoginVO.getId();
		ResultEntity<String> saveResultEntity = mySQLRemoteService.saveProjectVORemote(projectVO, memberId);
		String result = saveResultEntity.getOperationResult();
		if (ResultEntity.FAILED.equals(result)) {
			modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, saveResultEntity.getOperationMessage());
			return "project-confirm";
		}
		session.removeAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT);
		return "redirect:http://localhost/project/create/success";
	}

	@ResponseBody
	@RequestMapping("/create/save/return.json")
	public ResultEntity<String> saveReturn(ReturnVO returnVO, HttpSession session) {
		try {
			ProjectVO projectVO = (ProjectVO) session.getAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT);
			if (projectVO == null) {
				return ResultEntity.failed(CrowdConstant.MESSAGE_TEMPLE_PROJECT_MISSING);
			}
			List<ReturnVO> returnVOList = projectVO.getReturnVOList();
			if (returnVOList == null || returnVOList.size() == 0) {
				returnVOList = new ArrayList<>();
				projectVO.setReturnVOList(returnVOList);
			}
			returnVOList.add(returnVO);
			session.setAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT, projectVO);
			return ResultEntity.successWithoutData();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}

	@ResponseBody
	@RequestMapping("/create/upload/return/picture.json")
	public ResultEntity<String> uploadReturnPicture(@RequestParam("returnPicture") MultipartFile returnPicture)
			throws IOException {
		ResultEntity<String> uploadReturnPicResultEntity = CrowdUtil.uploadFileToOss(ossProperties.getEndPoint(),
				ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret(), returnPicture.getInputStream(),
				ossProperties.getBucketName(), ossProperties.getBucketDomain(), returnPicture.getOriginalFilename());
		return uploadReturnPicResultEntity;
	}

	@RequestMapping("/create/project/information")
	public String saveProjectBasicInfo(ProjectVO projectVO, MultipartFile headerPicture,
			List<MultipartFile> detailPictureList, HttpSession session, ModelMap modelMap) throws IOException {
		boolean headerPictureIsEmpty = headerPicture.isEmpty();
		if (headerPictureIsEmpty) {
			modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_HEADER_PIC_EMPTY);
			return "project-launch";
		}
		ResultEntity<String> uploadHeaderPicResultEntity = CrowdUtil.uploadFileToOss(ossProperties.getEndPoint(),
				ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret(), headerPicture.getInputStream(),
				ossProperties.getBucketName(), ossProperties.getBucketDomain(), headerPicture.getOriginalFilename());
		String result = uploadHeaderPicResultEntity.getOperationResult();
		if (ResultEntity.SUCCESS.equals(result)) {
			String headerPicturePath = uploadHeaderPicResultEntity.getQueryData();
			projectVO.setHeaderPicturePath(headerPicturePath);
		} else {
			modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_HEADER_PIC_UPLOAD_FAILED);
			return "project-launch";
		}
		List<String> detailPicturePathList = new ArrayList<String>();
		if (detailPictureList == null || detailPictureList.size() == 0) {
			modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_DETAIL_PIC_EMPTY);
			return "project-launch";
		}
		for (MultipartFile detailPicture : detailPictureList) {
			if (detailPicture.isEmpty()) {
				modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_DETAIL_PIC_EMPTY);
				return "project-launch";
			}
			ResultEntity<String> detailUploadResultEntity = CrowdUtil.uploadFileToOss(ossProperties.getEndPoint(),
					ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret(), detailPicture.getInputStream(),
					ossProperties.getBucketName(), ossProperties.getBucketDomain(),
					detailPicture.getOriginalFilename());
			String detailUploadResult = detailUploadResultEntity.getOperationResult();
			if (ResultEntity.SUCCESS.equals(detailUploadResult)) {
				String detailPicturePath = detailUploadResultEntity.getQueryData();
				detailPicturePathList.add(detailPicturePath);
			} else {
				modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_DETAIL_PIC_UPLOAD_FAILED);
				return "project-launch";
			}
		}
		projectVO.setDetailPicturePathList(detailPicturePathList);
		session.setAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT, projectVO);
		return "redirect:http://localhost/project/return/info/page";
	}
}
