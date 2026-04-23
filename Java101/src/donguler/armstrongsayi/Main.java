package donguler.armstrongsayi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Sayı Giriniz: ");
        int sayi = input.nextInt();

        int tempSayi = sayi;
        int toplam   = 0;

        while (tempSayi != 0) {
            int basamak = tempSayi % 10;  // Son basamağı al
            toplam     += basamak;         // Toplama ekle
            tempSayi   /= 10;             // Sayıyı bir basamak küçült
        }

        System.out.println("\n--- HESAPLAMA ---");
        System.out.println(sayi + " sayısının basamakları toplamı = " + toplam);

        input.close();
    }
}