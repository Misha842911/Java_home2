package test.java.tests;
import main.java.lesson1.Task1;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task1Test {
    @Test
    public static void checkSmallestNumber() {
        Task1 task1 = new Task1();
        int expectedNumber = 3;
        int actualNumber = task1.min(3,5,6);
        assertEquals(actualNumber, expectedNumber);

    }
}
