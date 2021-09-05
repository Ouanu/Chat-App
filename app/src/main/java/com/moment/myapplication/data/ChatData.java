package com.moment.myapplication.data;

import android.net.Uri;

public class ChatData {
    private int imageUri;
    private String contactName;
    private String talkRecord;
    private String Date;
//    private boolean isChosen;

    public ChatData(int imageUri, String contactName, String talkRecord, String date) {
        this.imageUri = imageUri;
        this.contactName = contactName;
        this.talkRecord = talkRecord;
        Date = date;
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
