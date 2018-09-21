package com.fluently.blog.model;

public class BlogVO {
    private String id;
    private String title;
    private String time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
