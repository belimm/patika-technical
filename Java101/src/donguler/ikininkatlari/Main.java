package donguler.ikininkatlari;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayı giriniz: ");
        int sayi = input.nextInt();

        // 4'ün kuvvetleri
        System.out.println("\n--- 4'ün Kuvvetleri ---");
        long kuvvet4 = 1;
        int  us4     = 0;
        while (kuvvet4 <= sayi) {
            System.out.println("4^" + us4 + " = " + kuvvet4);
            us4++;
            kuvvet4 *= 4;
        }

        // 5'in kuvvetleri
        System.out.println("\n--- 5'in Kuvvetleri ---");
        long kuvvet5 = 1;
        int  us5     = 0;
        while (kuvvet5 <= sayi) {
            System.out.println("5^" + us5 + " = " + kuvvet5);
            us5++;
            kuvvet5 *= 5;
        }

        input.close();
    }
}