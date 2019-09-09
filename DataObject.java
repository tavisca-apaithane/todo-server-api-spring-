package com.example.demo;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.xml.crypto.Data;
@EntityScan
public class DataObject {
    private String name;
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private  int id=0;
    public DataObject(String name, String city){
        this.name = name;
        this.city = city;
    }

    public DataObject(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



}
