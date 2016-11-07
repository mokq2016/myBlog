/**
 * Created by Administrator on 2016/10/3.
 */
$(function(){
    alert(1);
	getAllBlogType();
    
});
function getAllBlogType(){
    var url = "../../article/getAllArticleType";
    var data = "{data:1}";
    sendAajaxReruest(url,data,function(data){
        console.info(data)
    },function(){
        alert("请求超时");
    });
}