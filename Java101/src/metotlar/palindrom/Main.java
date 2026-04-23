package metotlar.palindrom;

import java.util.Scanner;

public class Main {

    // Sayıyı tersine çeviren metot
    public static int tersCevir(int sayi) {
        int ters = 0;
        while (sayi != 0) {
            int basamak = sayi % 10;
            ters        = ters * 10 + basamak;
            sayi       /= 10;
        }
        return ters;
    }

    // Palindrom kontrolü yapan metot
    public static boolean palindromMu(int sayi) {
        return sayi == tersCevir(sayi);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayı giriniz: ");
        int sayi = input.nextInt();

        if (palindromMu(sayi)) {
            System.out.println(sayi + " bir Palindrom sayıdır.");
        } else {
            System.out.println(sayi + " bir Palindrom sayı değildir.");
        }

        input.close();
    }
}