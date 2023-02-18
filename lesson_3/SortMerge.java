package javaj.lesson_3;

import java.util.ArrayList;
import java.util.Random;

public class SortMerge {
    public static void main(String[] args) {
        ArrayList<Integer> array1 = createArray();
        System.out.println(array1);
        mergeSort(array1);
    }

    public static ArrayList<Integer> createArray() {
        Random rand = new Random();
        int size = rand.nextInt(20, 40);
        ArrayList<Integer> array = new ArrayList<>(size);
        for(int i = 0; i < size; i ++){ array.add(i, (rand.nextInt(100)));}
        return array;
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
        int size = array.size();
        int log_size = logIntPrimitiv(size) - 1;
        System.out.println(size);
        System.out.println(log_size);
        for (int i = 0; i < log_size; i ++) {
            int j = log_size - i;
            j = size / (1 << j);
            System.out.println(j);
        }
        return array;
    }

    // Вычисление количества бит
    public static int logIntPrimitiv(int n) {
        int l = 0;
        while (n != 0){
            l ++;
            n >>= 1;
        }
        return l;
    }
}
