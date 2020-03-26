package com.java.code.jdbc;

import com.java.code.model.Administrators;

import java.sql.*;

/**
 * 登录数据库
 */
public class LoginJdbc {
    public static String driver = "com.mysql.jdbc.Driver";//定义驱动
    public static String url = "jdbc:mysql://localhost:3306/homeworkmanager?useUnicode=true&characterEncoding=utf-8";//定义URL
    public static String databseUser = "root";//定义用户名
    public static String password = "1234";//定义密码
    public boolean LoginSelect(String user, String pass, String table) throws Exception {//登录验证  table表示从哪个表中查询
        Connection conn = null;
        //获取连接
        Class.forName(driver);


        String sql = "select AdminPassword from " + table + " where AdminId='" + user + "'";
        System.out.println(sql);
        try {
            conn = DriverManager.getConnection(url, databseUser, password);//不安全
            System.out.println("建立database连接");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString("AdminPassword").equals(pass))
                    return true;
                else
                    return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }


    public boolean LoginTeacherSelect(String user, String pass, String table) throws Exception {//登录验证  table表示从哪个表中查询
        Connection conn = null;
        //获取连接
        Class.forName(driver);


        String sql = "select TeacherPassword from " + table + " where TeacherId='" + user + "'";
        System.out.println(sql);
        try {
            conn = DriverManager.getConnection(url, databseUser, password);//不安全
            System.out.println("建立database连接");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString("TeacherPassword").equals(pass))
                    return true;
                else
                    return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean LoginStudentSelect(String user, String pass, String table) throws Exception {//登录验证  table表示从哪个表中查询
        Connection conn = null;
        //获取连接
        Class.forName(driver);


        String sql = "select StudentPassword from " + table + " where StudentId='" + user + "'";
        System.out.println(sql);
        try {
            conn = DriverManager.getConnection(url, databseUser, password);//不安全
            System.out.println("建立database连接");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString("StudentPassword").equals(pass))
                    return true;
                else
                    return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
