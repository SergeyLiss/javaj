package javaj.lesson_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SortHeap {

    public static ArrayList<Integer> array_in = new ArrayList<>(); // Входной массив
    public static ArrayList<Integer> array_out; // Отсортированный массив

    public static void main(String[] args) {
        System.out.println("Сортировка Пирамидальная (Кучей)...");
        array_in = createArray();
        array_out = new ArrayList<>(array_in);

        heapSort();

        System.out.println("Исходный список:");
        System.out.println(array_in);
        System.out.println("Отсортированный список:");
        System.out.println(array_out);
    }

    // Сортировка Кучей
    public static void heapSort() {
        int size = array_out.size();

        for (int i = (size >> 1) - 1; i >= 0; i --){ heapForm(array_out, size, i);}

        for (int j = (size-1); j >= 0; j --) {
            Collections.swap(array_out, j, 0);
            heapForm(array_out, j, 0);
        }
    }

    // Построение дерева
    public static void heapForm(ArrayList<Integer> array, int size_arr, int ind_arr) {
        int big_elm = ind_arr;
        int left = (ind_arr << 1) + 1;
        int right = (ind_arr + 1) << 1;

        if ((left < size_arr) && (array.get(left) > array.get(big_elm))) { big_elm = left;}
        if ((right < size_arr) && (array.get(right) > array.get(big_elm))) { big_elm = right;}

        if (big_elm != ind_arr) {
            Collections.swap(array, big_elm, ind_arr);
            heapForm(array, size_arr, big_elm);
        }
    }

    // Создание массива
    public static ArrayList<Integer> createArray() {
        Random rand = new Random();
        int size = rand.nextInt(20, 40);
        ArrayList<Integer> array = new ArrayList<>(size);
        for (int i = 0; i < size; i ++) { array.add(i, (rand.nextInt(100)));}
        return array;
    }
}
