package com.example.testapp;

public class DoctorUser {

    String username,email,gender,mobile,special,clinic,hospital,cTime,hTime,cFee,hFee,about,location;
    int userType;

    public DoctorUser() {
    }

    public DoctorUser(String username, String email, String gender, String mobile, String special, String clinic, String hospital, String cTime, String hTime, String cFee, String hFee, String about,int userType,String location) {
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.special = special;
        this.clinic = clinic;
        this.hospital = hospital;
        this.cTime = cTime;
        this.hTime = hTime;
        this.cFee = cFee;
        this.hFee = hFee;
        this.about = about;
        this.userType = userType;
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String gethTime() {
        return hTime;
    }

    public void sethTime(String hTime) {
        this.hTime = hTime;
    }

    public String getcFee() {
        return cFee;
    }

    public void setcFee(String cFee) {
        this.cFee = cFee;
    }

    public String gethFee() {
        return hFee;
    }

    public void sethFee(String hFee) {
        this.hFee = hFee;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
