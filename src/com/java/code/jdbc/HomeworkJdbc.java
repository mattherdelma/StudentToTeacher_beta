package com.java.code.jdbc;

import com.java.code.model.Homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class HomeworkJdbc {

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
    public ArrayList AdminQueryAllHomework ()
            throws Exception
    {
        Connection conn = null;
        ArrayList newsRealese = new ArrayList();
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,databaseUser,password);
            String sql = "select * from Homework order by HomeworkCreateTime desc";
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


    public static int insertOneHomework(HashMap<String, String> addnews_list, String table) throws Exception {//插入一个新的学生
        Connection conn = null;

        try {
            //获取连接
            Class.forName(driver);
            conn = DriverManager.getConnection(url, databaseUser, password);//不安全
            //运行SQL语句
            Statement stat = conn.createStatement();
            String sql = "insert into " + table + "  VALUES(?,?,?,?,?,?)";//获取ClassId，使用？代替字符串，以免会发生错误
            PreparedStatement ps = conn.prepareStatement(sql);
            // ps.setString(1, table);

            ps.setString(1, addnews_list.get("HomeworkId"));
            ps.setString(2, addnews_list.get("TeacherId"));
            ps.setString(3, addnews_list.get("Title"));
            ps.setString(4, addnews_list.get("Content"));
            ps.setString(5, addnews_list.get("HomeworkCreateTime"));
            ps.setString(6, addnews_list.get("HomeworkDeadLine"));

            System.out.println(addnews_list.get("HomeworkId") + "===============" + ps.toString());
            int i = ps.executeUpdate();
            System.out.println("成功添加" + i + "行");
            stat.close();
            conn.close();
            return i;
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {//关闭连接
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (Exception ex) {
            }
        }
        return 0;
    }
}