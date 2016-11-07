package com.java1234.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java1234.entity.Article;
import com.java1234.entity.ArticleType;
import com.java1234.entity.testEvent;
import com.java1234.service.IArticleService;
import com.java1234.service.IArticleTypeService;
import com.java1234.util.MyResult;
import com.java1234.util.SpringHolder;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private IArticleTypeService articleTypeService;
	@Autowired
	private IArticleService articleService;
	
	@RequestMapping(value="/getAllArticle",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public String getAllArticleType(HttpServletRequest request){
		
		List<ArticleType> list =  articleTypeService.getAllArticleType();
		JSONArray jsonArray =JSONArray.fromObject(list);
		
		return jsonArray.toString();
		
	}
	
	@RequestMapping(value="/saveArticle",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public String addArticle(HttpServletRequest request){
		String data = request.getParameter("data");
		MyResult result = articleService.addOneArticle(data);
		SpringHolder.getApplicationContext().publishEvent(new testEvent(new Object()));
		return JSONObject.fromObject(result).toString();
		
	}
	
	@RequestMapping(value="/deleteArticle",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public String deleteArticle(HttpServletRequest request){
		
		String param = request.getParameter("ids");
		articleService.deletArticle(param);
		return null;
		
	}
	
	@RequestMapping(value="/getArticleByPage",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public String getArticleByPage(HttpServletRequest request){
		int  page = Integer.parseInt(request.getParameter("page"));
		if(page <1){
			page =1;
		}
		int  rows = Integer.parseInt(request.getParameter("rows"));
		String condition= request.getParameter("condition");
		List<Article> list =  articleService.getByPage(condition,(page-1)*rows,rows);
		//List<Article> list =  articleService.getByPage(0,10);
		for (Article article : list) {
			List<String> imgList = article.getImagesList();
			String content = article.getContent();
			Document doc=Jsoup.parse(content);
			Elements jpgs=doc.select("img[src$=.jpg]"); //　查找扩展名是jpg的图片
			for(int i=0;i<jpgs.size();i++){
				Element jpg=jpgs.get(i);
				imgList.add(jpg.toString());
				if(i==2){
					break;
				}
			}
		}
		
		Map<String,Object> jsonMap = new HashMap<String, Object>();
		int total = articleService.getRecordCount(condition);
		jsonMap.put("total", total);
		jsonMap.put("articleList", list);
		return JSONObject.fromObject(jsonMap).toString();
		
	}
	
	@RequestMapping(value="/getAllArticleByTime",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public String getAllArticleByTime(HttpServletRequest request){
		

		List<Map> list =  articleService.getCountByTime();
		return JSONArray.fromObject(list).toString();
	}
	
	@RequestMapping(value="/getContentById/{id}",produces="text/html;charset=utf-8")
	@ResponseBody
	public String getContentById(@PathVariable int id,HttpServletRequest request){
		
		
		Article article =  articleService.findById(id);
		return JSONObject.fromObject(article).toString();
	}
	
}
