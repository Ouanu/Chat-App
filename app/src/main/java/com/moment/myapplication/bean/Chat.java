package com.moment.myapplication.bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Chat {

    @PrimaryKey(autoGenerate = true)
    private int primaryId;

    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "imageUri")
    private int imageUri;

    @ColumnInfo(name = "contactName")
    private String contactName;

    @ColumnInfo(name = "recode")
    private String recode;

    @ColumnInfo(name = "date")
    private String date;

    public Chat(long id, int imageUri, String contactName, String recode, String date) {
        this.id = id;
        this.imageUri = imageUri;
        this.contactName = contactName;
        this.recode = recode;
        this.date = date;
    }

    public int getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(int primaryId) {
        this.primaryId = primaryId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getRecode() {
        return recode;
    }

    public void setRecode(String recode) {
        this.recode = recode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

