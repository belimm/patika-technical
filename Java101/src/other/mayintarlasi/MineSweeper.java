package other.mayintarlasi;

// MineSweeper.java
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    String[][] mineMap;    // Mayınların gerçek konumu
    String[][] playerMap;  // Oyuncuya gösterilen harita
    int rows;
    int cols;
    int mineCount;
    int openedCells;
    Scanner input;

    public MineSweeper(int rows, int cols) {
        this.rows      = rows;
        this.cols      = cols;
        this.mineCount = (rows * cols) / 4;
        this.openedCells = 0;
        this.input     = new Scanner(System.in);
        this.mineMap   = new String[rows][cols];
        this.playerMap = new String[rows][cols];
        initMaps();
        placeMines();
    }

    // Haritaları başlat
    void initMaps() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mineMap[i][j]   = "-";
                playerMap[i][j] = "-";
            }
        }
    }

    // Rastgele mayın yerleştir
    void placeMines() {
        Random rand  = new Random();
        int placed   = 0;

        while (placed < mineCount) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);

            if (!mineMap[r][c].equals("*")) {
                mineMap[r][c] = "*";
                placed++;
            }
        }
    }

    // Haritayı yazdır
    void printMap(String[][] map) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Komşu mayın sayısını hesapla
    int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < cols) {
                    if (mineMap[i][j].equals("*")) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // Koordinat daha önce seçildi mi?
    boolean isAlreadyOpened(int row, int col) {
        return !playerMap[row][col].equals("-");
    }

    // Oyunu başlat
    void start() {
        System.out.println("Mayınların Konumu");
        printMap(mineMap);
        System.out.println("===========================");
        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz !");
        printMap(playerMap);

        int totalSafe = (rows * cols) - mineCount;

        while (true) {
            // Satır girişi
            int row = -1;
            while (row < 0 || row >= rows) {
                System.out.print("Satır Giriniz : ");
                row = input.nextInt();
                if (row < 0 || row >= rows) {
                    System.out.println("⚠️  Geçersiz satır! 0-" + (rows - 1) + " arasında giriniz.");
                }
            }

            // Sütun girişi
            int col = -1;
            while (col < 0 || col >= cols) {
                System.out.print("Sütun Giriniz : ");
                col = input.nextInt();
                if (col < 0 || col >= cols) {
                    System.out.println("⚠️  Geçersiz sütun! 0-" + (cols - 1) + " arasında giriniz.");
                }
            }

            // Daha önce seçildi mi?
            if (isAlreadyOpened(row, col)) {
                System.out.println("⚠️  Bu koordinat daha önce seçildi, başka bir koordinat girin!");
                continue;
            }

            // Mayına bastı mı?
            if (mineMap[row][col].equals("*")) {
                playerMap[row][col] = "*";
                System.out.println("Game Over!!");
                System.out.println("===========================");
                printMap(mineMap);
                break;
            }

            // Güvenli hücre: komşu mayın sayısını yaz
            int adjacentMines = countAdjacentMines(row, col);
            playerMap[row][col] = String.valueOf(adjacentMines);
            openedCells++;

            System.out.println("===========================");
            printMap(playerMap);

            // Kazandı mı?
            if (openedCells == totalSafe) {
                System.out.println("Oyunu Kazandınız !");
                printMap(playerMap);
                System.out.println("===========================");
                break;
            }
        }
    }
}