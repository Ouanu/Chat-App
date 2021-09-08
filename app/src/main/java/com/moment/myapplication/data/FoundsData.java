package com.moment.myapplication.data;

public class FoundsData {
    private int path;
    private String name;
    private String content;
    private int image;
    private String time;

    /**
     * 有配图
     * @param path
     * @param name
     * @param content
     * @param image
     * @param time
     */
    public FoundsData(int path, String name, String content, int image, String time) {
        this.path = path;
        this.name = name;
        this.content = content;
        this.image = image;
        this.time = time;
    }

    /**
     * 无配图
     * @param path
     * @param name
     * @param content
     * @param time
     */
    public FoundsData(int path, String name, String content, String time) {
        this.path = path;
        this.name = name;
        this.content = content;
        this.time = time;
    }


    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
