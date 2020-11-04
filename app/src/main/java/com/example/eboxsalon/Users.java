package com.example.eboxsalon;

public class Users {
    private String name;
    private String password;
    private String phoneNo;

    public Users(String name, String password, String phoneNo) {
        this.name = name;
        this.password = password;
        this.phoneNo = phoneNo;
    }

    public Users() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNumber(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}


