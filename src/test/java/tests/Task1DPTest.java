package test.java.tests;

import main.java.lesson1.Task1;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

    public class Task1DPTest {
        Task1 task1;

        @BeforeMethod
        public void setUP() {
            task1 = new Task1();
        }

        @Test(dataProvider = "dp")
        public void checkSmallestNumberTest(int a, int b, int c, int expectedNumber) {
            int actualNumber = task1.min(a,b,c);
            assertEquals(actualNumber, expectedNumber);
            }
        @DataProvider(name = "dp")
        public Object[][] dataProvider() {
            return new Object[][] {
                    {-100, -23, -25, -100},
                    {-1, 4, 5, -1},
                    {0, 3, 5, 0},
                    {1, 2, 7, 1},
                    {11, 22, 43, 11},
                    {65, 55, 99, 55}
            };
        }
    }

