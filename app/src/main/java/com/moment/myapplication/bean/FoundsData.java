package com.moment.myapplication.bean;

public class FoundsData {
    private long id;
    private String name;
    private String image;
    private String icon;
    private String content;
    private String time;

    public FoundsData(long id, String name, String image, String icon, String content, String time) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.icon = icon;
        this.content = content;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
