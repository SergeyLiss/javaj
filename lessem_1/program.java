package javaj.lessem_1;
import java.util.Scanner;

public class program {
    public static int[] number = {1,1};
    public static int[] number_command = {1,1};
    public static boolean[] flag_command = {false, false};
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        inputAllNumber();
        System.out.println(number[0]);
        System.out.println(number[1]);
        System.out.println(number_command[0]);
        System.out.println(number_command[1]);
    }

    public static void inputAllNumber() {
        number[0] = inputNumber("Введите начальное число: ");
        number[1] = inputNumber("Введите конечное число: ");
        number_command[0] = inputNumber("Введите число, для команды 'умножить': ");
        number_command[1] = inputNumber("Введите число, для команды 'сложить': ");
        scan.close();
    }

    // // Проверка условия получения одного числа из другого посредством комманд и установка флагов
    // public static void settingFlag() {
        
    // }

    // // Проверка флагов
    // public static void controlFlag() {
        
    // }

    // // Вычисление минимального
    // public static boolean[] computationMinStep() {
    //     boolean[] out_array = new boolean[20];
    //     return out_array;
    // }

    // // Вычисление всех возможных шагов с ограничением в 20 вариантов
    // public static boolean[][] computationAllStep() {
    //     boolean[][] out_array = new boolean[20][20];
    //     return out_array;
    // }

    // // Конвертирование результата
    // public static String convertResult(boolean[] in_array) {
    //     String out_string = " ";
    //     return out_string;
    // }

    public static int inputNumber(String text) {
        System.out.println(text);
        int outnum = scan.nextInt();
        return outnum;
    }
}
