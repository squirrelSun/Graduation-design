package com.sust.swy.print.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sust.swy.print.entity.Document;
import com.sust.swy.print.entity.DocumentExample;
import com.sust.swy.print.entity.DocumentExample.Criteria;
import com.sust.swy.print.mapper.DocumentMapper;
import com.sust.swy.print.service.api.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentMapper documentMapper;

	@Override
	public List<Document> getDocumentListByMemberId(Integer memberId) {
		DocumentExample example = new DocumentExample();
		Criteria criteria = example.createCriteria();
		criteria.andMemberIdEqualTo(memberId);
		List<Document> list = documentMapper.selectByExample(example);
		return list;
	}
	
	
	
}
