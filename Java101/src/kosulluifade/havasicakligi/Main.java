package kosulluifade.havasicakligi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Sıcaklığı giriniz: ");
        int sicaklik = input.nextInt();

        String oneri;

        if (sicaklik < 5) {
            oneri = "Kayak";
        } else if (sicaklik <= 15) {
            oneri = "Sinema";
        } else if (sicaklik <= 25) {
            oneri = "Piknik";
        } else {
            oneri = "Yüzme";
        }

        switch (oneri) {
            case "Kayak":
                System.out.println("Öneri: Kayak");
                break;
            case "Sinema":
                System.out.println("Öneri: Sinema");
                break;
            case "Piknik":
                System.out.println("Öneri: Piknik");
                break;
            default:
                System.out.println("Öneri: Yüzme");
        }

        input.close();
    }
}