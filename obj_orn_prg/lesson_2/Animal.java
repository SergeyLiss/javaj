package javaj.obj_orn_prg.lesson_2;

// Животное
abstract class AnimalField {
    String name = ""; // Имя
    int height = 0; // Рост
    int weight = 0; // Вес
    String eyeColor = ""; // Цвет глаз

    public void setAnimal(String n, int h, int w, String e) {
        name = n;
        height = h;
        weight = w;
        eyeColor = e;
    }

    public String getAnimal() {
        return String.format("Имя: %s\nРост: %d\nВес: %d\nЦвет глаз: %s\n",
                                                    name, height, weight, eyeColor);
    }
}

public interface Animal {
    
    // Издать звук
    String voice();
    
    // Напечатать информацию о животном
    String toString();
}

// Домашнее животное
abstract class PetField extends AnimalField {
    String nickname = ""; // Кличка
    String breed = ""; // Порода
    Boolean vaccinations = false; // Наличие прививок
    String coatColor = ""; // Цвет шерсти
    String birthDate = ""; // Дата рождения

    void setPet(String n, String b, Boolean v, String c, String d) {
        nickname = n;
        breed = b;
        vaccinations = v;
        coatColor = c;
        birthDate = d;
    }

    public String getPet() {
        return String.format("Кличка: %s\nПорода: %s\nНаличие прививок: %b\nЦвет шерсти: %s\nДата рождения: %s\n",
                                                                        nickname, breed, vaccinations, coatColor, birthDate);
    }
}

interface Pet extends Animal {
    // Проявлять ласку
    String caress();
}

// Дикое животное
abstract class WildField extends AnimalField {
    String habitat; // Место обитания
    String dateFound; // Дата нахождения

    void setWild(String h, String f) {
        habitat = h;
        dateFound = f; 
    }

    public String getWild() {
        return String.format("Место обитания: %s\nДата нахождения: %s\n",
                                                                habitat, dateFound);
    }
}

// Кот
class Cat extends PetField implements Pet {
    boolean wool; // Наличие шерсти

    @Override
    public String voice() { return "мяу";}

    @Override
    public String caress() { return "Ласка проявлена";}
    
    @Override
    public String toString() {
        return super.getAnimal() + super.getPet() + String.format("Наличие шерсти: %b\n", wool);
    }
}




