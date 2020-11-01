package test.java.tests;
import main.java.lesson1.Task2;
import org.junit.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class Task2Test {
    @Test
    public static void main(String[] args) {
        getNamesTest();
    }

    public static void getNamesTest() {
        String actualResult = Task2.getNames();
        System.out.println(actualResult);
        String strArr[] = actualResult.split("\n");
        int actualNumberStrings = strArr.length;
        int expectedNumberStrings = 5;
        System.out.println("Lines amount: " + actualNumberStrings);
        int expectedNumberNamesInString = 10;
        int actualNumberNamesInString = 0;
        for (String el: strArr) {
            String namesArr[] = el.split(" ");
            try{
                System.out.println("Names in line amount: " + namesArr.length);
                actualNumberNamesInString = namesArr.length;
                assertEquals(actualNumberNamesInString, expectedNumberNamesInString);
            } catch (Exception e) {
                System.out.println("Number of Names in the string is not correct");
            }

        }
        assertEquals(actualNumberStrings, expectedNumberStrings);


    }
}

