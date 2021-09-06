package com.moment.myapplication.data;

public class FoundsData {
    private int path;
    private String name;
    private String content;
    private int image;

    /**
     * 有配图
     * @param path
     * @param name
     * @param content
     * @param image
     */
    public FoundsData(int path, String name, String content, int image) {
        this.path = path;
        this.name = name;
        this.content = content;
        this.image = image;
    }

    /**
     * 无配图
     * @param path
     * @param name
     * @param content
     */
    public FoundsData(int path, String name, String content) {
        this.path = path;
        this.name = name;
        this.content = content;
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
}
