package donguler.faktoriyel;

import java.util.Scanner;

public class Main {

    // Faktöriyel hesaplayan metot
    public static long faktoriyel(int sayi) {
        long sonuc = 1;
        for (int i = 2; i <= sayi; i++) {
            sonuc *= i;
        }
        return sonuc;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("n değerini giriniz: ");
        int n = input.nextInt();

        System.out.print("r değerini giriniz: ");
        int r = input.nextInt();

        // Geçerlilik kontrolü
        if (n < 0 || r < 0) {
            System.out.println("Hatalı Veri Girdiniz! Negatif sayı girilemez.");
        } else if (r > n) {
            System.out.println("Hatalı Veri Girdiniz! r, n'den büyük olamaz.");
        } else {
            long nFakt    = faktoriyel(n);
            long rFakt    = faktoriyel(r);
            long nrFakt   = faktoriyel(n - r);

            long kombinasyon = nFakt / (rFakt * nrFakt);

            System.out.println("\n--- HESAPLAMA ---");
            System.out.println("n!        = " + nFakt);
            System.out.println("r!        = " + rFakt);
            System.out.println("(n-r)!    = " + nrFakt);
            System.out.println("\nC(" + n + "," + r + ") = " + kombinasyon);
        }

        input.close();
    }
}