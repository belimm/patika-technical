package donguler.girilensayilardanmin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Kaç tane sayı gireceksiniz: ");
        int n = input.nextInt();

        int enBuyuk, enKucuk, sayi;

        System.out.print("1. Sayıyı giriniz: ");
        sayi    = input.nextInt();
        enBuyuk = sayi;
        enKucuk = sayi;

        for (int i = 2; i <= n; i++) {
            System.out.print(i + ". Sayıyı giriniz: ");
            sayi = input.nextInt();

            if (sayi > enBuyuk) {
                enBuyuk = sayi;
            }
            if (sayi < enKucuk) {
                enKucuk = sayi;
            }
        }

        System.out.println("\nEn büyük sayı: " + enBuyuk);
        System.out.println("En küçük sayı: " + enKucuk);

        input.close();
    }
}