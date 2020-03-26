package com.java.code.jdbc;

import com.java.code.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
public class StudentJdbc {
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/homeworkmanager?useUnicode=true&characterEncoding=Utf-8";
    public static String databaseUser = "root";
    public static String password = "1234";

    private ArrayList getStudent(Statement statement,String sql) {
        ArrayList newsRealese = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student news = new Student();
                news.setStudentId(resultSet.getString("StudentId"));
                news.setStudentName(resultSet.getString("StudentName"));
                news.setStudentPassword(resultSet.getString("StudentPassword"));
                news.setStudentClass(resultSet.getString("StudentClass"));
                news.setStudentCreateTime(resultSet.getString("StudentCreateTime"));
                newsRealese.add(news);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return newsRealese;
        }
    }
    public ArrayList AdminQueryAllStudent ()
            throws Exception
    {
        Connection conn = null;
        ArrayList newsRealese = new ArrayList();
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,databaseUser,password);
            String sql = "select * from Student order by StudentCreateTime desc";
            Statement statement = conn.createStatement();
            newsRealese = getStudent(statement,sql);
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


    public static int insertOneStudent(HashMap<String, String> addnews_list, String table) throws Exception {//插入一个新的学生
        Connection conn = null;

        try {
            //获取连接
            Class.forName(driver);
            conn = DriverManager.getConnection(url, databaseUser, password);//不安全
            //运行SQL语句
            Statement stat = conn.createStatement();
            String sql = "insert into " + table + "  VALUES(?,?,?,?,?)";//获取ClassId，使用？代替字符串，以免会发生错误
            PreparedStatement ps = conn.prepareStatement(sql);
            // ps.setString(1, table);

            ps.setString(1, addnews_list.get("StudentId"));
            ps.setString(2, addnews_list.get("StudentName"));
            ps.setString(3, addnews_list.get("StudentPassword"));
            ps.setString(4, addnews_list.get("StudentClass"));
            ps.setString(5, addnews_list.get("StudentCreateTime"));

            System.out.println(addnews_list.get("StudentId") + "===============" + ps.toString());
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
