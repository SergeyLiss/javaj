package javaj.obj_orn_prg.lesson_6;
// Обработчик строки в выражение

import java.util.ArrayList;
import java.util.Arrays;

public class Handler {
    private ArrayList<Object> phrase; // Выражение в удобном виде
    private String[] elements; // Выражение в виде массива
    private int sizeElements; // Размер строкового массива
    private int step; // Переменная для метода convert()

    public Handler(String w) {
        this.elements = handlerStepSpace(w);
        this.sizeElements = elements.length;
        this.step = 0;
        this.phrase = convert();
    }

    // Преобразование в массив строк
    private String[] handlerStepSpace(String str) {
        String listSymbol = "()*/+-";
        int i = 1;

        // Добавление знака умножить между числом и скобкой
        while (str.length() > i) {
            if (str.charAt(i) == '(') {
                if (!listSymbol.contains(str.substring((i-1), i))) {
                    str = str.substring(0, i) + "*"
                        + str.substring(i, str.length());
                }
            }
            else {
                if (str.charAt((i-1)) == ')') {
                    if (!listSymbol.contains(str.substring(i, (i+1)))) {
                        str = str.substring(0,i) + "*"
                            + str.substring(i, str.length());
                    }
                }
            }
            i ++;
        }

        // Добавление пробелов между элементами выражения
        i = 0;
        while (str.length() > i) {
            if (listSymbol.contains(str.substring(i, (i+1)))){
                str = str.substring(0,i) + " "
                        + str.substring(i,(i+1)) + " "
                        + str.substring((i+1), str.length());
                i ++;
            }
            i ++;
        }

        // Удаление лишних пробелов
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

    ArrayList<Object> getPhrase() { return phrase;} // <- Выражение в ArrayList
    String getElements() { return Arrays.toString(elements);} // <- Выражение в виде строки
    int getSizeElements() { return sizeElements;} // <- Размер массива строк

    // Конертирование в ArrayList
    ArrayList<Object> convert() {
        ArrayList<Object> temp = new ArrayList<>();

        while (step < sizeElements) {
            if (elements[step].equals("(")) {
                step ++;
                temp.add(convert());
            }
            else if (elements[step].equals(")")) { return temp;}
            else { temp.add(elements[step]);}
            step ++;
        }
        
        return temp;
    }
}
