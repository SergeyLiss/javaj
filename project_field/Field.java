package javaj.project_field;

import java.util.Random;

public class Field {
    private static int[][] fieldMap; // Поле
    private static int[] fieldSize = new int[2]; // Столбцы, строки
    private static int[] points = new int[4]; // Координаты начала и конца
    private static int filling = 4; // Вероятность постройки стены (1:filling)
    public Field(int column, int row) {
        fieldSize[0] = column;
        fieldSize[1] = row;
        fieldMap = new int[column][row];
    }

    // Вывод поля
    public int[][] getMap () { return fieldMap;}
    // Вывод размера поля
    public int[] getMapSize () { return fieldSize;}
    // Вывод координат начала и конца
    public int[] getPoints () { return points;}

    // Генерация координат начала и конца
    public void generationPoints() {
        Random rand = new Random();

        boolean exit_v = rand.nextBoolean();
        int exit_w = rand.nextInt((exit_v ? fieldSize[0] : fieldSize[1]));

        points[0] = rand.nextInt(2, (fieldSize[0] - 2));
        points[1] = rand.nextInt(2, (fieldSize[1] - 2));

        if (rand.nextBoolean()) {
            points[2] = exit_w;
            if (exit_v) { points[3] = fieldSize[1] - 1;}
        }
        else {
            points[3] = exit_w;
            if (exit_v) { points[2] = fieldSize[0] - 1;}
        }
    }

    // Генерация стен
    public void generationWall() {
        Random rand = new Random();

        for (int i = 0; i < fieldSize[0]; i ++)
            for (int j = 0; j < fieldSize[1]; j ++) 
                if (rand.nextInt(0, filling) == 0) { fieldMap[i][j] = -1;}
    }
}
