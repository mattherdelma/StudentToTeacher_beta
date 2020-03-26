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

function queryHandleHomeworkInfo( id,table)
{
    id=id.toString();
    createXMLHttpRequest();   //调用创建XMLHttpRequest对象的方法
    xmlHttp.onreadystatechange=callback;   //设置回调函数
    var url="queryonehandlehomework?table="+table+"&HandleHomeworkId="+id;

    alert("查询编号为："+id+"的文章详情？"+url);
    xmlHttp.open("post",url,true);      //向服务器端发送请求
    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");
    xmlHttp.send(null);
    function callback()
    {
        if(xmlHttp.readyState==4)
        {
            if(xmlHttp.status==200)
            {
                var data= xmlHttp.responseText;

                var parameters=data.split("||");
                var HandleHomeworkId=parameters[0]
                var HomeworkId=parameters[1];
                var StudentId=parameters[2];
                var Title=parameters[3];
                var Content=parameters[4]
                var HandleHomeworkCreateTime=parameters[5];



                document.getElementById("HandleHomeworkId").value=HandleHomeworkId;
                document.getElementById("HomeworkId").value=HomeworkId;
                document.getElementById("StudentId").value=StudentId;
                document.getElementById("Title").value=Title;
                document.getElementById("Content").value=Content;
                document.getElementById("HandleHomeworkCreateTime").value=HandleHomeworkCreateTime;


            }
        }
    }
}
