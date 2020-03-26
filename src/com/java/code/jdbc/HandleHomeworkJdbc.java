package com.java.code.jdbc;

import com.java.code.model.HandleHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class HandleHomeworkJdbc {

    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/homeworkmanager?useUnicode=true&characterEncoding=Utf-8";
    public static String databaseUser = "root";
    public static String password = "1234";


    public HashMap<String, String> queryOneHandleHomework(String HandleHomeworkId, String table) throws SQLException {
        Connection connection = null;
        HashMap<String, String> rt = new HashMap<>();
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, databaseUser, password);
            String sql = "select * from " + table + " where HandleHomeworkId='" + HandleHomeworkId + "'";


            Statement ps = connection.createStatement();

            System.out.println("将要执行的=====" + sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                rt.put("HandleHomeworkId", rs.getString("HandleHomeworkId"));
                rt.put("HomeworkId",rs.getString("HomeworkId"));
                rt.put("StudentId", rs.getString("StudentId"));
                rt.put("Title", rs.getString("Title"));
                rt.put("Content", rs.getString("Content"));
                rt.put("HandleHomeworkCreateTime", rs.getString("HandleHomeworkCreateTime"));

                return rt;
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

        return rt;

    }


    private ArrayList getHandleHomework(Statement statement, String sql) {
        ArrayList newsRealese = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                HandleHomework news = new HandleHomework();
                news.setHandleHomeworkId(resultSet.getString("HandleHomeworkId"));
                news.setHomeworkId(resultSet.getString("HomeworkId"));
                news.setStudentId(resultSet.getString("StudentId"));
                news.setTitle(resultSet.getString("Title"));
                news.setContent(resultSet.getString("Content"));
                news.setHandleHomeworkCreateTime(resultSet.getString("HandleHomeworkCreateTime"));
                newsRealese.add(news);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return newsRealese;
        }
    }
    public ArrayList AdminQueryAllHandleHomework ()
            throws Exception
    {
        Connection conn = null;
        ArrayList newsRealese = new ArrayList();
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,databaseUser,password);
            String sql = "select * from HandleHomework order by HandleHomeworkCreateTime desc";
            Statement statement = conn.createStatement();
            newsRealese = getHandleHomework(statement,sql);
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



    public ArrayList TeacherQueryAllHandleHomework (String TeacherId)
            throws Exception
    {
        Connection conn = null;
        ArrayList newsRealese = new ArrayList();
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,databaseUser,password);
            String sql = "select * from handlehomework where homeworkid in( select homework.homeworkid from homework where homework.teacherid = '"+TeacherId+"');";
            Statement statement = conn.createStatement();
            newsRealese = getHandleHomework(statement,sql);
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

    public static int insertOneHandleHomework(HashMap<String, String> addnews_list, String table) throws Exception {//插入一个新的学生
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

            ps.setString(1, addnews_list.get("HandleHomeworkId"));
            ps.setString(2, addnews_list.get("HomeworkId"));
            ps.setString(3, addnews_list.get("StudentId"));
            ps.setString(4, addnews_list.get("Title"));
            ps.setString(5, addnews_list.get("Content"));
            ps.setString(6, addnews_list.get("HandleHomeworkCreateTime"));

            System.out.println(addnews_list.get("HandleHomeworkId") + "===============" + ps.toString());
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