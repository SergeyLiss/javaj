package javaj.obj_orn_prg.lesson_6;
// Обработчик строки в выражение

import java.util.ArrayList;
import java.util.Arrays;

public class Handler {
    String[] elements;
    int sizeElements;
    ArrayList<Object> phrase;

    public Handler(String w) {
        this.elements = handlerStepSpace(w);
        this.sizeElements = elements.length;
        this.phrase = convert(0);
    }

    // Добавление пробелов между отдельными элементами выражения
    private String[] handlerStepSpace(String str) {
        String listSymbol = "()*/+-";
        int i = 0;

        while (str.length() > i) {
            if (listSymbol.contains(str.substring(i, (i+1)))){
                str = str.substring(0,i) + " "
                        + str.substring(i,(i+1)) + " "
                        + str.substring((i+1), str.length());
                i ++;
            }
            i ++;
        }

        
        i = 1;
        str = str.substring(i);
        while (str.length() > i) {
            if ((str.charAt(i) == ' ') && (str.charAt(i) == str.charAt(i-1))) {
                str = str.substring(0, (i-1)) + str.substring(i);
            }
            i ++;
        }
        
        return str.split(" ");
    }

    ArrayList<Object> getPhrase() { return phrase;}
    String getElements() { return Arrays.toString(elements);}
    int getSizeElements() { return sizeElements;}

    ArrayList<Object> convert(int step) {

        return phrase;
    }
}
