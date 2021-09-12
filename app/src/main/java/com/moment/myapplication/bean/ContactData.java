package com.moment.myapplication.bean;

public class ContactData {
    private long id;
    private String contactName;
    private String imageSrc;

    public ContactData(long id, String contactName, String imageSrc) {
        this.id = id;
        this.contactName = contactName;
        this.imageSrc = imageSrc;
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
}
