package metotlar.asalsayi;

import java.util.Scanner;

public class Main {

    // Recursive asal kontrol metodu
    public static boolean asalMi(int sayi, int bolen) {

        // Base case 1: bolen sayının kareköküne ulaştıysa asal
        if (bolen > Math.sqrt(sayi)) return true;

        // Base case 2: bölündüyse asal değil
        if (sayi % bolen == 0) return false;

        // Recursive case: bir sonraki bölenle dene
        return asalMi(sayi, bolen + 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Sayı Giriniz : ");
        int sayi = input.nextInt();

        // 0 ve 1 asal sayı değildir
        if (sayi < 2) {
            System.out.println(sayi + " sayısı ASAL değildir !");
        } else if (asalMi(sayi, 2)) {
            System.out.println(sayi + " sayısı ASALDIR !");
        } else {
            System.out.println(sayi + " sayısı ASAL değildir !");
        }

        input.close();
    }
}
