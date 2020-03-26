package com.java.code.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.java.code.jdbc.LoginJdbc;
/**
 * 登录访问数据库核实
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String option=request.getParameter("optionsRadiosinline");
        LoginJdbc LoginJdbc=new LoginJdbc();
        try{
            if(option.equals("option3")) {
                boolean checkLogin = LoginJdbc.LoginSelect(username, password, "Administrators");
                if(checkLogin)
                {
                    HttpSession session=request.getSession();
                    session.setAttribute("username",username);//设置用户的姓名
                    //  response.sendRedirect("adminManager.jsp");
                    response.sendRedirect("addClass_admin.jsp");
                }
                else
                {
                    response.sendRedirect("index.jsp");
                }
            }
            else if(option.equals("option1"))
            {
                boolean checkLogin=LoginJdbc.LoginStudentSelect(username,password,"Student");
                if(checkLogin)
                {
                    HttpSession session=request.getSession();
                    session.setAttribute("username",username);//设置用户的姓名
                    //  response.sendRedirect("adminManager.jsp");
                    response.sendRedirect("student.jsp");
                }
                else
                {
                    response.sendRedirect("index.jsp");
                }
            }
            else if(option.equals("option2"))
            {
                boolean checkLogin=LoginJdbc.LoginTeacherSelect(username,password,"Teacher");
                if(checkLogin)
                {
                    HttpSession session=request.getSession();
                    session.setAttribute("username",username);//设置用户的姓名
                    //  response.sendRedirect("adminManager.jsp");
                    response.sendRedirect("teacher.jsp");
                }
                else
                {
                    response.sendRedirect("index.jsp");
                }
            }
        }catch(Exception ex)
        {
            Logger.getLogger(com.java.code.jdbc.LoginJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        processRequest(req,resp);
    }
    @Override
    public String getServletInfo(){ return "Short description"+"public String getServletInfo();";}
}
