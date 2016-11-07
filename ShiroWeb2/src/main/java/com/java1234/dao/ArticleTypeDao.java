package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.ArticleType;


public interface ArticleTypeDao {
	
	public List<ArticleType> getAll();
	
	public int addArticleType(ArticleType articleType);
	
	public List<ArticleType> getByPage(Map map);
	
	public int getCount();
	
	public int deleteArticleType(Map map);
	
	public List<Map> getArticleCountByType();
}
