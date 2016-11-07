package com.java1234.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java1234.dao.ArticleTypeDao;
import com.java1234.entity.ArticleType;
import com.java1234.service.IArticleTypeService;
import com.java1234.util.MyResult;

@Service
public class ArticleTypeServiceImpl implements IArticleTypeService {
	
	@Autowired
	private ArticleTypeDao articleTypeDao;
	
	private MyResult result;
	
	public List<ArticleType> getAllArticleType(){
		return articleTypeDao.getAll();
	}

	
	public List<ArticleType> getByPage(int current,int pageSize){
		Map map = new HashMap();
		
		map.put("current",current);
		map.put("totalSize",pageSize);
		return articleTypeDao.getByPage(map);
	}
	
	public MyResult createArticleType(String param){
		result = new MyResult();
		JSONObject json = JSONObject.fromObject(param);
		ArticleType articleType = new ArticleType();
		articleType.setArticleType(json.getString("articleType"));
		articleType.setOrderNo(json.getInt("orderNo"));
		int i = articleTypeDao.addArticleType(articleType);
		if(i>0){
			result.setSuccess(true);
		}else {
			result.setSuccess(false);
			result.setErrorMsg("添加失败");
		}
		
		return result;
		
	}


	@Override
	public int getRecordCount() {
		
		return articleTypeDao.getCount();
	}


	@Override
	public MyResult deleteArticleType(String contition) {
		JSONArray array = JSONArray.fromObject(contition);
		List<Integer> list = JSONArray.toList(array);
		
		Map map = new HashMap();
		map.put("ids", list);
		int i = articleTypeDao.deleteArticleType(map);
		result = new MyResult();
		if(i>0){
			result.setSuccess(true);
		}else{
			result.setSuccess(false);
			result.setErrorMsg("删除失败");
		}
		
		return result;
	}


	@Override
	public List<Map> getArticleCountByType() {
		
		return articleTypeDao.getArticleCountByType();
	}

}
