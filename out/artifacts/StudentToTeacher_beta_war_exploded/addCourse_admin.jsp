<%@ page import="com.java.code.jdbc.CourseJdbc"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.java.code.model.Course" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link type="image/png" href="images/favicon.ico" rel="shortcut icon">
    <title>管理员界面</title>
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

    <script type=text/javascript src=js/addCourse.js></script>
</head>
<% String administorName = (String) session.getAttribute("username");
    CourseJdbc jdbc = new CourseJdbc();
    ArrayList newsRealese = jdbc.AdminQueryAllCourse();
%>
<body>
<div id="panelwrap">

    <div class="header">
        <div class="title"><a href="#">学生作业管理系统</a></div>

        <div class="header_right">欢迎 ${username},  <a href="index.jsp" class="logout">退出</a>
        </div>

        <div class="menu">
            <ul>
                <li><a href="addClass_admin.jsp">班级</a></li>
                <li><a href="addStudent_admin.jsp">学生</a></li>
                <li><a href="addTeacher_admin.jsp">老师</a></li>
                <li><a href="addCourse_admin.jsp" class="selected">课程</a></li>
                <li><a href="addCourse_Class_admin.jsp">课程与班级关联</a></li>
            </ul>
        </div>

    </div>

    <div class="submenu">
        <ul>
            <li><a href="#">主页</a></li>
            <li><a href="#">班级</a></li>
            <li><a href="#">学生</a></li>
            <li><a href="#">老师</a></li>
            <li><a href="#" class="selected">课程</a></li>
            <li><a href="#">课程与班级关联</a></li>
        </ul>
    </div>

    <div class="center_content">

        <div id="right_wrap">
            <div id="right_content">
                <h2>老师列表</h2>


                <table id="rounded-corner">
                    <thead>
                    <tr>
                        <th></th>
                        <th>课程编号</th>
                        <th>课程名</th>
                        <th>授课老师</th>
                        <th>创建时间</th>
                        <th>删除</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <td colspan="12">以上是所有的课程</td>
                    </tr>
                    </tfoot>
                    <tbody>
                    <%
                        for (int i = 0; i < newsRealese.size(); i++) {
                            Course tem = (Course) newsRealese.get(i);
                    %>
                    <tr class="odd">
                        <td><input type="checkbox" name=""/></td>
                        <td><%=tem.getCourseId()%>
                        </td>
                        <td><%=tem.getCourseName()%>
                        </td>
                        <td><%=tem.getCourseTeacherId()%>
                        </td>
                        <td><%=tem.getCourseCreateTime()%>
                        </td>
                        <td><a href="#"><img src="images/trash.gif" alt="" title="" border="0"
                                             onclick="javascrtpt:window.location.href = 'deleteonecourse?CourseId=<%=tem.getCourseId()%>'"/></a>
                        </td>
                    </tr>


                    <%
                        }
                    %>
                    </tbody>
                </table>


                <ul id="tabsmenu" class="tabsmenu">
                    <li class="active"><a href="#tab1">创建新课程</a></li>

                </ul>
                <div id="tab1" class="tabcontent">
                    <h3>详细信息</h3>
                    <div class="form">

                        <div class="form_row">
                            <label>课程ID:</label>
                            <input type="text" class="form_input" id="CourseId">
                        </div>
                        <div class="form_row">
                            <label>课程名:</label>
                            <input type="text" class="form_input" id="CourseName">
                        </div>
                        <div class="form_row">
                            <label>授课教师ID:</label>
                            <input type="text" class="form_input" id="CourseTeacherId">
                        </div>
                        <div class="form_row">
                            <input type="submit" class="form_submit" value="提交发布" onclick="addCourse('${username}','Course','addCourse_admin.jsp')">
                        </div>

                        <div class="clear"></div>
                    </div>
                </div>





















                <!--以下可以扩展------------------------------------------------------------------------>








                <div class="toogle_wrap">
                    <div class="trigger"><a href="#">Java Web   学生作业管理系统</a></div>

                    <div class="toggle_container">
                        <p>
                            在本页面您能够查看所有的老师，您可以点击“创建新老师”按钮来创建新的老师；
                            对于需要删除的老师，您可以删除该老师，老师将无法加入课程并将从系统中删除。
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
                在本页面您能够查看所有的老师，您可以点击“创建新老师”按钮来创建新的老师；
                对于需要删除的老师，您可以删除该老师，老师将无法加入课程并将从系统中删除。
            </div>

        </div>


        <div class="clear"></div>
    </div> <!--end of center_content-->



</div>


</body>
</html>