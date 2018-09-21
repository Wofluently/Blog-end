package com.fluently.blog.model;


import java.sql.Timestamp;

public class BlogVO {
    private String id;
    private String title;
    private Timestamp time;
    private String content;
    private String vistor_count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVistor_count() {
        return vistor_count;
    }

    public void setVistor_count(String vistor_count) {
        this.vistor_count = vistor_count;
    }
}
