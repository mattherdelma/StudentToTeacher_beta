/**
 * 创建新老师
 * @type {XMLHttpRequest}
 */
var xmlHttp;
function createXMLHttpRequest()
{
    if (window.XMLHttpRequest) //在非IE浏览器中创建XMLHttpRequest对象
    {
        try{
            xmlHttp = new XMLHttpRequest();
        }
        catch(e){
            alert ("创建XMLHttpRequest失败！");
        }
    }
}

function addTeacher(username,table,destination)
{

    createXMLHttpRequest();   //调用创建XMLHttpRequest对象的方法
    xmlHttp.onreadystatechange=callback;   //设置回调函数
    var myDate = new Date();
    var nowtime=myDate.Format("yyyy-MM-dd hh:mm:ss");
    var idtime=myDate.Format("yyyyMMddhhmmss");

    var TeacherId=document.getElementById("TeacherId").value;
    var TeacherName=document.getElementById("TeacherName").value;
    var TeacherName_code = encodeURI(encodeURI(TeacherName));
    var TeacherPassword = document.getElementById("TeacherPassword").value;
    var url="insertoneteacher?table="+table+"&TeacherId="+TeacherId+"&TeacherName="+TeacherName_code+"&TeacherPassword="+TeacherPassword+"&TeacherCreateTime="+nowtime;
    alert(url);
    xmlHttp.open("post",url,true);      //向服务器端发送请求
    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");
    xmlHttp.send("TeacherId="+TeacherId);
    function callback()
    {
        if(xmlHttp.readyState==4)
        {
            if(xmlHttp.status==200)
            {

                var data= xmlHttp.responseText;
                data=data.toString();
                if(data=="successful")
                {

                    alert("创建成功");
                    window.location.href=destination;
                }
                else if(data=="failed")
                {
                    alert("创建失败，请重试");
                    location.reload();
                }


            }
        }
    }

}


function test() {

    var myDate = new Date();
    var nowtime=myDate.Format("yyyy-MM-dd hh:mm:ss");
    alert("正在创建新班级，请稍后......"+nowtime);
    var time=myDate.Format("yyyyMMddhhmmss");
    alert(time);
}

Date.prototype.Format = function(format){

    var o = {

        "M+" : this.getMonth()+1, //month

        "d+" : this.getDate(), //day

        "h+" : this.getHours(), //hour

        "m+" : this.getMinutes(), //minute

        "s+" : this.getSeconds(), //second

        "q+" : Math.floor((this.getMonth()+3)/3), //quarter

        "S" : this.getMilliseconds() //millisecond

    }

    if(/(y+)/.test(format)) {

        format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));

    }

    for(var k in o) {

        if(new RegExp("("+ k +")").test(format)) {

            format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));

        }

    }

    return format;

}
