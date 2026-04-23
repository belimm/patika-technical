package siniflar.maashesaplayici;

// Employee.java
public class Employee {
    String name;
    double salary;
    int    workHours;
    int    hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name      = name;
        this.salary    = salary;
        this.workHours = workHours;
        this.hireYear  = hireYear;
    }

    // Vergi hesaplama
    public double tax() {
        if (this.salary < 1000) {
            return 0;
        }
        return this.salary * 0.03;
    }

    // Bonus hesaplama
    public double bonus() {
        if (this.workHours > 40) {
            return (this.workHours - 40) * 30;
        }
        return 0;
    }

    // Maaş artışı hesaplama
    public double raiseSalary() {
        int currentYear = 2021;
        int workYears   = currentYear - this.hireYear;

        if (workYears < 10) {
            return this.salary * 0.05;
        } else if (workYears < 20) {
            return this.salary * 0.10;
        } else {
            return this.salary * 0.15;
        }
    }

    // Bilgileri ekrana bastır
    public void toString2() {
        double tax        = tax();
        double bonus      = bonus();
        double raise      = raiseSalary();
        double netSalary  = (this.salary - tax) + bonus;   // Vergi düşülür, bonus eklenir
        double totalSalary = netSalary + raise;             // Zam eklenir

        System.out.println("==============================");
        System.out.println("Adı              : " + this.name);
        System.out.println("Maaşı            : " + this.salary);
        System.out.println("Çalışma Saati    : " + this.workHours);
        System.out.println("Başlangıç Yılı   : " + this.hireYear);
        System.out.println("------------------------------");
        System.out.println("Vergi            : " + tax);
        System.out.println("Bonus            : " + bonus);
        System.out.println("Maaş Artışı      : " + raise);
        System.out.println("------------------------------");
        System.out.println("Vergi ve Bonuslar ile Maaş : " + netSalary);
        System.out.println("Toplam Maaş      : " + totalSalary);
        System.out.println("==============================");
    }
}