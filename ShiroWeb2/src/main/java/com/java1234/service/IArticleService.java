package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Article;
import com.java1234.util.MyResult;

public interface IArticleService {
	
	public List<Article> getByPage(String typeId,int start,int pageSize);
	
	public MyResult addOneArticle(String data);
	
	public int getRecordCount(String typeId);
	
	public MyResult deletArticle(String condition);
	
	public List<Map> getCountByTime();
	
	public Article findById(int id);
}
