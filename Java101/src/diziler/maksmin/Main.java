package diziler.maksmin;

public class Main {
    public static void main(String[] args) {

        int[] list  = {15, 12, 788, 1, -1, -778, 2, 0};
        int   sayi  = 5;

        Integer kucukEnYakin = null;  // sayıdan küçük en yakın
        Integer buyukEnYakin = null;  // sayıdan büyük en yakın

        for (int i : list) {

            // Sayıdan küçük en yakın: i < sayi ve mümkün olan en büyüğü
            if (i < sayi) {
                if (kucukEnYakin == null || i > kucukEnYakin) {
                    kucukEnYakin = i;
                }
            }

            // Sayıdan büyük en yakın: i > sayi ve mümkün olan en küçüğü
            if (i > sayi) {
                if (buyukEnYakin == null || i < buyukEnYakin) {
                    buyukEnYakin = i;
                }
            }
        }

        System.out.println("Dizi         : {15, 12, 788, 1, -1, -778, 2, 0}");
        System.out.println("Girilen Sayı : " + sayi);
        System.out.println("-----------------------------------");

        if (kucukEnYakin != null) {
            System.out.println("Girilen sayıdan küçük en yakın sayı : " + kucukEnYakin);
        } else {
            System.out.println("Girilen sayıdan küçük eleman bulunamadı.");
        }

        if (buyukEnYakin != null) {
            System.out.println("Girilen sayıdan büyük en yakın sayı : " + buyukEnYakin);
        } else {
            System.out.println("Girilen sayıdan büyük eleman bulunamadı.");
        }
    }
}