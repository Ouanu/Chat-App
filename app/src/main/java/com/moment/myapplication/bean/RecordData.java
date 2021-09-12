package com.moment.myapplication.bean;

public class RecordData {
    private long id;
    private String time;
    private String record;

    public RecordData(long id, String time, String record) {
        this.id = id;
        this.time = time;
        this.record = record;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
