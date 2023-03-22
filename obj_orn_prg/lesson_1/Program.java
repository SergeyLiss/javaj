package javaj.obj_orn_prg.lesson_1;

public class Program {
    public static void main(String[] args) {
        Lemonade cola = new Lemonade("Coca-Cola");
        cola.setPrice(100);
        cola.setAmount(1);
        cola.setUnit("шт.");
        cola.setVolume(1);
        System.out.println(cola.toString());

        System.out.println();

        Diapers pamp = new Diapers("Pampers");
        pamp.setPrice(500);
        pamp.setAmount(20);
        pamp.setUnit("шт.");
        pamp.setMinAge(0);
        pamp.setHypoallergenic(true);
        pamp.setSize(24);
        pamp.setMinWeight(1);
        pamp.setMaxWeight(15);
        pamp.setType("Впитывающие");
        System.out.println(pamp.toString());
    }
}
