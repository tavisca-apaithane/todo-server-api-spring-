package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller_home {
    private static int idCount = 0;
    private Map<Integer ,DataObject> records = new HashMap<>();
    @GetMapping("/")
    public String sayHi(){
        return getIndexFile();
    }

    @PostMapping("/todo")
    public Map<Integer,DataObject> recordData(DataObject o){
        System.out.println("recorded");
        o.setId(++idCount);
        records.put(o.getId(),o);
        return records;
    }

    @GetMapping("/todo")
    public Map<Integer,DataObject> getdata(){
        return records;
    }

    @DeleteMapping("/todo")
    public Map<Integer,DataObject> deleteData(DataObject o){
        records.remove(o.getId());
        return records;
    }

    @PutMapping("/todo")
    public Map<Integer,DataObject> updateData(DataObject o){
        if(records.containsKey(o.getId()))
            records.put(o.getId(),o);
        return records;
    }
    private String getIndexFile()
    {
        String out = "";
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\apaithane\\Desktop\\spring_1.0\\spring1.2\\src\\main\\resources\\static\\todoFrontend.html");
            byte[] b = new byte[file.available()];
            file.read(b);
            out = new String(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }
}