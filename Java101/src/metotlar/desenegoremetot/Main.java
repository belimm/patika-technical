package metotlar.desenegoremetot;

import java.util.Scanner;

public class Main {

    // Recursive metot
    public static void hesapla(int sayi) {

        System.out.print(sayi + " ");

        if (sayi <= 0) {
            return;  // Base case: 0 veya negatife ulaştı, geri dön
        }

        hesapla(sayi - 5);           // Recursive: 5 çıkar

        System.out.print(sayi + " "); // Geri dönüşte 5 ekle
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("N Sayısı : ");
        int n = input.nextInt();

        System.out.print("Çıktısı : ");
        hesapla(n);

        input.close();
    }
}