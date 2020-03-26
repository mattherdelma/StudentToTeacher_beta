package com.java.code.model;

public class ClassStudent {
    private String ClassId;
    private String ClassName;
    private String ClassCreateTime;

    public void setClassId(String classId) {
        ClassId = classId;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public void setClassCreateTime(String classCreateTime) {
        ClassCreateTime = classCreateTime;
    }

    public String getClassId() {
        return ClassId;
    }

    public String getClassName() {
        return ClassName;
    }

    public String getClassCreateTime() {
        return ClassCreateTime;
    }
}
