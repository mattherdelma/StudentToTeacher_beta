package com.java.code.model;

/**
 * 教师模型
 */
public class Teacher {
    private String TeacherId;
    private String TeacherName;
    private String TeacherPassword;
    private String TeacherCreateTime;

    public void setTeacherCreateTime(String teacherCreateTime) {
        TeacherCreateTime = teacherCreateTime;
    }

    public String getTeacherCreateTime() {
        return TeacherCreateTime;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public String getTeacherPassword() {
        return TeacherPassword;
    }


    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public void setTeacherPassword(String teacherPassword) {
        TeacherPassword = teacherPassword;
    }


}
