package com.moment.myapplication.bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Chat {

    @PrimaryKey(autoGenerate = true)//主键是否自动增长，默认为false
    private int uid;

    @ColumnInfo(name = "imageUri")
    private int imageUri;

    @ColumnInfo(name = "contactName")
    private String contactName;

    @ColumnInfo(name = "talkRecord")
    private String talkRecord;

    @ColumnInfo(name = "Date")
    private String Date;

    public int getImageUri() {
        return imageUri;
    }

    public void setImageUri(int imageUri) {
        this.imageUri = imageUri;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTalkRecord() {
        return talkRecord;
    }

    public void setTalkRecord(String talkRecord) {
        this.talkRecord = talkRecord;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }


}

