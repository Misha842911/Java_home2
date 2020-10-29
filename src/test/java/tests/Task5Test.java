package test.java.tests;

import main.java.lesson1.Task5;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task5Test {
    @Parameters({"reversedStr","str"})
    @Test
    public void checkReverse(String reversedStr, String str){
        String actualStr = Task5.reverse(str);
//        String expectedStr = "!!!gnirts elpmaxE";
//        String actualStr = Task5.reverse(Task5.getStr());
        assertEquals(actualStr, reversedStr);
    }
}
