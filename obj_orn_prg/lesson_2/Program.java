package javaj.obj_orn_prg.lesson_2;

import java.util.Random;

public class Program {
    public static Zoopark ten = new Zoopark();
    public static Random rand = new Random();
    public static void main(String[] args) {
        createZoopark(rand.nextInt(5, 10));

        showAllAnimal();

        // showZoopark(1);
        // voiceZoopark(1);
        // showAllZoopark();
        // voiceAllZoopark();
    }

    static void createZoopark(int a) {
        // Кот, Тигр, Собака, Волк, Курица, Аист
        for(int i = 0; i < a; i ++) {
            int j = rand.nextInt(0, 5);
            if(j == 0) { ten.added(new Stork());}
            else if(j == 1) { ten.added(new Tiger());}
            else if(j == 2) { ten.added(new Dog());}
            else if(j == 3) { ten.added(new Wolf());}
            else if(j == 4) { ten.added(new Chicken());}
            else { ten.added(new Cat());}
        }
    }

    static void showAllAnimal(){
        System.out.println("Список животных:");
        for(int i = 0; i < ten.getSize(); i ++) {
            String temp;
            if(ten.getValue(i) instanceof Stork) { temp = "Аист";}
            else if(ten.getValue(i) instanceof Tiger) { temp = "Тигра";}
            else if(ten.getValue(i) instanceof Dog) { temp = "Собакен";}
            else if(ten.getValue(i) instanceof Wolf) { temp = "Волк";}
            else if(ten.getValue(i) instanceof Chicken) { temp = "Курица";}
            else { temp = "Кошак";}
            System.out.println("\t" + temp);
        }
        System.out.println();
    }

    static void voiceZoopark(int i) {
        String temp;
        if(ten.getValue(i) instanceof Stork) { temp = ((Stork) ten.getValue(i)).voice();}
        else if(ten.getValue(i) instanceof Tiger) { temp = ((Tiger) ten.getValue(i)).voice();}
        else if(ten.getValue(i) instanceof Dog) { temp = ((Dog) ten.getValue(i)).voice();}
        else if(ten.getValue(i) instanceof Wolf) { temp = ((Wolf) ten.getValue(i)).voice();}
        else if(ten.getValue(i) instanceof Chicken) { temp = ((Chicken) ten.getValue(i)).voice();}
        else { temp = ((Cat) ten.getValue(i)).voice();}
        System.out.println("Животное издало звук: " + temp);
    }

    static void voiceAllZoopark() {
        System.out.println("Хор животных:");
        for(int i = 0; i < ten.getSize(); i ++) {
            String temp;
            if(ten.getValue(i) instanceof Stork) { temp = ((Stork) ten.getValue(i)).voice();}
            else if(ten.getValue(i) instanceof Tiger) { temp = ((Tiger) ten.getValue(i)).voice();}
            else if(ten.getValue(i) instanceof Dog) { temp = ((Dog) ten.getValue(i)).voice();}
            else if(ten.getValue(i) instanceof Wolf) { temp = ((Wolf) ten.getValue(i)).voice();}
            else if(ten.getValue(i) instanceof Chicken) { temp = ((Chicken) ten.getValue(i)).voice();}
            else { temp = ((Cat) ten.getValue(i)).voice();}
            System.out.println("\t" + temp);
        }
    }

    static void showZoopark(int a) { ten.getValue(a);}

    static void showAllZoopark() { for(int i = 0; i < ten.getSize(); i ++)
                                     { System.out.println(ten.getValue(i));}}

}
