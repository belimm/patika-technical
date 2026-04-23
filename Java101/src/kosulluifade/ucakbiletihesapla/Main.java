package kosulluifade.ucakbiletihesapla;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Mesafeyi km türünden giriniz : ");
        double mesafe = input.nextDouble();

        System.out.print("Yaşınızı giriniz : ");
        int yas = input.nextInt();

        System.out.print("Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ): ");
        int yolculukTipi = input.nextInt();

        // Geçerlilik kontrolü
        if (mesafe <= 0 || yas <= 0 || (yolculukTipi != 1 && yolculukTipi != 2)) {
            System.out.println("Hatalı Veri Girdiniz !");
        } else {

            // Normal tutar
            double normalTutar = mesafe * 0.10;

            // Yaş indirim oranı
            double yasIndirimOrani = 0;

            if (yas < 12) {
                yasIndirimOrani = 0.50;
            } else if (yas <= 24) {
                yasIndirimOrani = 0.10;
            } else if (yas > 65) {
                yasIndirimOrani = 0.30;
            }

            // Yaş indirimi uygula
            double yasIndirimi   = normalTutar * yasIndirimOrani;
            double indirimliTutar = normalTutar - yasIndirimi;

            // Gidiş-dönüş indirimi
            double toplamTutar;

            if (yolculukTipi == 2) {
                double gidisDonusIndirimi = indirimliTutar * 0.20;
                toplamTutar = (indirimliTutar - gidisDonusIndirimi) * 2;
            } else {
                toplamTutar = indirimliTutar;
            }

            System.out.println("\nToplam Tutar = " + toplamTutar + " TL");
        }

        input.close();
    }
}