package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.ArticleType;
import com.java1234.util.MyResult;


public interface IArticleTypeService {

	public List<ArticleType> getAllArticleType();
	
	public List<ArticleType> getByPage(int page,int rows);
	
	public MyResult createArticleType(String param);
	
	public int getRecordCount();
	
	public MyResult deleteArticleType(String contition);
	
	public List<Map> getArticleCountByType();
}