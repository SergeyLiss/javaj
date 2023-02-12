package javaj.lessem_1;
import java.util.Scanner;

public class program {
    public static int[] number = {1,1};
    public static int[] number_command = {1,1};
    public static boolean[] flag_command = {false, false};
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        InputAllNumber();
        System.out.println(number[0]);
        System.out.println(number[1]);
        System.out.println(number_command[0]);
        System.out.println(number_command[1]);
    }

    public static void InputAllNumber() {
        number[0] = InputNumber("Введите начальное число: ");
        number[1] = InputNumber("Введите конечное число: ");
        number_command[0] = InputNumber("Введите число, для команды 'умножить': ");
        number_command[1] = InputNumber("Введите число, для команды 'сложить': ");
        scan.close();
    }

    // // Проверка условия получения одного числа из другого посредством комманд и установка флагов
    // public static void SettingFlag() {
        
    // }

    // // Проверка флагов
    // public static void ControlFlag() {
        
    // }

    // // Вычисление минимального
    // public static boolean[] ComputationMinStep() {
    //     boolean[] out_array = new boolean[20];
    //     return out_array;
    // }

    // // Вычисление всех возможных шагов с ограничением в 20 вариантов
    // public static boolean[][] ComputationAllStep() {
    //     boolean[][] out_array = new boolean[20][20];
    //     return out_array;
    // }

    // // Конвертирование результата
    // public static String ConvertResult(boolean[] in_array) {
    //     String out_string = " ";
    //     return out_string;
    // }

    public static int InputNumber(String text) {
        System.out.println(text);
        int outnum = scan.nextInt();
        return outnum;
    }
}
