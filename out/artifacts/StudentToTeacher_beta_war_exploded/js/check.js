var xmlHttp=false;
function createXMLHttpRequest()
{
    if (window.ActiveXObject)  //在IE浏览器中创建XMLHttpRequest对象
    {
        try{
            xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
        }
        catch(e){
            try{
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            catch(ee){
                xmlHttp=false;
            }
        }
    }
    else if (window.XMLHttpRequest) //在非IE浏览器中创建XMLHttpRequest对象
    {
        try{
            xmlHttp = new XMLHttpRequest();
        }
        catch(e){
            xmlHttp=false;
        }
    }
}
function check(table1) {
    var HomeworkCreateTime = document.getElementById("HomeworkCreateTime").value;
    var HomeworkDeadLine = document.getElementById("HomeworkDeadLine").value;
    var HandleHomeworkCreateTime = document.getElementById("HandleHomeworkCreateTime").value;
    xmlHttp.onreadystatechange = callback2;   //设置回调函数
    var url2 = "checktime?HandleHomeworkCreateTime=" + HandleHomeworkCreateTime + "&HomeworkCreateTime=" + HomeworkCreateTime + "&HomeworkDeadLine=" + HomeworkDeadLine;
    alert(url2);
    xmlHttp.open("post", url2, true);      //向服务器端发送请求
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf8");
    xmlHttp.send(null);

    function callback2() {
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
                var data = xmlHttp.responseText;
                document.getElementById("OutOfTime").value=data.toString();
            }
        }
    }
}