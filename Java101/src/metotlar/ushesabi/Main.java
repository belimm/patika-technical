package metotlar.ushesabi;

import java.util.Scanner;

public class Main {

    // Recursive üs alma metodu
    public static long power(int taban, int us) {
        if (us == 0) return 1;                    // Base case: her sayının 0. kuvveti 1'dir
        return taban * power(taban, us - 1);       // Recursive case
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Taban değeri giriniz: ");
        int taban = input.nextInt();

        System.out.print("Üs değerini giriniz: ");
        int us = input.nextInt();

        System.out.println("Sonuç : " + power(taban, us));

        input.close();
    }
}