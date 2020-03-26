package com.java.code.servlet;

import com.java.code.jdbc.DeleteJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/deleteoneclass")

public class DeleteOneClass extends HttpServlet{
    public DeleteOneClass()
    {}
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String ClassId=request.getParameter("ClassId");
        DeleteJdbc newsRealeseDao = new DeleteJdbc();
        System.out.println(ClassId);
        try{
            String sql = "delete from class where classid='"+ClassId+"'";
            System.out.println(sql);
            int result=newsRealeseDao.Delete(sql);
            if (result != 0) {
                out.write("successful");
            } else {
                out.write("failed");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo(){ return "Short description"+"public String getServletInfo();";}
}
