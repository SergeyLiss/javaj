package javaj.obj_orn_prg.lesson_6;
// Калькулятор 

public class Calc {
    Double a;
    Double b;

    public Calc(String x, String y) {
        this.a = Double.valueOf(x);
        this.b = Double.valueOf(y);
    }

    // Сложение
    public Double addition() { return this.a + this.b;} 
    // Вычитание
    public Double subtraction() { return this.a - this.b;} 
    // Деление
    public Double division() { return this.a / this.b;} 
    // Умножение
    public Double multiplication() { return this.a * this.b;} 
}
