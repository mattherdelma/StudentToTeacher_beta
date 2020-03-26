package com.java.code.jdbc;

import com.java.code.model.Homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentHomeworkJdbc {

    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/homeworkmanager?useUnicode=true&characterEncoding=Utf-8";
    public static String databaseUser = "root";
    public static String password = "1234";


    public HashMap<String, String> queryOneHomework(String HomeworkId, String table) throws SQLException {
        Connection connection = null;
        HashMap<String, String> rt = new HashMap<>();
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, databaseUser, password);
            String sql = "select * from " + table + " where HomeworkId='" + HomeworkId + "'";


            Statement ps = connection.createStatement();

            System.out.println("将要执行的=====" + sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                rt.put("HomeworkId", rs.getString("HomeworkId"));
                rt.put("TeacherId", rs.getString("TeacherId"));
                rt.put("Title", rs.getString("Title"));
                rt.put("Content", rs.getString("Content"));
                rt.put("HomeworkCreateTime", rs.getString("HomeworkCreateTime"));
                rt.put("HomeworkDeadLine", rs.getString("HomeworkDeadLine"));

                return rt;
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

        return rt;

    }


    private ArrayList getHomework(Statement statement, String sql) {
        ArrayList newsRealese = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Homework news = new Homework();
                news.setHomeworkId(resultSet.getString("HomeworkId"));
                news.setTeacherId(resultSet.getString("TeacherId"));
                news.setTitle(resultSet.getString("Title"));
                news.setContent(resultSet.getString("Content"));
                news.setHomeworkCreateTime(resultSet.getString("HomeworkCreateTime"));
                news.setHomeworkDeadLine(resultSet.getString("HomeworkDeadLine"));
                newsRealese.add(news);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return newsRealese;
        }
    }
    public ArrayList StudentQueryAllHomework (String StudentId)
            throws Exception
    {
        Connection conn = null;
        ArrayList newsRealese = new ArrayList();
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,databaseUser,password);
            String sql = "select * from homework where homework.teacherid in (select course.courseteacherid from course where course.courseid in (select course_class.CourseId from course_class where course_class.ClassId IN (select student.StudentClass from student where studentId = '"+StudentId+"')))";
            Statement statement = conn.createStatement();
            newsRealese = getHomework(statement,sql);
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                    conn=null;
                }
            }catch(Exception ex){}
            return newsRealese;
        }
    }

}