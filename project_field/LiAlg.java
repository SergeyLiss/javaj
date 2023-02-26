package javaj.project_field;

import java.util.LinkedList;
import java.util.Queue;

public class LiAlg {
    static boolean moveFlag = false;
    int[][] fieldOut;
    int[][] pathOut;
    
    public LiAlg(int[] patherIn, int[][] fieldIn) {
        this.fieldOut = searchAllPath(patherIn, fieldIn);
        this.pathOut = searchPath(patherIn, this.fieldOut);
    }

    public static int[][] searchPath(int[] p, int[][] f) {
        int sizeColumn = f.length;
        int sizeRow = f[0].length;
        int[][] result = new int[sizeColumn][sizeRow];

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(p[2]);
        q.add(p[3]);

        int sizeQ = 1;

        while (sizeQ > 0) {
            boolean flag = true;
            int x = q.remove();
            int y = q.remove();
            sizeQ --;
            int z = f[x][y] - 1;

            int iMin = x > 0 ? (x-1) : x;
            int jMin = y > 0 ? (y-1) : y;
            int iMax = x < (sizeColumn - 1) ? (x+2) : (x+1);
            int jMax = y < (sizeRow - 1) ? (y+2) : (y+1);

            for (int i = iMin; i < iMax; i ++){
                for (int j = jMin; j < jMax; j ++) {
                    if ((f[i][j] == z) && (z >= 0) && flag) {
                        result[i][j] = 1;
                        q.add(i);
                        q.add(j);
                        sizeQ ++;
                        flag = false;
                    }
                }
            }
        }
        return result;
    }

    public static int[][] searchAllPath(int[] p, int[][] f) {
        int sizeColumn = f.length;
        int sizeRow = f[0].length;
        int[][] result = new int[sizeColumn][sizeRow];

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
            int z = result[x][y] + 1;

            int iMin = x > 0 ? (x-1) : x;
            int jMin = y > 0 ? (y-1) : y;
            int iMax = x < (sizeColumn - 1) ? (x+2) : (x+1);
            int jMax = y < (sizeRow - 1) ? (y+2) : (y+1);

            for (int i = iMin; i < iMax; i ++){
                for (int j = jMin; j < jMax; j ++) {
                    if ((f[i][j] == 0) && (result[i][j] == 0)) {
                        result[i][j] = z;
                        q.add(i);
                        q.add(j);
                        sizeQ ++;
                    }
                    else {
                        if (f[i][j] == -1) {
                            result[i][j] = -1;
                        }
                    }
                }
            }
        }
        return result;
    }
}
