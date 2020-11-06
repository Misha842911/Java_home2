package main.java;

import java.util.ArrayList;
import java.util.List;

public class B_List {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("AAAA");
        strList.add("BBBB");
        strList.add("CCCC");
        strList.add("DDDD");
        strList.add("DDDD");
        strList.add("DDDD");

        for (String el: strList) {
            System.out.println(el);
        }
    }
}
