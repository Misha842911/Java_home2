package lesson1Advanced;

public class Task1 {
    /* Минимум n чисел
    Написать функцию, которая вычисляет минимум из массива чисел.
    */
    public static void main(String[] args) {
        //System.out.println(min([2,4,6]));
        //System.out.println(min([2,4,6,1,90,2,0]));
    }

    public static int min(int[] a) {
        int result = a[0];
        for (int i = 0; i < a.length; i++) {
            if(a[i] < result)
                result = a[i];
        }
        return result;
    }
}
