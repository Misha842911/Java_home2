package main.java.lesson1Advanced;

/* Мое имя
Вывести на экран любой символ пирамидкой высотой в 10 строк.
*
**
***
****
*****
******
*******
********
*********
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом
*/

public class Task2 {

    public static void main(String[] args) {
        String s = "*";
        int line = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < line; j++) {
                System.out.print(s);
            }
            line++;
            System.out.println(s);
        }
    }
}