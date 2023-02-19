package javaj.lessem_3;

import java.util.Arrays;
import java.util.Random;

public class Subsequence {
    public static boolean flag = true; // Вывод общей подпоследовательности в консоль
    public static int[] nop; // Наибольшая общая подпоследовательность
    public static void main(String[] args) {
        int[] array1 = createArray();
        int[] array2 = createArray();
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        int len = lenSubsequence(array1, array2);
        System.out.println(String.format("Длина наибольшей общей подпоследовательности: %d", len));
        System.out.print("Наибольшая общая подпоследовательность: ");
        System.out.println(Arrays.toString(nop));
    }

    // Вычисление длины общей подпоследовательности
    public static int lenSubsequence(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[][] c = new int[2][m];

        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j < m; j ++) {
                if (a[i-1] == b[j-1]) { c[i%2][j] = c[(i-1)%2][j-1] + 1;}
                else { c[i%2][j] = c[(i-1)%2][j] > c[i%2][j-1] ? c[(i-1)%2][j] : c[i%2][j-1];}
            }
        }
        if (flag) { outputSub(b, c[n % 2]);}
        return c[n % 2][m-1];
    }

    // Наибольшая общая подпоследовательность
    // Ошибка вывода в неточности результата, необходима перепроверка
    public static void outputSub(int[] array, int[] mask) {
        nop = new int[mask[mask.length-1]];
        int count = 1;
        for (int i = 1; i < mask.length; i ++) {
            if (mask[i] == count) {
                nop[count-1] = array[i-1];
                count ++;
            }
        }
    }

    // Создание массива
    public static int[] createArray() {
        Random rand = new Random();
        int size = rand.nextInt(5, 10);
        int[] array = new int[size];
        for(int i = 0; i < size; i ++){ array[i] = rand.nextInt(10);}
        return array;
    }
}
