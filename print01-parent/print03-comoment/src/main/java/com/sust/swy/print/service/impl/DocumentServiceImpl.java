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

	@Override
	public void deleteDocumentById(Integer documentId) {
		DocumentExample example = new DocumentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(documentId);
		List<Document> list = documentMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return;
		}
		Document document = list.get(0);
		document.setIsDelete(1);
		documentMapper.updateByPrimaryKey(document);
	}

	@Override
	public void changeDocumentByID(Integer documentId) {
		DocumentExample example = new DocumentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(documentId);
		List<Document> list = documentMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return;
		}
		Document document = list.get(0);
		document.setDocumentStatus(1);
		documentMapper.updateByPrimaryKey(document);
	}

	@Override
	public void creatDocument(String name, long size, String url, Integer memberId) {
		Document document = new Document();
		document.setDocumentName(name);
		document.setDocumentSize(String.valueOf(size));
		document.setDocumentUrl(url);
		document.setDocumentStatus(0);
		document.setMemberId(memberId);
		document.setIsDelete(0);
		documentMapper.insert(document);
	}

}
