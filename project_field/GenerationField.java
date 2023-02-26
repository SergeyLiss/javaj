package javaj.project_field;

import java.util.Random;

public class GenerationField {
    int[][] field;
    int[] pather;
    static int filling = 2;
    public GenerationField(int column, int row) {
        this.field = genF(column, row);
        this.pather = genP(column, row);
    }

    public static int[] genP(int c, int r) {
        Random rand = new Random();
        int[] p  = new int[4];

        boolean exit_v = rand.nextBoolean();
        int exit_w = rand.nextInt((exit_v ? c : r));

        p[0] = rand.nextInt(2, (c-2));
        p[1] = rand.nextInt(2, (r-2));

        if (rand.nextBoolean()) {
            p[2] = exit_w;
            if (exit_v) { p[3] = r-1;}
        }
        else {
            p[3] = exit_w;
            if (exit_v) { p[2] = c-1;}
        }

        return p;
    }

    public static int[][] genF(int c, int r) {
        Random rand = new Random();
        int[][] f = new int[c][r];

        for (int i = 0; i < c; i ++)
            for (int j = 0; j < r; j ++)
                if (rand.nextBoolean()) { f[i][j] = -1;}

        for (int k = 0; k < filling; k ++)
            for (int i = 0; i < c; i ++)
                for (int j = 0; j < r; j ++)
                    if (f[i][j] == -1)
                        if (rand.nextBoolean()) { f[i][j] = 0;}

        return f;
    }
}
