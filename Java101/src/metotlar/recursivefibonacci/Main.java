package metotlar.recursivefibonacci;

import java.util.Scanner;

public class Main {

    // Recursive fibonacci metodu
    public static int fibonacci(int n) {
        if (n == 0) return 0;       // Base case 1
        if (n == 1) return 1;       // Base case 2
        return fibonacci(n - 1) + fibonacci(n - 2);  // Recursive case
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Fibonacci eleman sayısını giriniz: ");
        int n = input.nextInt();

        System.out.print(n + " Elemanlı Fibonacci Serisi : ");

        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        input.close();
    }
}