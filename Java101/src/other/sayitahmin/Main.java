package other.sayitahmin;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random  rand   = new Random();
        Scanner input  = new Scanner(System.in);

        int     number   = rand.nextInt(101);  // 0-100
        int     hakSayisi = 5;
        int     kullanilanHak = 0;
        int[]   yanlisTahminler = new int[hakSayisi];
        boolean isWin    = false;
        boolean isWrong  = false;

        System.out.println("🎮 Sayı Tahmin Oyununa Hoşgeldiniz!");
        System.out.println("0-100 arasında bir sayı tuttum. " + hakSayisi + " hakkınız var.");
        System.out.println("=====================================");

        while (kullanilanHak < hakSayisi) {
            System.out.print("\nTahmininiz : ");
            int selected = input.nextInt();

            // Geçersiz giriş kontrolü
            if (selected < 0 || selected > 100) {
                System.out.println("⚠️  Lütfen 0-100 arasında bir değer giriniz!");
                if (isWrong) {
                    kullanilanHak++;
                    System.out.println("❌ Hakkınızdan düşüldü! Kalan hak : " + (hakSayisi - kullanilanHak));
                } else {
                    isWrong = true;
                    System.out.println("⚠️  Uyarı: Bir daha hatalı girişte hakkınızdan düşülecek!");
                }
                continue;
            }

            // Doğru tahmin
            if (selected == number) {
                System.out.println("=====================================");
                System.out.println("🎉 Tebrikler! Doğru tahmin ettiniz!");
                System.out.println("Gizli sayı : " + number);
                System.out.println("Kullandığınız hak : " + (kullanilanHak + 1));
                isWin = true;
                break;
            }

            // Yanlış tahmin
            yanlisTahminler[kullanilanHak] = selected;
            kullanilanHak++;

            System.out.println("❌ Yanlış tahmin!");
            if (selected > number) {
                System.out.println("📉 " + selected + " sayısı gizli sayıdan BÜYÜK!");
            } else {
                System.out.println("📈 " + selected + " sayısı gizli sayıdan KÜÇÜK!");
            }
            System.out.println("Kalan hak : " + (hakSayisi - kullanilanHak));
        }

        // Oyun sonu
        if (!isWin) {
            System.out.println("=====================================");
            System.out.println("💀 Kaybettiniz! Gizli sayı : " + number);
            System.out.println("Tahminleriniz : " + Arrays.toString(
                    Arrays.copyOf(yanlisTahminler, kullanilanHak)
            ));
        }

        input.close();
    }
}