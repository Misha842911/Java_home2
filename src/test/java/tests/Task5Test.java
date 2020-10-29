package test.java.tests;

import main.java.lesson1.Task5;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task5Test {
    @Parameters({"reversedStr","str"})
    @Test
    public void checkReverse(String reversedStr, String str){
        reversedStr = Task5.reverse(str);
        System.out.println(reversedStr);
//        String expectedStr = "!!!gnirts elpmaxE";
//        String actualStr = Task5.reverse(Task5.getStr());
        String reversedAgainStr = Task5.reverse(reversedStr);
        assertEquals(str, reversedAgainStr);
    }
}
