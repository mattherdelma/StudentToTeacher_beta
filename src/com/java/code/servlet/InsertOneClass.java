package com.java.code.servlet;

import com.java.code.jdbc.StudentClassJdbc;

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


@WebServlet("/insertoneclass")
public class InsertOneClass extends HttpServlet {
    public InsertOneClass() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Throwable var4 = null;

        try {
            String table = request.getParameter("table");
            System.out.println(table + "=================================================");
            StudentClassJdbc newsRealeseDao = new StudentClassJdbc();
            HashMap<String, String> addnews_list = new HashMap();
            addnews_list.put("ClassId", request.getParameter("ClassId"));
            addnews_list.put("ClassName", URLDecoder.decode(request.getParameter("ClassName"),"UTF-8"));
            addnews_list.put("ClassCreateTime", request.getParameter("ClassCreateTime"));
            System.out.println(addnews_list.toString());

            try {
                int result = newsRealeseDao.insertOneClass(addnews_list, table);
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}
