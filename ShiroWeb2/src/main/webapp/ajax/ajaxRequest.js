/**
 * Created by Administrator on 2016/10/3.
 */
function sendAajaxReruest(url,data,secc,error){
    $.ajax({
        url:url,
        data:"data="+JSON.stringify(data),
        type:"post",
        dataType: "json",
        timeout: 6000,// 超过此时间，报错
        beforeSend:function(XMLHttpRequest){},
        success:secc,
        error:error
    });
}