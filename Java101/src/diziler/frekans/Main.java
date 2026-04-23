package diziler.frekans;

public class Main {
    public static void main(String[] args) {

        int[] dizi    = {10, 20, 20, 10, 10, 20, 5, 20};
        boolean[] yazildi = new boolean[dizi.length];

        System.out.println("Dizi : [10, 20, 20, 10, 10, 20, 5, 20]");
        System.out.println("Tekrar Sayıları");

        for (int i = 0; i < dizi.length; i++) {

            // Daha önce yazıldıysa atla
            if (yazildi[i]) continue;

            int adet = 1;

            for (int j = i + 1; j < dizi.length; j++) {
                if (dizi[i] == dizi[j]) {
                    adet++;
                    yazildi[j] = true;  // Tekrar sayılmasın
                }
            }

            System.out.println(dizi[i] + " sayısı " + adet + " kere tekrar edildi.");
        }
    }
}
