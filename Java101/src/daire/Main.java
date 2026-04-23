package daire;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(2);
        double area = circle.calculateArea(360);
        double perimeter = circle.calculatePerimeter(360);

        System.out.println("Alan: "+ area);
        System.out.println("Çevre: "+ perimeter);
    }
}
