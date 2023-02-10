package javaj.sem_1;
import java.util.*;
  
public class program{
  
    public static void main(String args[])
    {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите размер массива: ");
        int size = scan.nextInt();
        scan.close();

        int[] array = new int[size];

        for(int i = 0; i < size; i ++){
            array[i] = rand.nextInt(100);
        }

        System.out.printf("[");
        for (int i : array) {
            System.out.printf("%3d,", i);
        }
        System.out.printf("]");

        int sizech = 0;
        for (int i : array) {
            if ((i&1) == 0){
                sizech ++;
            }
        }
        int[] arr = new int[sizech];
        int arrnum = 0;
        for(int i = 0; i < size; i ++) {
            if ((array[i]&1) == 0){
                arr[arrnum] = array[i];
                arrnum ++;
            }
        }

        System.out.printf("\n[");
        for (int i : arr) {
            System.out.printf("%3d,", i);
        }
        System.out.printf("]");

    }
}