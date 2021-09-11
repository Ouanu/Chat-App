package com.moment.myapplication.bean;

public class Contact {

    private long id;

    private int imageUri;

    private String contactName;

    public Contact(long id, int imageUri, String contactName) {
        this.id = id;
        this.imageUri = imageUri;
        this.contactName = contactName;
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
