package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args)
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"abhishek");
        map.put(2,"nashik");
        System.out.println(map);
        map.remove(2);
        System.out.println(map);
    }
}
