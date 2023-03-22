package javaj.obj_orn_prg.lesson_1;

public class Program {
    public static void main(String[] args) {
        // Product cola = new Product("Coca-Cola");
        Lemonade cola = new Lemonade("Coca-Cola");
        cola.setPrice(100);
        cola.setAmount(1);
        cola.setUnit("шт.");
        cola.setVolume(1);
        System.out.println(cola.toString());
    }
}
