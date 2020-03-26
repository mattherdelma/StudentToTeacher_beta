<%@ page import="com.java.code.jdbc.HandleHomeworkJdbc"%>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link type="image/png" href="images/favicon.ico" rel="shortcut icon">
    <title>学生界面</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link href='#' rel='stylesheet' type='text/css'>
    <!-- jQuery file -->
    <script type="text/javascript">
        var $ = jQuery.noConflict();
        $(function () {
            $('#tabsmenu').tabify();
            $(".toggle_container").hide();
            $(".trigger").click(function () {
                $(this).toggleClass("active").next().slideToggle("slow");
                return false;
            });
        });
    </script>

    <script type=text/javascript src=js/addHandleHomework.js></script>
</head>
<% String administorName = (String) session.getAttribute("username");
    HandleHomeworkJdbc jdbc = new HandleHomeworkJdbc();
    ArrayList newsRealese = jdbc.AdminQueryAllHandleHomework();
%>
<body>
<div id="panelwrap">

    <div class="header">
        <div class="title"><a href="#">学生作业管理系统（学生版）</a></div>

        <div class="header_right">欢迎 ${username},  <a href="index.jsp" class="logout">退出</a>
        </div>

        <div class="menu">
            <ul>
                <li><a href="student.jsp">主页</a></li>
                <li><a href="addHandleHomework.jsp" class="selected">提交作业</a></li>
                <li><a href="checkHomeworkEvaluate.jsp">查看评语 </a></li>
            </ul>
        </div>

    </div>

    <div class="submenu">
        <ul>
            <li><a href="#">主页</a></li>
            <li><a href="#"  class="selected">提交作业</a></li>
            <li><a href="#">查看评语</a></li>
        </ul>
    </div>


    <div class="center_content">

        <div id="right_wrap">
            <div id="right_content">

                <ul id="tabsmenu" class="tabsmenu">
                    <li class="active"><a href="#tab1">发布新答案</a></li>

                </ul>
                <div id="tab1" class="tabcontent">
                    <h3>答案信息</h3>
                    <div class="form">
                        <div class="form_row">
                            <label>学生Id:</label>
                            <input type="text" class="form_input" id="StudentId" value='${username}'  readonly/>
                        </div>
                        <div class="form_row">
                            <label>作业Id:</label>
                            <input type="text" class="form_input" id="HomeworkId" value=""/>
                        </div>
                        <div class="form_row">
                            <label>标题:</label>
                            <input type="text" class="form_input" id="Title" value=""/>
                        </div>

                        <div class="form_row">
                            <label>内容:</label>
                            <textarea rows="100" class="form_textarea" id="Content"  value=""></textarea>
                        </div>

                        <div class="form_row">
                            <input type="submit" class="form_submit" value="提交发布" onclick="addHandleHomework('${username}','HandleHomework','addHandleHomework.jsp')">
                        </div>

                        <div class="clear"></div>
                    </div>
                </div>





















                <!--以下可以扩展------------------------------------------------------------------------>








                <div class="toogle_wrap">
                    <div class="trigger"><a href="#">Java Web   学生作业管理系统</a></div>

                    <div class="toggle_container">
                        <p>
                            在本页面您能够查看所有的课程，您可以点击“创建新班级”按钮来创建新的班级；
                            对于需要删除的课程，您可以删除该课程，课程将无法被学生加入并将从系统中删除。
                        </p>
                    </div>
                </div>

            </div>
        </div><!-- end of right content-->


        <div class="sidebar" id="sidebar">
            <h2>浏览分类</h2>

            <ul>
                <li><a href="#" class="selected">主页</a></li>
                <li><a href="#">模板设置</a></li>
                <li><a href="#">添加界面</a></li>
                <li><a href="#">编辑界面</a></li>
                <li><a href="#">范本</a></li>
                <li><a href="#">客户群</a></li>
            </ul>

            <h2>页面部分</h2>

            <ul>
                <li><a href="#">编辑界面</a></li>
                <li><a href="#">范本</a></li>
                <li><a href="#">客户群</a></li>
                <li><a href="#">文档与资讯</a></li>
            </ul>

            <h2>用户设置</h2>

            <ul>
                <li><a href="#">修改密码</a></li>
                <li><a href="#">修改用户名</a></li>
                <li><a href="#">添加管理员</a></li>
                <li><a href="#">帮助</a></li>
            </ul>

            <h2>文本提示</h2>
            <div class="sidebar_section_text">
                在本页面您能够查看所有的课程，您可以点击“创建新班级”按钮来创建新的班级；
                对于需要删除的课程，您可以删除该课程，课程将无法被学生加入并将从系统中删除。
            </div>

        </div>


        <div class="clear"></div>
    </div> <!--end of center_content-->



</div>


</body>
</html>