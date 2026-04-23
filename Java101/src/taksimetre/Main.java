package taksimetre;

public class Main {

    public static void main(String[] args) {
        double taksiUcreti = taksiMetre(10.6);
        System.out.println("Taksi ücreti: "+ taksiUcreti);
    }

    public static double taksiMetre(double km) {
        double amount = 2.20 * km;
        return amount<20 ? 20 : amount + 10;
    }
}
