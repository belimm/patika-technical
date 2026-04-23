package kosulluifade.sinifigecme;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] dersler = {"Matematik", "Fizik", "Türkçe", "Kimya", "Müzik"};
        double[] notlar = new double[5];
        int gecmeNotu = 55;
        double toplam = 0;
        int gecerliDersSayisi = 0;

        for (int i = 0; i < dersler.length; i++) {
            System.out.print(dersler[i] + " notunu giriniz: ");
            notlar[i] = input.nextDouble();

            if (notlar[i] >= 0 && notlar[i] <= 100) {
                toplam += notlar[i];
                gecerliDersSayisi++;
            } else {
                System.out.println("Geçersiz not! " + dersler[i] + " dersi ortalamaya katılmayacak.");
            }
        }

        if (gecerliDersSayisi > 0) {
            double ortalama = toplam / gecerliDersSayisi;
            System.out.println("\n--- SONUÇ ---");
            System.out.println("Geçerli ders sayısı : " + gecerliDersSayisi);
            System.out.printf("Ortalama            : %.2f%n", ortalama);

            if (ortalama >= gecmeNotu) {
                System.out.println("Durum               : GEÇTİ ✓");
            } else {
                System.out.println("Durum               : KALDI ✗");
            }
        } else {
            System.out.println("Geçerli not girilmedi, ortalama hesaplanamadı.");
        }

        input.close();
    }
}