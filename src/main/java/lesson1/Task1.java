package lesson1;

public class Task1 {
    /* Минимум трех чисел
    Написать функцию, которая вычисляет минимум из трёх чисел.
    */
    public static void main(String[] args) {
        System.out.println("The smallest number is: " + min(5,2,3));
    }

    public static int min(int a, int b, int c) {
        int small;
        if(a <= b && a <= c){
            small = a;
        } else if (b <= a && b <= c){
            small = b;
        } else {
            small = c;
        }
        return small;
    }
}
