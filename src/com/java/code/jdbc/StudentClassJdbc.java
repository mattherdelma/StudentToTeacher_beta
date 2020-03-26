package com.java.code.jdbc;

import com.java.code.model.ClassStudent;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
public class StudentClassJdbc {
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/homeworkmanager?useUnicode=true&characterEncoding=Utf-8";
    public static String databaseUser = "root";
    public static String password = "1234";

    private ArrayList getStudentClass(Statement statement,String sql) {
        ArrayList newsRealese = new ArrayList();
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ClassStudent news = new ClassStudent();
                news.setClassId(resultSet.getString("ClassId"));
                news.setClassName(resultSet.getString("ClassName"));
                news.setClassCreateTime(resultSet.getString("ClassCreateTime"));
                newsRealese.add(news);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return newsRealese;
        }
    }
        public ArrayList AdminQueryAllStudentClass ()
            throws Exception
        {
            Connection conn = null;
            ArrayList newsRealese = new ArrayList();
            try{
                Class.forName(driver);
                conn = DriverManager.getConnection(url,databaseUser,password);
                String sql = "select * from Class order by ClassCreateTime desc";
                Statement statement = conn.createStatement();
                newsRealese = getStudentClass(statement,sql);
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


    public static int insertOneClass(HashMap<String, String> addnews_list, String table) throws Exception {//插入一个新的班级
        Connection conn = null;

        try {
            //获取连接
            Class.forName(driver);
            conn = DriverManager.getConnection(url, databaseUser, password);//不安全
            //运行SQL语句
            Statement stat = conn.createStatement();
            String sql = "insert into " + table + "  VALUES(?,?,?)";//获取ClassId，使用？代替字符串，以免会发生错误
            PreparedStatement ps = conn.prepareStatement(sql);
            // ps.setString(1, table);

            ps.setString(1, addnews_list.get("ClassId"));
            ps.setString(2, addnews_list.get("ClassName"));
            ps.setString(3, addnews_list.get("ClassCreateTime"));


            System.out.println(addnews_list.get("ClassId") + "===============" + ps.toString());
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
