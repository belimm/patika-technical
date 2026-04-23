package donguler.yildizlarucgen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bir Sayı Giriniz: ");
        int n = input.nextInt();

        // Üst Üçgen (yukarı doğru genişler)
        for (int i = 0; i < n; i++) {
            // Boşluklar
            for (int j = 0; j < (n - i - 1); j++) {
                System.out.print(" ");
            }
            // Yıldızlar
            for (int k = 0; k < (2 * i + 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Alt Üçgen (aşağı doğru daralır)
        for (int i = n - 2; i >= 0; i--) {
            // Boşluklar
            for (int j = 0; j < (n - i - 1); j++) {
                System.out.print(" ");
            }
            // Yıldızlar
            for (int k = 0; k < (2 * i + 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        input.close();
    }
}
