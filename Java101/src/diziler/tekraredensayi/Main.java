package diziler.tekraredensayi;

public class Main {
    public static void main(String[] args) {

        int[] numbers = {2, 3, 4, 6, 4, 8, 2, 10, 6, 8, 8, 5, 3, 2};

        System.out.println("Dizi : {2,3,4,6,4,8,2,10,6,8,8,5,3,2}");
        System.out.println("-----------------------------------");
        System.out.println("Tekrar Eden Çift Sayılar:");

        for (int i = 0; i < numbers.length; i++) {

            // Çift sayı kontrolü
            if (numbers[i] % 2 != 0) continue;

            // Tekrar kontrolü: daha önce görüldü mü?
            boolean tekrarEdiyor = false;
            boolean dahaOnceYazildi = false;

            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;

                // Aynı sayı başka bir indekste var mı?
                if (numbers[i] == numbers[j]) {
                    tekrarEdiyor = true;
                }
            }

            // Daha önce yazdırıldı mı kontrolü
            for (int k = 0; k < i; k++) {
                if (numbers[k] == numbers[i]) {
                    dahaOnceYazildi = true;
                    break;
                }
            }

            if (tekrarEdiyor && !dahaOnceYazildi) {
                // Kaç kez tekrar ettiğini say
                int adet = 0;
                for (int m = 0; m < numbers.length; m++) {
                    if (numbers[m] == numbers[i]) adet++;
                }
                System.out.println(numbers[i] + " → " + adet + " kez tekrar ediyor");
            }
        }
    }
}