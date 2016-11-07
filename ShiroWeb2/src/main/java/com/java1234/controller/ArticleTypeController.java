package com.java1234.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java1234.entity.ArticleType;
import com.java1234.service.IArticleTypeService;
import com.java1234.util.MyResult;

@Controller
@RequestMapping("/articleType")
public class ArticleTypeController {
	
	@Autowired
	private IArticleTypeService articleTypeService;
	
	@RequestMapping(value="/getByPage",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public String getArticleTypeByPage(HttpServletRequest request){
		int  page = Integer.parseInt(request.getParameter("page"));
		int  rows = Integer.parseInt(request.getParameter("rows"));

		List<ArticleType> list =  articleTypeService.getByPage((page-1)*rows,rows);
		
		int total =articleTypeService.getRecordCount();
		Map<String,Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", list);
		return JSONObject.fromObject(jsonMap).toString();
		
	}
	
	@RequestMapping(value="/addArticleType",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public String addOneArticleType(HttpServletRequest request){
		String data = request.getParameter("data");
		
		MyResult result = articleTypeService.createArticleType(data);
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
		
	}
	
	@RequestMapping(value="/getAllType",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public String getAllArticleType(HttpServletRequest request){
		List<ArticleType> list =  articleTypeService.getAllArticleType();
		return JSONArray.fromObject(list).toString();
	}
	
	@RequestMapping(value="/getAllTypeCountArticle",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public String getAllTypeCountArticle(HttpServletRequest request){
		

		List<Map> list =  articleTypeService.getArticleCountByType();
		return JSONArray.fromObject(list).toString();
	}
	
	
	@RequestMapping(value="/deleteArticleType",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public String deleteArticleType(HttpServletRequest request){
		String ids = request.getParameter("data");
		
		MyResult result = articleTypeService.deleteArticleType(ids);
		JSONObject json = JSONObject.fromObject(result);
		return json.toString();
		
	}
}
