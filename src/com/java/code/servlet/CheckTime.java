package com.java.code.servlet;

import com.java.code.jdbc.HandleHomeworkJdbc;
import com.java.code.jdbc.LoginJdbc;
import com.java.code.model.Homework;
import com.java.code.jdbc.HomeworkJdbc;
import com.java.code.servlet.LoginServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/checktime")

public class CheckTime extends HttpServlet{
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String HandleHomeworkCreateTime=request.getParameter("HandleHomeworkCreateTime");
        String HomeworkCreateTime=request.getParameter("HomeworkCreateTime");
        String HomeworkDeadLineTime=request.getParameter("HomeworkDeadLine");
        System.out.println(HandleHomeworkCreateTime);
        System.out.println(HomeworkCreateTime);
        System.out.println(HomeworkDeadLineTime);
        try{
            int hour = calculateTimeDifferenceBySimpleDateFormat(HomeworkCreateTime,HandleHomeworkCreateTime);
            if(hour<=Integer.parseInt(HomeworkDeadLineTime))
                out.write("未超时");
                else
                out.write("超时");

        }catch(Exception ex)
        {
            Logger.getLogger(com.java.code.jdbc.LoginJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int calculateTimeDifferenceBySimpleDateFormat(String starttime,String endtime) throws ParseException {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date fromDate2 = simpleFormat.parse(starttime);
        Date toDate2 = simpleFormat.parse(endtime);
        long from2 = fromDate2.getTime();
        long to2 = toDate2.getTime();
        int hours = (int) ((to2 - from2) / (1000 * 60 * 60));
        System.out.println("两个时间之间的小时差为：" + hours);
        return hours;
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
    @Override
    public String getServletInfo(){ return "Short description"+"public String getServletInfo();";}
}

