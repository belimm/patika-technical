package kosulluifade.sayilaribuyuktenkucuge;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("1. sayıyı giriniz: ");
        int a = input.nextInt();

        System.out.print("2. sayıyı giriniz: ");
        int b = input.nextInt();

        System.out.print("3. sayıyı giriniz: ");
        int c = input.nextInt();

        int temp;

        // a ile b'yi karşılaştır
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }

        // a ile c'yi karşılaştır
        if (a > c) {
            temp = a;
            a = c;
            c = temp;
        }

        // b ile c'yi karşılaştır
        if (b > c) {
            temp = b;
            b = c;
            c = temp;
        }

        System.out.println("\nKüçükten büyüğe: " + a + " - " + b + " - " + c);

        input.close();
    }
}