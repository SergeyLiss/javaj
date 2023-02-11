//Написать программу вычисления n-ого треугольного числа
package javaj.lesson_1;
import java.util.Formatter;
import java.util.Scanner;

public class program {
    public static int number;
    public static int figure = 3;
    public static void main(String[] args) {
        number = InputNumber("Введите n-е треугольное число: ");
        Formatter temp = new Formatter();
        temp.format("Ваше %d-е треугольное число: %d", number, FigurateNumber());
        System.out.println(temp);
    }

    public static int InputNumber(String text) {
        Scanner scan = new Scanner(System.in);
        System.out.println(text);
        int outnum = scan.nextInt();
        scan.close();
        return outnum;
    }

    public static int FigurateNumber() {
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
