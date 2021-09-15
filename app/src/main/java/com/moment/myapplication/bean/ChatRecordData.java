package com.moment.myapplication.bean;

public class ChatRecordData {
    private String record;
    private String iconUrl;
    private long id;

    public ChatRecordData(String record, String iconUrl, long id) {
        this.record = record;
        this.iconUrl = iconUrl;
        this.id = id;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
