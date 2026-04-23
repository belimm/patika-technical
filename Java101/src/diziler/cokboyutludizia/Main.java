package diziler.cokboyutludizia;

public class Main {
    public static void main(String[] args) {

        String[][] letter = new String[7][4];

        for (int i = 0; i < letter.length; i++) {
            for (int j = 0; j < letter[i].length; j++) {

                // Üst, orta ve alt yatay çizgiler
                if (i == 0 || i == 3 || i == 6) {
                    letter[i][j] = " * ";
                }
                // Sol dikey çizgi
                else if (j == 0) {
                    letter[i][j] = " * ";
                }
                // Sağ dikey çizgi (sadece üst ve alt yarıda)
                else if (j == 3 && (i < 3 || i > 3)) {
                    letter[i][j] = " * ";
                }
                // Boşluk
                else {
                    letter[i][j] = "   ";
                }
            }
        }

        for (String[] row : letter) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}