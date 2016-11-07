package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Article;
import com.java1234.entity.ArticleType;

public interface ArticleDao {
	
	public int addArticle(Article article);
	
	public List<Article> getByPage(Map map);
	
	public int getCount(Map map);
	
	public List<Map> getCountByTime();
	
	public Article getById(int id);
}
