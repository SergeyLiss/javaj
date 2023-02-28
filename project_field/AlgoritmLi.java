package javaj.project_field;

import java.util.LinkedList;
import java.util.Queue;

public class AlgoritmLi {
    // private static boolean moveFlag = false;
    private static int[][] field;
    private static int[] fieldSize = new int[2]; // Столбцы, строки
    private static int[][] path;
    
    public AlgoritmLi(int[] size) {
        fieldSize[0] = size[0];
        fieldSize[1] = size[1];
        field = new int[fieldSize[0]][fieldSize[1]];
        path = new int[fieldSize[0]][fieldSize[1]];
    }

    // Вывод поля
    public int[][] getMapLi () { return field;}
    // Вывод размера поля
    public int[] getMapSize () { return fieldSize;}
    // Вывод пути
    public int[][] getPath () { return path;}

    public void searchPath(int[] p) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(p[2]);
        q.add(p[3]);

        int sizeQ = 1;

        while (sizeQ > 0) {
            boolean flag = true;
            int x = q.remove();
            int y = q.remove();
            sizeQ --;
            int z = field[x][y] - 1;

            int iMin = x > 0 ? (x-1) : x;
            int jMin = y > 0 ? (y-1) : y;
            int iMax = x < (fieldSize[0] - 1) ? (x+2) : (x+1);
            int jMax = y < (fieldSize[1] - 1) ? (y+2) : (y+1);

            for (int i = iMin; i < iMax; i ++){
                for (int j = jMin; j < jMax; j ++) {
                    if ((field[i][j] == z) && (z >= 0) && flag) {
                        path[i][j] = 1;
                        q.add(i);
                        q.add(j);
                        sizeQ ++;
                        flag = false;
                    }
                }
            }
        }
    }

    public void algoritmWave(int[] p, int[][] f) {
        Queue<Integer> q = new LinkedList<Integer>();
        f[p[0]][p[1]] ++;
        f[p[2]][p[3]] = 0;
        q.add(p[0]);
        q.add(p[1]);

        int sizeQ = 1;

        while (sizeQ > 0) {
            int x = q.remove();
            int y = q.remove();
            sizeQ --;
            int z = field[x][y] + 1;

            int iMin = x > 0 ? (x-1) : x;
            int jMin = y > 0 ? (y-1) : y;
            int iMax = x < (fieldSize[0] - 1) ? (x+2) : (x+1);
            int jMax = y < (fieldSize[1] - 1) ? (y+2) : (y+1);

            for (int i = iMin; i < iMax; i ++){
                for (int j = jMin; j < jMax; j ++) {
                    if ((f[i][j] == 0) && (field[i][j] == 0)) {
                        field[i][j] = z;
                        q.add(i);
                        q.add(j);
                        sizeQ ++;
                    }
                    else {
                        if (f[i][j] == -1) {
                            field[i][j] = -1;
                        }
                    }
                }
            }
        }
    }
}
