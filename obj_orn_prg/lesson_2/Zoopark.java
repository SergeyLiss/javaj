package javaj.obj_orn_prg.lesson_2;

import java.util.ArrayList;

public class Zoopark {
    ArrayList<Object> zoop = new ArrayList<>();

    public void added(Object t) { zoop.add(t);}

    public Object getValue(int index) { return zoop.get(index);}

    public int getSize() { return zoop.size();}

    public void delete(int index) {
        int size = zoop.size();
        if((index >= size) || (index < 0)) { System.err.println("Ошибка");}
        else {
            ArrayList<Object> temp = new ArrayList<>();
            for(int i = 0; i < size; i ++)
                if(i != index)
                    temp.add(zoop.get(i));
            
            zoop = temp;
        }
    }
}
