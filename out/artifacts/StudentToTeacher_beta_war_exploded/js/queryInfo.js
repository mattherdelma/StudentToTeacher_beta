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

function queryInfo( id,table)
{
    id=id.toString();
    createXMLHttpRequest();   //调用创建XMLHttpRequest对象的方法
    xmlHttp.onreadystatechange=callback;   //设置回调函数
    var url="queryonehomework?table="+table+"&HomeworkId="+id;

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
                var HomeworkId=parameters[0]
                var TeacherId=parameters[1];
                var Title=parameters[2];
                var Content=parameters[3];
                var HomeworkCreateTime=parameters[4]
                var HomeworkDeadLine=parameters[5];



                document.getElementById("HomeworkId").value=HomeworkId;
                document.getElementById("TeacherId").value=TeacherId;
                document.getElementById("Title").value=Title;
                document.getElementById("Content").value=Content;
                document.getElementById("HomeworkCreateTime").value=HomeworkCreateTime;
                document.getElementById("HomeworkDeadLine").value=HomeworkDeadLine;


            }
        }
    }
}
