package com.java.code.model;

public class Homework {
    private String HomeworkId;
    private String TeacherId;
    private String Title;
    private String Content;
    private String HomeworkCreateTime;
    private String HomeworkDeadLine;

    public void setHomeworkId(String homeworkId) {
        HomeworkId = homeworkId;
    }

    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setHomeworkCreateTime(String homeworkCreateTime) {
        HomeworkCreateTime = homeworkCreateTime;
    }

    public void setHomeworkDeadLine(String homeworkDeadLine) {
        HomeworkDeadLine = homeworkDeadLine;
    }

    public String getHomeworkId() {
        return HomeworkId;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public String getTitle() {
        return Title;
    }

    public String getContent() {
        return Content;
    }

    public String getHomeworkCreateTime() {
        return HomeworkCreateTime;
    }

    public String getHomeworkDeadLine() {
        return HomeworkDeadLine;
    }
}
