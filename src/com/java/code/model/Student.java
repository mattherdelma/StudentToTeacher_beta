package com.java.code.model;

/**
 * 学生模型
 */
public class Student {
    private String StudentId;
    private String StudentName;
    private String StudentPassword;
    private String StudentCreateTime;
    private String StudentClassId;

    public void setStudentCreateTime(String studentCreateTime) {
        StudentCreateTime = studentCreateTime;
    }

    public String getStudentCreateTime() {
        return StudentCreateTime;
    }

    public void setStudentClass(String studentClassId) {
        StudentClassId = studentClassId;
    }

    public String getStudentClassId() {
        return StudentClassId;
    }


    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public void setStudentName(String studentUserName) {
        StudentName = studentUserName;
    }

    public void setStudentPassword(String studentUserPassword) {
        StudentPassword = studentUserPassword;
    }



    public String getStudentId() {
        return StudentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public String getStudentPassword() {
        return StudentPassword;
    }


}
