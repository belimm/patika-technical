package diziler.ortalama;
public class Main {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};
        int   n       = numbers.length;

        // Harmonik seri: 1/x1 + 1/x2 + 1/x3 ...
        double harmonikSeri = 0;

        for (int i = 0; i < n; i++) {
            harmonikSeri += 1.0 / numbers[i];
        }

        // Harmonik ortalama: n / harmonik seri
        double harmonikOrtalama = n / harmonikSeri;

        System.out.println("Dizi          : {1, 2, 3, 4, 5}");
        System.out.println("Eleman Sayısı : " + n);
        System.out.printf("Harmonik Seri : %.4f%n", harmonikSeri);
        System.out.printf("Harmonik Ortalama : %.4f%n", harmonikOrtalama);
    }
}