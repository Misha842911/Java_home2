package test.java.tests;
import main.java.lesson1.Task1;
//import org.testng.annotations.Test;

public class Task1Test {
    public static void main(String[] args) {
        checkSmallestNumber();
    }
//    @Test
    public static void checkSmallestNumber() {
        Task1 task1 = new Task1();
        int expectedNumber = 1000;
        int actualNumber = task1.min(3,5,6);
        System.out.println("Number: " + (expectedNumber == actualNumber));
    }
}
