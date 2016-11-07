package com.java1234.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java1234.dao.ArticleDao;
import com.java1234.entity.Article;
import com.java1234.service.IArticleService;
import com.java1234.util.MyResult;
import com.java1234.util.SystemUtil;

@Service
public class ArticleServiceImpl implements IArticleService{
	
	@Autowired
	private ArticleDao articleDao;
	
	private MyResult result;
	@Override
	public List<Article> getByPage(String condition,int start, int pageSize) {
		Map map = new HashMap();
		map.put("start",start);
		map.put("totalSize",pageSize);
		if(condition != null && !"".equals(condition)){
			if(condition.matches("^([0-9]{4}-[0-9]{2})$")){
				map.put("createTime", condition+"%");
			}else{				
				map.put("typeId",Integer.parseInt(condition));
			}
		}
		return articleDao.getByPage(map);
	}

	@Override
	public MyResult addOneArticle(String data) {
		JSONObject json = JSONObject.fromObject(data);
		int articleTypeId = json.getInt("articleTypeId");
		String content = json.getString("content");
		String title = json.getString("title");
		String summary = json.getString("summary");
		String keyWord = json.getString("keyWord");
		String createTime = SystemUtil.getTime(new Date(System.currentTimeMillis()));
		
		Article article = new Article(title, 0,0,content, createTime, articleTypeId, keyWord, summary);
		int i =articleDao.addArticle(article);
		result = new MyResult();
		if(i>0){
			result.setSuccess(true);	
		}else{
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public int getRecordCount(String condition) {
		Map map = new HashMap();
		if(condition != null && !"".equals(condition)){
			if(condition.matches("^([0-9]{4}-[0-9]{2})$")){
				map.put("createTime", condition+"%");
			}else{				
				map.put("typeId",Integer.parseInt(condition));
			}
		}
		return articleDao.getCount(map);
	}

	@Override
	public MyResult deletArticle(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map> getCountByTime() {
		// TODO Auto-generated method stub
		return articleDao.getCountByTime();
	}

	@Override
	public Article findById(int id) {
		
		return articleDao.getById(id);
	}

}
