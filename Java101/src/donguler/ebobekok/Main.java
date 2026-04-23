package donguler.ebobekok;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Birinci sayıyı giriniz: ");
        int n1 = input.nextInt();

        System.out.print("İkinci sayıyı giriniz: ");
        int n2 = input.nextInt();

        // EBOB - While döngüsü ile (Öklid Algoritması)
        int buyuk  = n1;
        int kucuk  = n2;

        while (kucuk != 0) {
            int kalan = buyuk % kucuk;
            buyuk     = kucuk;
            kucuk     = kalan;
        }

        int ebob = buyuk;

        // EKOK formülü
        int ekok = (n1 * n2) / ebob;

        System.out.println("\n--- SONUÇ ---");
        System.out.println("EBOB(" + n1 + ", " + n2 + ") = " + ebob);
        System.out.println("EKOK(" + n1 + ", " + n2 + ") = " + ekok);

        input.close();
    }
}