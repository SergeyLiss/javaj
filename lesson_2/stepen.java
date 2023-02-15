package javaj.lesson_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class stepen {
    public static int accuracy = 64; // Количество знаков после запятой
    public static int step = 0; // Степень
    public static int osn = 0; // Основание неизменяемое
    public static BigDecimal osn_big = new BigDecimal(osn); // Основание изменяемое
    
    public static void main(String[] args) throws Exception {
        ReadLineFromFile("javaj/lesson_2/input.txt");
        String temp = Exponentiation().toString();
        temp = ControlAccuracy(temp);
        WriteToFile("javaj/lesson_2/output.txt", temp);
    }

    // Применение точности числа, если число не целое
    public static String ControlAccuracy(String number) {
        if (number.contains("E")) {
            int index = number.indexOf("E");
            number = number.substring(0, accuracy) + number.substring(index);
        }
        return number;
    }

    // Чтение из файла "input.txt" строк
    public static void ReadLineFromFile(String pathname) throws Exception {
        BufferedReader buff = new BufferedReader(new FileReader(pathname));
        String line;
        while ((line = buff.readLine()) != null) { ConvertStringToBaza(line);}
        buff.close();
    }

    // Создание и запись в файл "output.txt" результата возведения в степень
    public static void WriteToFile(String pathname, String text) throws Exception {
        try (FileWriter file = new FileWriter(pathname, false)) { file.write(text);}
        catch (IOException ex) { System.out.println(ex.getMessage());}
    }

    // Нахождение основания и степени по ключу "a" & "b" соответственно
    public static void ConvertStringToBaza(String line) {
        if (line.contains("a")) {
            line = line.replaceAll("a ", "");
            osn = Integer.parseInt(line);
            osn_big = new BigDecimal(osn);
        }
        else if (line.contains("b")) {
            line = line.replaceAll("b ", "");
            step = Integer.parseInt(line);
        }
        else {System.out.printf("Непредвиденная ошибка");} 
    }

    // Проверка степени на отрицательное значение, при истине основание изменяем -> (1/osn_big)
    public static void ControlStep() {
        if (step < 0) {
            osn_big = BigDecimal.ONE.divide(osn_big, accuracy, RoundingMode.HALF_UP);
            step = 0 - step;
        }
    }

    // Конвертирование INT в массив BOOLEAN
    public static boolean[] ConvertIntToBoolArray(int n) {
        int log = LogIntPrimitiv(n);
        boolean[] temp = new boolean[log];
        for (int i = 0; i < log; i ++) {
            if ((n & 1) == 1) {temp[i] = true;}
            else {temp[i] = false;}
            n >>= 1;
        }
        return temp;
    }

    // Вычисление количества бит
    public static int LogIntPrimitiv(int n) {
        int l = 0;
        while (n != 0){
            l ++;
            n >>= 1;
        }
        return l;
    }

    // Быстрое возведение в степень
    public static BigDecimal Exponentiation() {
        ControlStep();
        BigDecimal out_exp = osn_big;
        boolean[] temp = ConvertIntToBoolArray(step);
        int size = temp.length - 1;
        for (int i = 0; i < size; i ++){
            out_exp = out_exp.multiply(out_exp);
            if (temp[size-i-1]) { out_exp = out_exp.multiply(osn_big);}
        }
        return out_exp;
    }
    
}