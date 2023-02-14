package javaj.lesson_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * stepen
 */
public class stepen {
    public static int accuracy = 20;
    public static int step = 0;
    public static int osn = 0;
    public static BigDecimal osn_big = new BigDecimal(osn);
    
    public static void main(String[] args) throws Exception {
        ReadLineFromFile("javaj/lesson_2/input.txt");
        System.out.println(Exponentiation());
    }

    public static void ReadLineFromFile(String pathname) throws Exception {
        BufferedReader buff = new BufferedReader(new FileReader(pathname));
        String line;
        while ((line = buff.readLine()) != null) { ConvertStringToBaza(line);}
        buff.close();
    }

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

    public static void ControlStep() {
        if (step < 0) {
            osn_big = BigDecimal.ONE.divide(osn_big, accuracy, RoundingMode.HALF_UP);
            step = 0 - step;
        }
    }

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

    public static int LogIntPrimitiv(int n) {
        int l = 0;
        while (n != 0){
            l ++;
            n >>= 1;
        }
        return l;
    }

    public static BigDecimal Exponentiation() {
        ControlStep();
        BigDecimal out_exp = osn_big.multiply(osn_big);
        boolean[] temp = ConvertIntToBoolArray(step);
        // System.out.print(temp);
        // System.out.println(out_exp);
        for (boolean i : temp){
            System.out.println(i);
            // if ((temp & 1) == 1) {
            //     System.out.print("1");
            // }
            // else {System.out.print("0");}
            // temp >>= 1;
        }
        return out_exp;
    }
    
}