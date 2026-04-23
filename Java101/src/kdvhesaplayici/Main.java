package kdvhesaplayici;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double amount, amountTotal, kdvPercentage = 0.18;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount without KDV:");
        amount = input.nextDouble();

        if(amount < 0 ) {
            System.out.println("Please enter a valid amount!");
            return;
        }
        else if(amount > 1000) {
            kdvPercentage = 0.08;
        }

        double kdvAmount = amount * kdvPercentage;
        amountTotal = kdvAmount + amount;

        System.out.println("KDV'siz tutar:"+amount);
        System.out.println("KDV'li tutar:"+amountTotal);
        System.out.println("KDV tutarı:"+kdvAmount);




    }
}