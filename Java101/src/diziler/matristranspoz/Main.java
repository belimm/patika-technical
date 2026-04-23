package diziler.matristranspoz;

public class Main {
    public static void main(String[] args) {

        int[][] matris = {
                {2, 3, 4},
                {5, 6, 4}
        };

        int satirSayisi = matris.length;       // 2
        int sutunSayisi = matris[0].length;    // 3

        // Transpoze matris: nxk → kxn
        int[][] transpoze = new int[sutunSayisi][satirSayisi];

        // Transpoze alma
        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                transpoze[j][i] = matris[i][j];
            }
        }

        // Orijinal matrisi yazdır
        System.out.println("Matris : ");
        for (int[] satir : matris) {
            for (int eleman : satir) {
                System.out.printf("%-5d", eleman);
            }
            System.out.println();
        }

        // Transpoze matrisi yazdır
        System.out.println("Transpoze : ");
        for (int[] satir : transpoze) {
            for (int eleman : satir) {
                System.out.printf("%-5d", eleman);
            }
            System.out.println();
        }
    }
}