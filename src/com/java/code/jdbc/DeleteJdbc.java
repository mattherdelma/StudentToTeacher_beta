package com.java.code.jdbc;

import java.sql.*;
public class DeleteJdbc {
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/homeworkmanager?useUnicode=true&characterEncoding=Utf-8";
    public static String databaseUser = "root";
    public static String password = "1234";
    public static int Delete(String sql) throws Exception {
        Connection conn = null;
        try {
            //获取连接
            Class.forName(driver);
            conn = DriverManager.getConnection(url, databaseUser, password);//不安全
            //运行SQL语句
            Statement ps = conn.createStatement();
            ps.executeUpdate(sql);
            return 1;
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {//关闭连接
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
            }
        }
        return 0;
    }

}