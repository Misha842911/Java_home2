package lesson1;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом while
*/

public class Task3 {

    public static void main(String[] args) {
        String s = "Misha";
        int counter1 = 5;
        int counter2 = 9;
        while(counter1 > 0) {
            while(counter2 > 0){
                System.out.print(s + " ");
                counter2--;
            }
            counter2 = 9;
            System.out.println(s + " ");
            counter1--;
        }
    }
}