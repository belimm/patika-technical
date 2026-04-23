package manavakasa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Ürün fiyatları (TL/KG)
        double armutFiyat = 2.14;
        double elmaFiyat = 3.67;
        double domatesFiyat = 1.11;
        double muzFiyat = 0.95;
        double patlicanFiyat = 5.00;

        // Kullanıcıdan kilo bilgilerini al
        System.out.print("Armut Kaç Kilo ? :");
        double armutKilo = scan.nextDouble();

        System.out.print("Elma Kaç Kilo ? :");
        double elmaKilo = scan.nextDouble();

        System.out.print("Domates Kaç Kilo ? :");
        double domatesKilo = scan.nextDouble();

        System.out.print("Muz Kaç Kilo ? :");
        double muzKilo = scan.nextDouble();

        System.out.print("Patlıcan Kaç Kilo ? :");
        double patlicanKilo = scan.nextDouble();

        // Toplam tutarı hesapla
        double toplamTutar = (armutKilo * armutFiyat) +
                             (elmaKilo * elmaFiyat) +
                             (domatesKilo * domatesFiyat) +
                             (muzKilo * muzFiyat) +
                             (patlicanKilo * patlicanFiyat);

        System.out.println("Toplam Tutar : " + toplamTutar + " TL");

        scan.close();
    }
}
