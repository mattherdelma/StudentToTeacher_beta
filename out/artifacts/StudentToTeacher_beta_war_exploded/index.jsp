<%@ page import="java.util.List" %>
<%@ page import="com.java.code.model.Administrators"%>
<%@ page import="com.java.code.model.Teacher"%>
<%@ page import="com.java.code.model.Student"%>
<%@ page import="com.java.code.jdbc.LoginJdbc"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>学生作业管理系统登录界面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="StudentHomeWorkManagerSystem" conten="width=device-width,initial-scale=1">
    <link type="text/css" href="css/Login1.css" rel="stylesheet"/>
    <link type="image/png" href="../images/favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="css/Login2.css">
    <script>
        if(self!=top)
        {
            parent.location.href='index.html';
        }
        function CheckLogin(obj){
            if(obj.username.value=='')
            {
                alert('请输入用户名');
                obj.username.focus();
                return false;
            }
            if(obj.password.value=='')
            {
                alert('请输入登录密码');
                obj.password.focus();
                return false;
        }
        return true;
    }
    </script>
</head>
<body>
<div class="container" align="center">
    <div class="col-md-6" style="margin-top: 20%;">
        <div class="inset">
            <form name="login" id="login" method="post" action="/login" onSubmit="return CheckLogin(document.login);">
                <input type="hidden" name="enews" value="login">
                <div>
                    <h2>学生作业管理系统</h2>

                    <span style="text-align: left;text-indent: 0.4em;"><img src="../images/UserName.png"><label>用户名</label></span>
                    <span><input type="text" name="username" class="textbox" ></span>
                </div>
                <div>

                    <span style="text-align: left;text-indent: 0.4em;"><img src="../images/UserPassword.png"><label>密码</label></span>
                    <span><input  name="password" type="password" class="password"></span>
                </div>
                <div>
                    <span style="text-align:left;text-indent: 0.4em;"><label>请输入验证码&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label><img src="../images/UserTestPic.png"></span>
                    <span><input name="check" type="text" class="checkBox" ></span>
                </div>
                <div style="padding-bottom:20px;">
                    <label class="checkbox-inline" style="padding-left:0px;color:blue;padding-right:10px;">
                        <input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="option1"checked>学生
                    </label>
                    <label class="checkbox-inline" style="padding-right:10px;">
                        <input type="radio" name="optionsRadiosinline" id="optionsRadios4" value="option2">教师
                    </label>
                    <label class="checkbox-inline">
                        <input type="radio" name="optionsRadiosinline" id="optionsRadios5" value="option3">管理员
                    </label>
                </div>
                <div class="sign">
                    <input type="submit" value="登录" class="submit" />
                    <input type="reset"  class="submit" value="重置"/>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    if(document.login.equestion.value==0)
    {
        showanswer.style.display='none';
    }
</script>
</body>
</html>