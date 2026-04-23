package donguler.fibonacci;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Fibonacci eleman sayısını giriniz: ");
        int n = input.nextInt();

        int onceki  = 0;
        int sonraki = 1;

        System.out.print(n + " Elemanlı Fibonacci Serisi : ");

        for (int i = 0; i < n; i++) {
            System.out.print(onceki + " ");

            int yeni = onceki + sonraki;
            onceki   = sonraki;
            sonraki  = yeni;
        }

        input.close();
    }
}