package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller_home {
    private Map<String,String> records = new HashMap<>();
    @GetMapping("/")
    public String sayHi(){
        return getIndexFile();
    }

    @PostMapping("/todo")
    public Map<String,String> recordData(DataObject o){
        System.out.println("recorded");
        records.put(o.getName(),o.getCity());
        return records;
    }

    @GetMapping("/todo")
    public Map<String,String> getdata(){
        return records;
    }

    @DeleteMapping("/todo")
    public Map<String,String> deleteData(Query query){
        records.remove(query.getSearchKey());
        return records;
    }

    @PutMapping("/todo")
    public Map<String,String> updateData(DataObject o){
        records.remove(o.getName());
        records.put(o.getName(),o.getCity());
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