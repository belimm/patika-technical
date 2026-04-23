package siniflar.boks;

// Ring.java
public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1        = f1;
        this.f2        = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {
        if (!checkWeight()) {
            System.out.println("Sporcuların ağırlıkları uyuşmuyor.");
            return;
        }

        // ✅ %50 olasılıkla ilk vuruşu kimin yapacağını belirle
        Fighter first, second;
        if (Math.random() < 0.5) {
            first  = f1;
            second = f2;
        } else {
            first  = f2;
            second = f1;
        }

        System.out.println("🥊 İlk vuruşu yapacak sporcu: " + first.name);
        System.out.println("================================");

        while (f1.health > 0 && f2.health > 0) {
            System.out.println("======== YENİ ROUND ===========");

            // Birinci sporcu vurur
            second.health = first.hit(second);
            if (isWin()) break;

            // İkinci sporcu vurur
            first.health = second.hit(first);
            if (isWin()) break;

            printScore();
        }
    }

    public boolean checkWeight() {
        return (f1.weight >= minWeight && f1.weight <= maxWeight)
                && (f2.weight >= minWeight && f2.weight <= maxWeight);
    }

    public boolean isWin() {
        if (f1.health <= 0) {
            System.out.println("🏆 Maçı Kazanan : " + f2.name);
            return true;
        } else if (f2.health <= 0) {
            System.out.println("🏆 Maçı Kazanan : " + f1.name);
            return true;
        }
        return false;
    }

    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Kalan Can \t: " + f1.health);
        System.out.println(f2.name + " Kalan Can \t: " + f2.health);
    }
}