package com.example.customlistadapter;

public class Person {
    private String name;
    private String birthDay;
    private String phoneNumber;
    //ListView with Images and Text
    private String imgURL;



    public Person(String name, String birthDay, String phoneNumber,String imgURL) {
        this.name = name;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
