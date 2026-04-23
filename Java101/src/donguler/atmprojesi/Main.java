package donguler.atmprojesi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userName, password;
        Scanner input = new Scanner(System.in);
        int right   = 3;
        int balance = 1500;
        int select;

        while (right > 0) {
            System.out.print("Kullanıcı Adınız : ");
            userName = input.nextLine();
            System.out.print("Parolanız : ");
            password = input.nextLine();

            if (userName.equals("patika") && password.equals("dev123")) {
                System.out.println("Merhaba, Kodluyoruz Bankasına Hoşgeldiniz!");

                do {
                    System.out.println("\n1-Para Yatırma");
                    System.out.println("2-Para Çekme");
                    System.out.println("3-Bakiye Sorgula");
                    System.out.println("4-Çıkış Yap");
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");
                    select = input.nextInt();

                    switch (select) {
                        case 1:
                            System.out.print("Para miktarı : ");
                            int yatirilacak = input.nextInt();
                            if (yatirilacak <= 0) {
                                System.out.println("Geçersiz miktar!");
                            } else {
                                balance += yatirilacak;
                                System.out.println(yatirilacak + " TL yatırıldı.");
                                System.out.println("Güncel Bakiye : " + balance + " TL");
                            }
                            break;

                        case 2:
                            System.out.print("Para miktarı : ");
                            int cekilecek = input.nextInt();
                            if (cekilecek <= 0) {
                                System.out.println("Geçersiz miktar!");
                            } else if (cekilecek > balance) {
                                System.out.println("Bakiye yetersiz!");
                            } else {
                                balance -= cekilecek;
                                System.out.println(cekilecek + " TL çekildi.");
                                System.out.println("Güncel Bakiye : " + balance + " TL");
                            }
                            break;

                        case 3:
                            System.out.println("Bakiyeniz : " + balance + " TL");
                            break;

                        case 4:
                            System.out.println("Tekrar görüşmek üzere.");
                            break;

                        default:
                            System.out.println("Geçersiz işlem! Lütfen 1-4 arasında seçim yapınız.");
                    }

                } while (select != 4);
                break;

            } else {
                right--;
                System.out.println("Hatalı kullanıcı adı veya şifre.");
                if (right == 0) {
                    System.out.println("Hesabınız bloke olmuştur, lütfen banka ile iletişime geçiniz.");
                } else {
                    System.out.println("Kalan Hakkınız : " + right);
                }
            }
        }

        input.close();
    }
}