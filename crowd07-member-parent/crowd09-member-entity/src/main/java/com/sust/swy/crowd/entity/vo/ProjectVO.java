package com.sust.swy.crowd.entity.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Integer> typeIdList;

	private List<Integer> tagIdList;

	private String projectName;

	private String projectDescription;

	private Integer money;

	private Integer day;

	private String createdate;

	private String headerPicturePath;

	private List<String> detailPicturePathList;

	private MemberLauchInfoVO memberLauchInfoVO;

	private List<ReturnVO> returnVOList;

	private MemberConfirmInfoVO memberConfirmInfoVO;

}

