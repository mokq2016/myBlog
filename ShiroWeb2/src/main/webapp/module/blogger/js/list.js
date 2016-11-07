$(function(){

	 getArticleByPage("",1,10);
	 
//	 resize();
//	 setInterval(function(){
//		 resize();
//	 }, 1000)
});

function getArticleByPage(condition,currentPage,size){
	 var url = "../../article/getArticleByPage";
	 var obj = {
			 "condition":condition,
			 "page":currentPage,
			 "rows":size
	 };
	 $.ajax({
		  type: "GET",
		  url: url,
		  data:obj,
		  dataType: "json",
		  success:function(data){
             // console.info(data.articleList)
              showArticleList(condition,currentPage,size,data);
		  },
		  error:function(){
			  alert("请求超时")
		  }
		});
	 
}
function showArticleList(condition,currentPage,size,data){
	$("#articleContentDiv").css("display","none");
	$("#articleList").css("display","block");
	var ulHtml="<ul>";
    $(data.articleList).each(function(){
        ulHtml += "<li>" +
            "<span class='date'><a href='javascript:getContent("+$(this)[0].id+")' >"+getDate($(this)[0].createTime)+"</a></span>" +
            "<span class='title'><a href='javascript:getContent("+$(this)[0].id+")' >"+$(this)[0].title+"</a></span>" +
            "<span class='summary'>摘要："+$(this)[0].summary+"...</span>" +
            "<span class='info'>发表于"+$(this)[0].createTime+" &nbsp 阅读("+$(this)[0].clickHit+")</span>" +
            "<hr style='height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;' />"+
            "</li>";
    });
    ulHtml +="</ul>";
    $("#articleListDiv").html(ulHtml);
    var count = Math.ceil(data.total/size);
    var start = currentPage-2<1?1:currentPage-2;
    var end = start+4>count?count:start+4;
    var liHtml = "<li><a href='javascript:getArticleByPage(\""+condition+"\","+1+","+size+")'>首页</a></li>";
    if(currentPage == 1){    	
    	liHtml += "<li class='disabled'><a href='#'>上一页</a></li>";
    }else{
    	liHtml += "<li><a href='javascript:getArticleByPage(\""+condition+"\","+(currentPage-1)+","+size+")'>上一页</a></li>";
    }
    for ( var int = start; int <= end; int++) {
    	if(int == currentPage){
    		liHtml +="<li class='active'><a href='#'>"+(int)+"</a></li>";
    	}else{    		
    		liHtml +="<li><a href='javascript:getArticleByPage(\""+condition+"\","+int+","+size+")'>"+(int)+"</a></li>";
    	}
	}
    if(currentPage == count){
    	liHtml +="<li class='disabled'><a href='#'>下一页</a></li>";
    }else{
    	liHtml +="<li><a href='javascript:getArticleByPage(\""+condition+"\","+(currentPage+1)+","+size+")'>下一页</a></li>";
    }
    
    liHtml +="<li><a href='javascript:getArticleByPage(\""+condition+"\","+count+","+size+")'>尾页</a></li>";
    $("#pager").html(liHtml);
    resize();
   
}
function getContent(articleId){
    var obj ={
        "id":articleId
    }
    var url = "../../article/getContentById/"+articleId;
    $.ajax({
            url:url,
            success:function(data){
                showContent(data);
            },
            error:function(){
                alert("请求超时");
            }
        });
}
function showContent(data){
	$("#articleContentDiv").css("display","block");
	$("#articleList").css("display","none");
	var obj =eval("("+data+")");
	
	$("#articleInfo").html("发布时间：【"+obj.createTime+"】&nbsp;&nbsp;"+"阅读：("+obj.clickHit+")&nbsp;&nbsp; 评论：("+obj.replyNum+")");
	$("#articleTitle").html(obj.title);
	 $("#articleContent").html(obj.content);
	 resize();
}
function resize(){
	
	//$(window.parent.document).find("#mainIframe").load(function () {
	    var main = $(window.parent.document).find("#mainIframe");
	   var thisheight = $(document).height()+5;
	   console.info(thisheight)
	    main.height(thisheight);
	//});
}

function getDate(str){
    var date = str.substring(0,4);
    date += "年";
    date += str.substring(5,7);
    date += "月";
    date += str.substring(8,10);
    date += "日";
    return date;
}
function setIframeHeight(iframe) {
	if (iframe) {
	var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
	if (iframeWin.document.body) {
	iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
	}
	}
	};