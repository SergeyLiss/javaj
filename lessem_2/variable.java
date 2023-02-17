package javaj.lessem_2;

import java.math.BigInteger;

public class variable {
    public static int[] field = {19,19};

    public static void main(String[] args) {
        BigInteger step = variableSteps(0,0);
        System.out.println(String.format("Количество возможных путей %d.", step));
    }

    // Количество ходов
    public static BigInteger variableSteps(int x, int y) {
        BigInteger result;
        x = field[0] - x;
        y = field[1] - y;
        System.out.println(x);
        System.out.println(y);
        System.out.println(factorialSlice(x, (x + y)));
        System.out.println(factorial(y));
        result = factorialSlice(x, (x + y)).divide(factorial(y));
        return result;
    }

    // Факториал
    public static BigInteger factorial(int n) {
        BigInteger m = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i ++) { m = m.multiply(BigInteger.valueOf(i));}
        return m;
    }

    // Срез факториала
    public static BigInteger factorialSlice(int k, int n) {
        BigInteger m = BigInteger.valueOf(1);
        for (int i = (k + 1); i <= n; i ++) { m = m.multiply(BigInteger.valueOf(i));}
        return m;
    }
}
