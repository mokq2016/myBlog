package com.java1234.entity;

import java.util.LinkedList;
import java.util.List;

public class Article {
	private int id;
	private String title;
	private String content;
	private String createTime;
	private int articleTypeId;
	private int userId;
	private int clickHit;
	private int replyNum;
	private String keyWord;
	private String summary;
	private List<String> imagesList=new LinkedList<String>();

	public Article() {
		// TODO Auto-generated constructor stub
	}
	
	public Article(String title,int clickHit,int replyNum, String content, String createTime,
			int articleTypeId, String keyWord,String summary) {
		super();
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.articleTypeId = articleTypeId;
		this.keyWord = keyWord;
		this.summary =summary;
		this.clickHit = clickHit;
		this.replyNum = replyNum;
	}
	
	

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getArticleTypeId() {
		return articleTypeId;
	}

	public void setArticleTypeId(int articleTypeId) {
		this.articleTypeId = articleTypeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getClickHit() {
		return clickHit;
	}

	public void setClickHit(int clickHit) {
		this.clickHit = clickHit;
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public List<String> getImagesList() {
		return imagesList;
	}

	public void setImagesList(List<String> imagesList) {
		this.imagesList = imagesList;
	}
	

}
