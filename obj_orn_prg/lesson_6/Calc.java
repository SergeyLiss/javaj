package javaj.obj_orn_prg.lesson_6;
// Калькулятор 

public class Calc {
    Double a;
    Double b;

    public Calc() {}

    void setA(Double x) { this.a = x;}
    void setB(Double y) { this.b = y;}

    // Сложение
    public Double add() { return this.a + this.b;} 
    // Вычитание
    public Double sub() { return this.a - this.b;} 
    // Деление
    public Double div() { return this.a / this.b;} 
    // Умножение
    public Double mul() { return this.a * this.b;} 
}
