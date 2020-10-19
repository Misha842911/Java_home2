package lesson1;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом do () while
*/

public class Task4 {

    public static void main(String[] args) {
        String s = "Misha";
        int counter1 = 5;
        int counter2 = 9;
        do {
            do {
                System.out.print(s + " ");
                counter2--;
            } while(counter2 > 0);
            System.out.println(s + " ");
            counter2 = 9;
            counter1--;
        }  while(counter1 > 0);
    }
}