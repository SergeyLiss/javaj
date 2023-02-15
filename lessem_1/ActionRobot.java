package javaj.lessem_1;
import java.util.Scanner;

public class ActionRobot {
    public static int[] number = {1,1};
    public static int[] number_command = {1,1};
    public static boolean[] flag_command = {false, false};
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        inputAllNumber();
        settingIf();
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

    // Проверка условия получения одного числа из другого посредством комманд и установка флага
    public static void settingIf() {
        if (number_command[1] == 1) { flag_command[0] = true;}
        else {
            int a = number[0] % number_command[1];
            int b = number_command[0] % number_command[1];
            int c = number[1] % number_command[1];
            int d = 1;

            for (int i = 0; i < number_command[1]; i ++) {
                int f = (a * d) % number_command[1];
                if (f == b) { flag_command[0] = true;}
                d *= c;
            }
        }

        if (flag_command[0]) { System.out.println("Resheniy est");}
        else {System.out.println("Resheniy net");}
    }

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
