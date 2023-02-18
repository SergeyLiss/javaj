package javaj.lessem_3;

import java.util.Random;

public class Subsequence {
    public static void main(String[] args) {
        int[] array1 = createArray();
        System.out.println(array1);
        int[] array2 = createArray();
        System.out.println(array2);
        int len = lenSubsequence(array1, array2);
        System.out.println(len);
    }

    public static int lenSubsequence(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[][] c = new int[2][m+1];

        for (int i = 0; i < n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if (a[i] == b[j-1]) {
                    c[i%2][j] = c[(i-1)%2][j-1] + 1;
                }
                else {
                    c[i%2][j] = Math.max(c[(i-1)%2][j], c[i%2][j-1]);
                }
            }
        }
        return c[(n-1) % 2][m-1];
    }

    public static int[] createArray() {
        Random rand = new Random();
        int size = rand.nextInt(20, 40);
        int[] array = new int[size];
        for(int i = 0; i < size; i ++){ array[i] = rand.nextInt(100);}
        return array;
    }
}
