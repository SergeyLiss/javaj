package javaj.obj_orn_prg.lesson_6;
// Коммутатор между методами

public class Swith {
    Double resultat;
    Handler expression;
    
    public Swith(String w) {
        expression = new Handler(w);
        System.out.println(expression.getElements());
        System.out.println(expression.getSizeElements());
    }
}
