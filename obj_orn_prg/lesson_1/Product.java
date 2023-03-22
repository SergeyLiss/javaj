package javaj.obj_orn_prg.lesson_1;

// Товар
public class Product {
    private String name;
    private int price;
    private int amount;
    private String unit;

    public Product(String n){ this.name = n;}

    public void setPrice(int p){ this.price = p;}
    public void setAmount(int a){ this.amount = a;}
    public void setUnit(String u){ this.unit = u;}

    public String getName(){ return name;}
    public int getPrice(){ return price;}
    public int getAmount(){ return amount;}
    public String getUnit(){ return unit;}
    public String toString(){
        String outProduct = String.format("Наименование: %s\nЦена: %d\nКоличество: %d\nЕдиница измерения: %s\n",
                                             name, price, amount, unit);
        return outProduct;
    }
}

// Продукт питания
class Foodstuff extends Product {
    String data;

    public Foodstuff(String n){ super(n);}

    public void setDataline(String d){ this.data = d;}

    public String getDataline(){ return data;}

    @Override
    public String toString() {
        String outFood = super.toString();
        outFood = String.format((outFood + "Срок годности: %s\n"), data);
        return outFood;
    }
}

// Напитки
class Beverage extends Product {
    private int volume;

    public Beverage(String n){ super(n);}

    public void setVolume(int v){ this.volume = v;}

    public int getVolume(){ return volume;}

    @Override
    public String toString() {
        String outBever = super.toString();
        outBever = String.format((outBever + "Срок годности: %s\n"), volume);
        return outBever;
    }
}

// Предмет гигиены
class HygieneItem extends Product {
    private int piecePack;

    public HygieneItem(String n){ super(n);}

    public void setVolume(int p){ this.piecePack = p;}

    public int getVolume(){ return piecePack;}

    @Override
    public String toString() {
        String outItem = super.toString();
        outItem = String.format((outItem + "Срок годности: %s\n"), piecePack);
        return outItem;
    } 
}

// Детские товары
class ChildenProduct extends Product {
    private int minAge;
    private boolean hypoallergenic;

    public ChildenProduct(String n){ super(n);}

    public void setMinAge(int a){ this.minAge = a;}
    public void setHypoallergenic(boolean h){ this.hypoallergenic = h;}

    public int getMinAge(){ return minAge;}
    public boolean getHypoallergenic(){ return hypoallergenic;}

    @Override
    public String toString() {
        String outHypp = super.toString();
        outHypp = String.format((outHypp + "Минимальный возраст: %d\nГипоаллергенность: %b\n"), minAge, hypoallergenic);
        return outHypp;
    } 
}

// Молоко
class Milk extends Beverage {
    private int fat;
    private String data;

    public Milk(String n){ super(n);}

    public void setDataline(String d){ this.data = d;}
    public void setFat(int f){ this.fat = f;}

    public String getDataline(){ return data;}
    public int getFat(){ return fat;}

    @Override
    public String toString() {
        String outMilk = super.toString();
        outMilk = String.format((outMilk + "Процент жирности: %d\nСрок годности: %s\n"), fat, data);
        return outMilk;
    } 
}

// Лимонад
class Lemonade extends Beverage {

    public Lemonade(String n) { super(n);}

    @Override
    public String toString() { return super.toString();} 
}

// Хлеб
class Bread extends Foodstuff {
    String flour;

    public Bread(String n){ super(n);}

    public void setFlour(String f){ this.flour = f;}

    public String getFlour(){ return flour;}

    @Override
    public String toString() {
        String outFlour = super.toString();
        outFlour = String.format((outFlour + "Тип муки: %s\n"), flour);
        return outFlour;
    }
}

// Яйца
class Egg extends Foodstuff {
    private int piecePack;

    public Egg(String n){ super(n);}

    public void setVolume(int p){ this.piecePack = p;}

    public int getVolume(){ return piecePack;}

    @Override
    public String toString() {
        String outEgg = super.toString();
        outEgg = String.format((outEgg + "Количество в упаковке: %s\n"), piecePack);
        return outEgg;
    }
}

// Маски
class Mask extends HygieneItem {

    public Mask(String n){ super(n);}

    @Override
    public String toString() { return super.toString();} 
}

// Туалетная бумага
class ToiletPaper extends HygieneItem {
    private int layer;

    public ToiletPaper(String n){ super(n);}

    public void setLayer(int l){ this.layer = l;}

    public int getLayer(){ return layer;}

    @Override
    public String toString() {
        String outLay = super.toString();
        outLay = String.format((outLay + "Количество слоёв: %d\n"), layer);
        return outLay;
    } 
}

// Подгузники
class Diapers extends ChildenProduct {
    private int size;
    private int minWeight;
    private int maxWeight;
    private String type;

    public Diapers(String n){ super(n);}

    public void setSize(int s){ this.size = s;}
    public void setMinWeight(int w){ this.minWeight = w;}
    public void setMaxWeight(int w){ this.maxWeight = w;}
    public void setType(String t){ this.type = t;}

    public int getSize(){ return size;}
    public int getMinWeight(){ return minWeight;}
    public int getMaxWeight(){ return maxWeight;}
    public String getType(){ return type;}

    @Override
    public String toString() {
        String outDiap = super.toString();
        outDiap = String.format((outDiap + "Размер: %d\nМинимальный вес: %d\nМаксимальный вес: %d\nТип: %s\n"), 
                                    size, minWeight, maxWeight, type);
        return outDiap;
    } 
}

// Соска
class Pacifier extends ChildenProduct {

    public Pacifier(String n){ super(n);}

    @Override
    public String toString() { return super.toString();} 
}