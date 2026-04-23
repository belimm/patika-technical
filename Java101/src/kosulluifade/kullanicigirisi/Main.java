package kosulluifade.kullanicigirisi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String gercekSifre = "java123"; // Sistemdeki kayıtlı şifre

        System.out.print("Şifrenizi giriniz: ");
        String girilenSifre = input.nextLine();

        if (girilenSifre.equals(gercekSifre)) {
            System.out.println("Giriş başarılı!");
        } else {
            System.out.println("Şifre yanlış!");
            System.out.print("Şifrenizi sıfırlamak ister misiniz? (evet/hayır): ");
            String cevap = input.nextLine();

            if (cevap.equalsIgnoreCase("evet")) {
                System.out.print("Yeni şifrenizi giriniz: ");
                String yeniSifre = input.nextLine();

                if (yeniSifre.equals(gercekSifre)) {
                    System.out.println("Şifre oluşturulamadı, lütfen başka şifre giriniz.");
                } else {
                    gercekSifre = yeniSifre; // Şifreyi güncelle
                    System.out.println("Şifre oluşturuldu.");
                }
            } else {
                System.out.println("Şifre sıfırlama iptal edildi.");
            }
        }

        input.close();
    }
}
