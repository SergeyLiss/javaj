package javaj.lessem_2;

import java.math.BigInteger;

public class variable {
    public static int[] field = {5,3};

    public static void main(String[] args) {
        BigInteger step = variableSteps(0,0);
        System.out.println(String.format("Количество возможных путей %d.", step));
        long step2 = variableSteps2(0,0);
        System.out.println(String.format("Количество возможных путей %d.", step2));
    }

    // Количество ходов - Вариант 2 - Использовать для стен
    public static long variableSteps2(int x, int y) {
        x = field[0] - x;
        y = field[1] - y;

        long[][] array = new long[2][y];
        array[0][0] = 1;
        array[1][0] = 1;

        for (int i = 0; i < x; i ++) {
            for (int j = 1; j < y; j ++) {array[i%2][j] = array[(i+1)%2][j] + array[i%2][j-1];}}

        return array[(x-1)%2][y-1];
    }

    // Количество ходов - Вариант 1
    public static BigInteger variableSteps(int x, int y) {
        BigInteger result;
        x = field[0] - x - 1;
        y = field[1] - y - 1;
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
