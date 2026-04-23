package other.mayintarlasi;

// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int rows = 0, cols = 0;

        // Minimum 2x2 kontrolü
        while (rows < 2) {
            System.out.print("Satır sayısını giriniz (min 2): ");
            rows = input.nextInt();
            if (rows < 2) System.out.println("⚠️  Minimum 2 satır girilmelidir!");
        }

        while (cols < 2) {
            System.out.print("Sütun sayısını giriniz (min 2): ");
            cols = input.nextInt();
            if (cols < 2) System.out.println("⚠️  Minimum 2 sütun girilmelidir!");
        }

        MineSweeper game = new MineSweeper(rows, cols);
        game.start();
    }
}