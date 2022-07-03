package com.example.testapp;

public class PatientUser {

    String username,email,age,gender,marital,children,mobile;
    int userType;

    public PatientUser() {
    }

    public PatientUser(String username, String email, String age, String gender, String marital, String children, String mobile,int userType) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.marital = marital;
        this.children = children;
        this.mobile = mobile;
        this.userType =userType;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
