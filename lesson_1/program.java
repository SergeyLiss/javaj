//Написать программу вычисления n-ого треугольного числа
package javaj.lesson_1;
import java.util.Scanner;

public class program {
    public static int number;
    public static int figure = 3;
    public static void main(String[] args) {
        number = inputNumber(String.format("Введите n-ю позицию %d-угольного числа: ", figure));
        System.out.println(String.format("Ваше %d-е %d-угольное число: %d", number, figure, figurateNumber()));
    }

    public static int inputNumber(String string) {
        Scanner scan = new Scanner(System.in);
        System.out.println(string);
        int outnum = scan.nextInt();
        scan.close();
        return outnum;
    }

    public static int figurateNumber() {
        int temp = (number - 1) * number * (figure - 2) / 2;
        return temp + number;
    }
}

/*
 * 1. Ввод позиции n-ого числа
 * 2. Расчет n-ого числа
 * 3. Вывод в консоль n-ого числа
 * 
 */
