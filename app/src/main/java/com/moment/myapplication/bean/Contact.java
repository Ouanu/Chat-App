package com.moment.myapplication.bean;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Contact {
    @PrimaryKey(autoGenerate = true)
    private int primaryId;

    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "imageUri")
    private int imageUri;

    @ColumnInfo(name = "contactName")
    private String contactName;

    public Contact(long id, int imageUri, String contactName) {
        this.id = id;
        this.imageUri = imageUri;
        this.contactName = contactName;
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
}
