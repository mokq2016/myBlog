$(function(){
	getAllArticleType(); 
	getAllArticleByTime();
});
function getAllArticleType(){
    var url = "../articleType/getAllTypeCountArticle";
    var data = "你好";
    sendAajaxReruest(url,data,function(data){
        var html = "<ul>";
       $(data).each(function(){
           html += "<li><a  target='right' href='javascript:void(0)'onclick='javascript:getArticleByCondition("+$(this)[0].id+")' >"+$(this)[0].articleType+"("+$(this)[0].count+")</a></li>";
       });
        html += "</ul>";
        $("#blogTypeDiv").html(html);
    },function(){
        alert("请求超时");
    });
   
}
function getAllArticleByTime(){
    var url = "../article/getAllArticleByTime";
    var data = "你好";
    sendAajaxReruest(url,data,function(data){
        var html = "<ul>";
       $(data).each(function(){
           html += "<li><a href='javascript:void(0)' onclick='javascript:getArticleByCondition(\""+$(this)[0].time+"\")' target='right'>"+getTimeStr($(this)[0].time)+"("+$(this)[0].count+")</a></li>";
       });
        html += "</ul>";
        $("#articleTimeDiv").html(html);
    },function(){
        alert("请求超时");
    });
   
}
function getArticleByCondition(condition){
	right.window.getArticleByPage(condition,1,10);
	
}
function getTimeStr(time){
	var timeStr = time.replace("-","年");
	return timeStr+"月";
}
