package javaj.obj_orn_prg.lesson_5;

import java.util.ArrayList;

public class Calculate {
    String[] listNumber = {"0","1","2","3","4","5","6","7","8","9"};
    String[] listSymbol = {"(",")","*","/","+","-"};
    String phrase;
    ArrayList<Integer> number = new ArrayList<>();
    ArrayList<Object> expression;
    boolean vern = true;

    public Calculate (String p) {
        if(p instanceof String) { phrase = p;}
        else { vern = false;}
    }

    public int calculation() {
        strToNumber();
        expression.add(convert());
        return 5;
    }

    void strToNumber() {
        String temp10 = phrase; // Ветвь чисел
        String temp20 = phrase; // Ветвь символов

        for(int i = 0; i < 6; i ++) {
            temp10 = temp10.replace(listSymbol[i], " ");}
        for(int i = 0; i < 10; i ++) {
            temp20 = temp20.replace(listNumber[i], "");}
        
        String[] temp11 = temp10.split(" ");
        String temp21;
        for(int i = 1; i < temp20.length(); i ++) {
            
        }
        
        for (String t : temp11) {
            if (t.length() != 0) {
                number.add(Integer.valueOf(t));}
        }
        System.out.println(number);
        System.out.println(temp20);
    }

    ArrayList<Object> convert(){
        int i = 0;
        ArrayList<Object> localExpression = new ArrayList<>();

        while (phrase.length() != 0) {
            if (phrase.charAt(i) == '(') {
                localExpression.add(phrase.substring(0, i));
                phrase = phrase.substring((i+1));
                localExpression.add(convert());
            }
            else if(phrase.charAt(i) == ')') {
                localExpression.add(phrase.substring(0, i));
                phrase = phrase.substring((i+1));
            }
            else {
                if (i < phrase.length()) {i ++;}
            }
        }
        System.out.println(phrase);
        System.out.println(localExpression);
        return localExpression;
    }
    
}


interface InnerCalculate<T> {

    T addition(); // Сложение
    T subtraction(); // Вычитание
    T division(); // Деление
    T multiplication(); // Умножение
    
}
