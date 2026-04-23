package daire;

public class Circle {
    private static double PI = 3.14;
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public static double getPI() {
        return PI;
    }

    public static void setPI(double PI) {
        Circle.PI = PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double validateDegree(double degree) {
        if (degree <0 )
            return 0;
        else if(degree> 360)
            degree = 360;

        return degree;
    }


    public double calculateArea(double degree) {
        degree = validateDegree(degree);

        return Math.pow(this.radius, 2)*getPI()* degree /360;
    }

    public double calculatePerimeter(double degree) {
        degree = validateDegree(degree);

        return 2*getPI()*this.radius * degree /360;
    }
}

