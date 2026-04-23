package donguler.harmoniksayi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("N değerini giriniz: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Hatalı Veri Girdiniz! Pozitif sayı giriniz.");
        } else {
            double toplam = 0;

            System.out.println("\n--- Harmonik Seri ---");

            for (int i = 1; i <= n; i++) {
                toplam += 1.0 / i;
                System.out.print("1/" + i);
                if (i < n) System.out.print(" + ");
            }

            System.out.printf("%n%nH(%d) = %.4f%n", n, toplam);
        }

        input.close();
    }
}