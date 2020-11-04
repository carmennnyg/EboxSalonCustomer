package com.example.eboxsalon;

import java.io.Serializable;

public class Staffs implements Serializable {

    private String name;

    public Staffs(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
