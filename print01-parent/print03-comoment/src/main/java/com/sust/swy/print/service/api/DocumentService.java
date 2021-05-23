package com.sust.swy.print.service.api;

import java.util.List;

import com.sust.swy.print.entity.Document;

public interface DocumentService {

	List<Document> getDocumentListByMemberId(Integer memberId);

	void deleteDocumentById(Integer documentId);

	void changeDocumentByID(Integer documentId);

	void creatDocument(String name, long size, String url, Integer memberId);

}
