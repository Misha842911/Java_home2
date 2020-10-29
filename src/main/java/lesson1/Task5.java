package main.java.lesson1;

/**
 * Реализовать функцию, которая принимает строку и возвращает ее же в обратном виде
 * например "Hello world!!!" -> "!!!dlrow olleH"
 */
public class Task5 {
    static String str = "Example string!!!";
    public static void main(String[] args) {
        System.out.println(reverse(str));
    }
    public static String getStr() {
        return str;
    }

    public static String reverse(String str) {

        String reversedstr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedstr += str.charAt(i);
        }
        return reversedstr;
    }
}
