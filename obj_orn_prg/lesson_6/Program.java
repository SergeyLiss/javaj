 package javaj.obj_orn_prg.lesson_6;

class Program {

    public static void main(String[] args) {
        String alf = "((4+84)7)-3*(9(64+7))";

        Calculate s = new Calculate(alf);
        s.calculation();
        
        System.out.println(s.expression);
    }

    
}