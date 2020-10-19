package lesson1Advanced;

/* Мое имя
Вывести на экран любой символ пирамидкой в обратную сторону высотой в 10 строк.
         *
        **
       ***
      ****
     *****
    ******
   *******
  ********
 *********
**********
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом
*/

public class Task3 {

    public static void main(String[] args) {
        String s = "*";
        String empty = "          ";
        int line = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < line; j++) {
                System.out.print(empty + s);
            }
            line++;
            System.out.println(empty + s);
            empty = empty.replace(" ", "*");
        }
    }
}