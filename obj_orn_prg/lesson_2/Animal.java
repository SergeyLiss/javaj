package javaj.obj_orn_prg.lesson_2;

// Животное
abstract class Animal {
    String name = "*"; // Имя
    int height = 0; // Рост
    int weight = 0; // Вес
    String eyeColor = "*"; // Цвет глаз

    void setAnimal(String n, int h, int w, String e) {
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

interface AnimalInter {
    
    // Издать звук
    String voice();
    
    // Напечатать информацию о животном
    String toString();
}

// Домашнее животное
abstract class Pet extends Animal {
    String nickname = "*"; // Кличка
    String breed = "*"; // Порода
    Boolean vaccinations = false; // Наличие прививок
    String coatColor = "*"; // Цвет шерсти
    String birthDate = "*"; // Дата рождения

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

interface PetInter extends AnimalInter {
    // Проявлять ласку
    String caress();
}

// Дикое животное
abstract class Wild extends Animal {
    String habitat = "*"; // Место обитания
    String dateFound = "*"; // Дата нахождения

    void setWild(String h, String f) {
        habitat = h;
        dateFound = f; 
    }

    public String getWild() {
        return String.format("Место обитания: %s\nДата нахождения: %s\n",
                                                                habitat, dateFound);
    }
}

abstract class Bird extends Animal implements AnimalInter {
    protected int flightAltitude = 0; // Высота полёта

    public void setBird(int f) { flightAltitude = f;}

    public String getBird() { return String.format("Я лечу на %d метрах.\n", flightAltitude);}
}

// Кот
class Cat extends Pet implements PetInter {
    boolean wool = true; // Наличие шерсти

    public Cat() { name = "Кошак";}

    void setWool(boolean w) { wool = w;}
    boolean getWool() { return wool;}

    @Override
    public String voice() { return "мяу";}

    @Override
    public String caress() { return "Ласка проявлена";}
    
    @Override
    public String toString() {
        return super.getAnimal() + super.getPet() + String.format("Наличие шерсти: %b\n", wool);
    }
}

// Тигр
class Tiger extends Wild implements AnimalInter{
    public Tiger() { name = "Тигра";}

    @Override
    public String voice() { return "рык";}
    
    @Override
    public String toString() {
        return super.getAnimal() + super.getWild();
    }
}

// Собака
class Dog extends Pet implements PetInter {
    boolean training = false; // Наличие дрессировки

    public Dog() { name = "Собакен";}

    void setTraining(boolean t) { training = t;}
    boolean getTraining() { return training;}

    public String train() { return "Дрессировка";}

    @Override
    public String voice() { return "гав";}

    @Override
    public String caress() { return "Виляние хвостом";}
    
    @Override
    public String toString() {
        return super.getAnimal() + super.getPet() + String.format("Наличие дрессировки: %b\n", training);
    }
}

// Волк
class Wolf extends Wild implements AnimalInter{
    boolean leader = false; // Вожак стаи

    public Wolf() { name = "Волк";}

    void setLeader(boolean l) { leader = l;}
    boolean getLeader() { return leader;}

    @Override
    public String voice() { return "ррр";}
    
    @Override
    public String toString() {
        return super.getAnimal() + super.getWild() + String.format("Вожак стаи: %b\n", leader);
    }
}

// Курица
class Chicken extends Bird {
    public Chicken() { name = "Курица";}

    @Override
    public String voice() { return "куда-х-чет";}
    
    @Override
    public String toString() { return super.getAnimal();}
}

// Аист
class Stork extends Bird {
    public Stork() { name = "Аист";}

    @Override
    public String voice() { return "клекот";}
    
    @Override
    public String toString() { return super.getAnimal();}
}



