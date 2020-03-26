package com.java.code.servlet;

import com.java.code.model.Homework;
import com.java.code.jdbc.HomeworkJdbc;
import com.java.code.servlet.LoginServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/queryonehomework")
public class QueryOneHomework extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String HomeworkId= request.getParameter("HomeworkId");
            String table=request.getParameter("table");
            System.out.println(HomeworkId+table);
            HomeworkJdbc jdbc = new HomeworkJdbc();
            try {
                HashMap<String,String> result = jdbc.queryOneHomework(HomeworkId,table);


                if (result.size()==0) {
                    System.out.println("查询失败========================QueryOneNews");
                    // response.sendRedirect("a_queryNewsfailed.jsp");


                } else {
                    String data=result.get("HomeworkId")+"||"+result.get("TeacherId")+"||"+result.get("Title")+"||"+result.get("Content")+"||"+result.get("HomeworkCreateTime")+"||"+result.get("HomeworkDeadLine");
                    System.out.println(data);
                    out.write(data.toString());
                }
            } catch (Exception ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}