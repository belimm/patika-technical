package hipotenüs;

public class Main {

    public static void main(String[] args) {
        Triangle t1 = new Triangle(3,4);

        System.out.println("Hypotenuse:" + t1.calculateHypotenuse());

        System.out.println("Area:"+ t1.calculateArea());

        System.out.println("Perimeter:"+ t1.calculatePerimeter());
    }


}
