package com.sust.swy.crowd.service.api;

import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.entity.Project;
import com.sust.swy.crowd.entity.MemberCerticficatInfoDetail;

public interface CheckService {

	PageInfo<Project> getPageInfoProject(String keyword, Integer pageNum, Integer pageSize);

	void removeProjectById(Integer projectId);

	void agreeProjectById(Integer projectId);

	void successProjectById(Integer projectId);

	void failProjectById(Integer projectId);

	PageInfo<MemberCerticficatInfoDetail> getPageInfoMember(String keyword, Integer pageNum, Integer pageSize);

	void updataMemberCertificatById(Integer memberId, Integer certicficatId);

	void removeMemberCertificatById(Integer memberId, Integer certicficatId);

}
