package javaj.obj_orn_prg.lesson_2;

import java.util.Random;

public class Program {
    public static Zoopark ten = new Zoopark();
    public static Random rand = new Random();

    public static void main() {
        // Кот, Тигр, Собака, Волк, Курица, Аист
        for(int i = 0; i < rand.nextInt(20); i ++) {
            int j = rand.nextInt(0, 5);
            if(j == 0) { ten.added(new Stork());}
            else if(j == 1) { ten.added(new Tiger());}
            else if(j == 2) { ten.added(new Dog());}
            else if(j == 3) { ten.added(new Wolf());}
            else if(j == 4) { ten.added(new Chicken());}
            else { ten.added(new Cat());}
        }

        for(int i = 0; i < ten.getSize(); i ++) {
            System.out.println(ten.getValue(i));
        }
    }
}
