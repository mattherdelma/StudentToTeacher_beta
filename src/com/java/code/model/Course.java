package com.java.code.model;

public class Course {
    private String CourseId;
    private String CourseName;
    private String CourseTeacherId;
    private String CourseCreateTime;

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public void setCourseTeacherId(String CourseteacherId) {
        CourseTeacherId = CourseteacherId;
    }

    public void setCourseCreateTime(String courseCreateTime) {
        CourseCreateTime = courseCreateTime;
    }

    public String getCourseId() {
        return CourseId;
    }

    public String getCourseName() {
        return CourseName;
    }

    public String getCourseTeacherId() {
        return CourseTeacherId;
    }

    public String getCourseCreateTime() {
        return CourseCreateTime;
    }
}
