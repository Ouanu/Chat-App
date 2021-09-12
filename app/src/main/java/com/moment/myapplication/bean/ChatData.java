package com.moment.myapplication.bean;

public class ChatData {
    private long id;
    private String contactName;
    private String imageSrc;
    private String record;
    private String time;

    public ChatData(long id, String contactName, String imageSrc, String record, String time) {
        this.id = id;
        this.contactName = contactName;
        this.imageSrc = imageSrc;
        this.record = record;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
