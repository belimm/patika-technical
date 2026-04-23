package diziler.sort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Dizinin boyutu n : ");
        int n = input.nextInt();

        int[] dizi = new int[n];

        System.out.println("Dizinin elemanlarını giriniz :");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ". Elemanı : ");
            dizi[i] = input.nextInt();
        }

        // Bubble Sort ile küçükten büyüğe sırala
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (dizi[j] > dizi[j + 1]) {
                    int temp    = dizi[j];
                    dizi[j]     = dizi[j + 1];
                    dizi[j + 1] = temp;
                }
            }
        }

        System.out.print("Sıralama : ");
        for (int sayi : dizi) {
            System.out.print(sayi + " ");
        }

        input.close();
    }
}