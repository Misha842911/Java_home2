package main.java;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class A_set {
    public static void main(String[] args) {
        Set<String> setStr =new HashSet<>();
        setStr.add("AAA");
        setStr.add("BBB");
        setStr.add("CCC");
        setStr.add("DDD");
        setStr.add("EEE");
        setStr.remove("EEE");
        setStr.size();

        System.out.println(setStr.size());
        for (String str: setStr) {
            System.out.println(str);
        }

        int i = 10;
        Integer ii = 10;

        Set<Integer> setInt = new HashSet<>();

//        Iterator it = setStr.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

    }
}
