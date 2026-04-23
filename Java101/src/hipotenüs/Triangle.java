package hipotenüs;

public class Triangle {
    public double a;
    public double b;
    public double c;

    public Triangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double calculateHalfPerimeter() {
        return (this.a + this.b + this.c)/2;

    }

    public double calculatePerimeter() {
        return calculateHalfPerimeter()*2;
    }

    public double calculateArea() {
        double u =  calculateHalfPerimeter();
        return Math.sqrt(u* Math.abs(u-this.a)*Math.abs(this.b-u)*Math.abs(this.c-u));
    }

    public double calculateHypotenuse() {
        return this.c =  Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
    }
}
