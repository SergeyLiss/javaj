package javaj.lessem_1;
import java.util.Scanner;

public class ActionRobot {
    public static int[] number = {1,1};
    public static int[] number_command = {1,1};
    public static boolean flag_command;
    public static int[] paths;
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        inputAllNumber();
        settingIf();
        controlFlag();
        // System.out.println(number[0]);
        // System.out.println(number[1]);
        // System.out.println(number_command[0]);
        // System.out.println(number_command[1]);

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
        if (number_command[1] == 0) { // <--- Доработать
            int e = 3;
            int a = number[0] % 3;
            int b = number_command[0] % 3;
            int c = number[1] % 3;
            int d = 1;

            for (int i = 0; i < e; i ++) {
                int f = (a * d) % e;
                if (f == b) { flag_command = true;}
                d *= c;
            }
        }
        else if (number_command[1] == 1) {
            if ((number[0] < number[1]) || (number_command[0] < 0)) { flag_command = true;}
        }
        else if (number_command[1] == -1) {
            if ((number[0] > number[1]) || (number_command[0] > 0)) { flag_command = true;}
        }
        else {
            int a = number[0] % number_command[1];
            int b = number_command[0] % number_command[1];
            int c = number[1] % number_command[1];
            int d = 1;

            for (int i = 0; i < number_command[1]; i ++) {
                int f = (a * d) % number_command[1];
                if (f == b) { flag_command = true;}
                d *= c;
            }
        }
    }

    // Проверка флагов
    public static void controlFlag() {
        if (flag_command) {
            System.out.println("Решение есть");
            int[] temp = numberOfPaths();
            for (int item : temp) {
                System.out.println(item);
            }
            
        }
        else {
            System.out.println("Решений нет");
        }
    }

    // Вычисление количества путей
    public static int[] numberOfPaths() {
        int size = number[1] - number[0];
        size = size > 0 ? size : -size;
        size ++;
        System.out.println(size);
        int[] out_array = new int[size];
        out_array[0] = 1;

        if (number[0] < number[1]) {
            for (int i = (number[0] + 1); i <= number[1]; i ++) {
                if ((i % number_command[0]) == 0) {
                    int a = i / number_command[0] - number[0];
                    if ((a >= 0) && (a < size)) {out_array[i - number[0]] += out_array[a];}
                }

                int b = i - number_command[1] - number[0];
                if ((b >= 0) && (b < size)) {out_array[i - number[0]] += out_array[b];}
            }
        }
        else {
            // for (int i = (number[1] + 1); i <= number[0]; i ++) {
            //     int a = (i * number_command[0])  - number[1];
            //     if ((a >= 0) && (a < size)) {out_array[i - number[1]] += out_array[a];
            //     System.out.println(String.format("xC -> %5d %5d", i, a));}
            //     int b = (i - number_command[1]) - number[1];
            //     if ((b >= 0) && (b < size)) {out_array[i - number[1]] += out_array[b];
            //         System.out.println(String.format("xC -> %5d %5d", i, b));}
            // }
            for (int i = (number[0] - 1); i >= number[1]; i --) {
                if ((i % number_command[0]) == 0) {
                    int a = number[0] - (i / number_command[0]);
                    if ((a >= 0) && (a < size)) {out_array[number[0] - i] += out_array[a];
                    System.out.println(String.format("xC -> %5d %5d", i, a));}
                }

                int b = number[0] - (i + number_command[1]);
                if ((b >= 0) && (b < size)) {out_array[number[0] - i] += out_array[b];
                    System.out.println(String.format("xC -> %5d %5d", i, b));}
            }
        }
        return out_array;
    }

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


// for (int i = 1; i < size; i ++) {
//     if (number_command[0] != 0) {
//         int a = number[0] + i;
//         if ((a % number_command[0]) == 0) {
//             a /= number_command[0];
//             a -= number[0];
//             if ((a > 0) && (a < size)) {out_array[i] += out_array[a];}
//         }
//     }
//     int b = number[0] + i;
//     b -= number_command[1];
//     if ((b > 0) && (b < size)) {out_array[i] += out_array[b];}
// }