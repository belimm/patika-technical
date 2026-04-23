package vucutkitleindeks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Lütfen boyunuzu (metre cinsinde) giriniz : ");
        double boy = scan.nextDouble();

        System.out.print("Lütfen kilonuzu giriniz : ");
        double kilo = scan.nextDouble();

        double vucutKitleIndeksi = kilo / (boy * boy);

        System.out.println("Vücut Kitle İndeksiniz : " + vucutKitleIndeksi);

        scan.close();
    }
}
