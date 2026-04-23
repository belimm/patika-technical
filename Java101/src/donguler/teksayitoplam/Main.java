package donguler.teksayitoplam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int toplam = 0;

        System.out.print("Bir sayı giriniz: ");
        int sayi = input.nextInt();

        while (sayi % 2 == 0) {  // Tek sayı girilene kadar devam et
            if (sayi % 2 == 0 && sayi % 4 == 0) {  // Çift ve 4'ün katı ise topla
                toplam += sayi;
                System.out.println(sayi + " toplama eklendi.");
            } else {
                System.out.println(sayi + " çift ama 4'ün katı değil, eklenmedi.");
            }

            System.out.print("Bir sayı giriniz: ");
            sayi = input.nextInt();
        }

        System.out.println("\nTek sayı girildi, program sonlandı.");
        System.out.println("Toplam : " + toplam);

        input.close();
    }
}