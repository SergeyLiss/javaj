package javaj.obj_orn_prg.lesson_6;
// Коммутатор между методами

import java.util.ArrayList;

public class Swith {
    private Double result = -1.0; // Результат вычисления
    private Handler exp; // Выражение
    private Calc calculate = new Calc();
    private int operand = 0;
    

    
    public Swith(String w) {
        exp = new Handler(w);
        // System.out.println(exp.getElements());
        // System.out.println(exp.getPhrase());
        result = operation(exp.getPhrase()); 
    }

    // Возврат результата
    Double getResult() { return result;}

    Double operation(ArrayList<?> w) {
        Double res = 1.0;
        for(int i = 0; i < w.size(); i ++){
            if (w.get(i) instanceof String) {
                if (indexListS((String) w.get(i)) >= 0) {
                    System.out.println(w.get(i));
                }
            }
        }
        return res;
    }

    int indexListS(String value) {
        String[] listSymbol = {"*", "/", "+", "-"};
        int start = -1;
        for(int i = 0; i < 4; i ++)
            if (listSymbol[i].equals(value)) { return i;}
        
        return start;
    }

    // Double operation(ArrayList<?> w) {
    //     Boolean flag = true; // Флаг оператора
    //     String listSymbol = "*/+-";
    //     String operand = "";
    //     Double res = 1.0;
    //     int i = 0;
    //     while (i < w.size()) {
    //         if (w.get(i) instanceof ArrayList<?>) {
    //             res = operation((ArrayList<?>) w.get(i));}
    //         // else {
    //         //     if (listSymbol.contains((CharSequence) w.get(i))) {

    //         //     }
    //         //     else {
    //         //         if (!flag) { calculate.setA(Double.valueOf((String) w.get(i)));}
    //         //         else 
    //         //     }
    //         // }
    //     }
        
    //     // Double.valueOf(y)
    //     return res;
    // }

    // <T> Double operation(T w) {
    //     ArrayList<Object> z = (ArrayList<Object>) w;
    //     Double res;
    //     int i = 0;

    //     while (i < z.size()) {
    //         if (z.get(i) instanceof ArrayList) {
    //             res = operation(z.get(i));
    //         }
    //     }
        
    //     // Double.valueOf(y)
    //     return res;
    // }
}
