package com.java.code.jdbc;

import com.java.code.model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TeacherJdbc {
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/homeworkmanager?useUnicode=true&characterEncoding=Utf-8";
    public static String databaseUser = "root";
    public static String password = "1234";

    private ArrayList getTeacher(Statement statement, String sql) {
        ArrayList newsRealese = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Teacher news = new Teacher();
                news.setTeacherId(resultSet.getString("TeacherId"));
                news.setTeacherName(resultSet.getString("TeacherName"));
                news.setTeacherPassword(resultSet.getString("TeacherPassword"));
                news.setTeacherCreateTime(resultSet.getString("TeacherCreateTime"));
                newsRealese.add(news);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return newsRealese;
        }
    }
    public ArrayList AdminQueryAllTeacher ()
            throws Exception
    {
        Connection conn = null;
        ArrayList newsRealese = new ArrayList();
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,databaseUser,password);
            String sql = "select * from Teacher order by TeacherCreateTime desc";
            Statement statement = conn.createStatement();
            newsRealese = getTeacher(statement,sql);
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


    public static int insertOneTeacher(HashMap<String, String> addnews_list, String table) throws Exception {//插入一个新的老师
        Connection conn = null;

        try {
            //获取连接
            Class.forName(driver);
            conn = DriverManager.getConnection(url, databaseUser, password);//不安全
            //运行SQL语句
            Statement stat = conn.createStatement();
            String sql = "insert into " + table + "  VALUES(?,?,?,?)";//获取ClassId，使用？代替字符串，以免会发生错误
            PreparedStatement ps = conn.prepareStatement(sql);
            // ps.setString(1, table);

            ps.setString(1, addnews_list.get("TeacherId"));
            ps.setString(2, addnews_list.get("TeacherName"));
            ps.setString(3, addnews_list.get("TeacherPassword"));
            ps.setString(4, addnews_list.get("TeacherCreateTime"));

            System.out.println(addnews_list.get("TeacherId") + "===============" + ps.toString());
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
