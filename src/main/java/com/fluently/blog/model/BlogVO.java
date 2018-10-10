package com.fluently.blog.model;


import java.sql.Timestamp;

public class BlogVO {
    private String id;
    private String title;
    private Long time;
    private String content;
    private Integer vistor_count;
    private Integer visible;
    private String owner;

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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getVistor_count() {
        return vistor_count;
    }

    public void setVistor_count(Integer vistor_count) {
        this.vistor_count = vistor_count;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
