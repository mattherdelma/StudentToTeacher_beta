package com.java.code.model;

public class HandleHomework {
    private String HandleHomeworkId;
    private  String HomeworkId;
    private String StudentId;
    private String Title;
    private String Content;
    private String HandleHomeworkCreateTime;

    public void setHomeworkId(String homeworkId) {
        HomeworkId = homeworkId;
    }

    public String getHomeworkId() {
        return HomeworkId;
    }

    public void setHandleHomeworkId(String handleHomeworkId) {
        HandleHomeworkId = handleHomeworkId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setHandleHomeworkCreateTime(String handleHomeworkCreateTime) {
        HandleHomeworkCreateTime = handleHomeworkCreateTime;
    }

    public String getHandleHomeworkId() {
        return HandleHomeworkId;
    }

    public String getStudentId() {
        return StudentId;
    }

    public String getTitle() {
        return Title;
    }

    public String getContent() {
        return Content;
    }

    public String getHandleHomeworkCreateTime() {
        return HandleHomeworkCreateTime;
    }
}
