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

function checkTime(table1)
{
    var HandleHomeworkCreateTime = document.getElementById("HandleHomeworkCreateTime").value;
    var HomeworkId = document.getElementById("HomeworkId").value;
    createXMLHttpRequest();   //调用创建XMLHttpRequest对象的方法
    xmlHttp.onreadystatechange=callback;   //设置回调函数
    var url="queryonehomework?table="+table1+"&HomeworkId="+HomeworkId;
    alert(url);
    xmlHttp.open("post",url,true);      //向服务器端发送请求
    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");
    xmlHttp.send(null);
    var data= xmlHttp.responseText;
    var parameters=data.split("||");
    var HomeworkCreateTime = parameters[4];
    var HomeworkDeadLine=parameters[5];
    document.getElementById("HomeworkCreateTime").value=HomeworkCreateTime;
    document.getElementById("HomeworkDeadLine").value=HomeworkDeadLine;
    function callback()
    {
        if(xmlHttp.readyState==4)
        {
            if(xmlHttp.status==200)
            {
                var data= xmlHttp.responseText;
                var parameters=data.split("||");
                var HomeworkCreateTime = parameters[4];
                var HomeworkDeadLine=parameters[5];
                document.getElementById("HomeworkCreateTime").value=HomeworkCreateTime;
                document.getElementById("HomeworkDeadLine").value=HomeworkDeadLine;
            }
        }
    }
}

