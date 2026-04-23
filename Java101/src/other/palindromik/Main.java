package other.palindromik;

import java.util.Scanner;

public class Main {

    // Yöntem 1: İki pointer ile kontrol
    static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // Yöntem 2: Tersini alıp karşılaştır
    static boolean isPalindrome2(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return str.equals(reverse);
    }

    // Yöntem 3: StringBuilder ile
    static boolean isPalindrome3(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        return str.equals(reverse);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bir kelime giriniz: ");
        String kelime = input.nextLine().toLowerCase().trim();

        System.out.println("=====================================");
        System.out.println("Girilen Kelime : " + kelime);
        System.out.println("-------------------------------------");
        System.out.println("Yöntem 1 (İki Pointer)   : " + isPalindrome(kelime));
        System.out.println("Yöntem 2 (Ters String)   : " + isPalindrome2(kelime));
        System.out.println("Yöntem 3 (StringBuilder) : " + isPalindrome3(kelime));
        System.out.println("-------------------------------------");

        if (isPalindrome(kelime)) {
            System.out.println("✅ \"" + kelime + "\" palindromik bir kelimedir!");
        } else {
            System.out.println("❌ \"" + kelime + "\" palindromik bir kelime değildir!");
        }

        input.close();
    }
}