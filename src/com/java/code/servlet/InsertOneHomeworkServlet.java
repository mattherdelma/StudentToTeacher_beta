package com.java.code.servlet;


import com.java.code.jdbc.HomeworkJdbc;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet("/insertonehomework")
public class InsertOneHomeworkServlet extends HttpServlet {
    public InsertOneHomeworkServlet() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Throwable var4 = null;

        try {
            String table = request.getParameter("table");
            System.out.println(table + "=================================================");
            HomeworkJdbc newsRelese = new HomeworkJdbc();
            HashMap<String, String> addnews_list = new HashMap();
            addnews_list.put("HomeworkId", request.getParameter("HomeworkId"));
            System.out.println(addnews_list.toString());
            addnews_list.put("TeacherId", request.getParameter("TeacherId"));
            System.out.println(addnews_list.toString());
            addnews_list.put("Title",URLDecoder.decode(request.getParameter("Title"),"UTF-8"));
            System.out.println(addnews_list.toString());
            addnews_list.put("Content",URLDecoder.decode(request.getParameter("Content"),"UTF-8"));
            System.out.println(addnews_list.toString());
            addnews_list.put("HomeworkCreateTime", request.getParameter("HomeworkCreateTime"));
            System.out.println(addnews_list.toString());
            addnews_list.put("HomeworkDeadLine",request.getParameter("HomeworkDeadLine"));
            System.out.println(addnews_list.toString());

            try {
                int result = newsRelese.insertOneHomework(addnews_list, table);
                System.out.println(result);
                if (result != 0) {
                    out.write("successful");
                } else {
                    out.write("failed");
                }
            } catch (Exception var17) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, (String)null, var17);//??
            }
        } catch (Throwable var18) {
            var4 = var18;
            throw var18;
        } finally {
            if (out != null) {
                if (var4 != null) {
                    try {
                        out.close();
                    } catch (Throwable var16) {
                        var4.addSuppressed(var16);
                    }
                } else {
                    out.close();
                }
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}
