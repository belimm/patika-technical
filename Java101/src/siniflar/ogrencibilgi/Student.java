package siniflar.ogrencibilgi;

// Student.java
public class Student {
    String  name;
    String  stuNo;
    int     classes;
    Course  mat;
    Course  fizik;
    Course  kimya;
    double  average;
    boolean isPass;

    Student(String name, int classes, String stuNo,
            Course mat, Course fizik, Course kimya) {
        this.name    = name;
        this.classes = classes;
        this.stuNo   = stuNo;
        this.mat     = mat;
        this.fizik   = fizik;
        this.kimya   = kimya;
        this.isPass  = false;
        calcAverage();
    }

    // Sınav ve sözlü notlarını birlikte gir
    public void addBulkExamNote(int matExam, int matOral,
                                int fizikExam, int fizikOral,
                                int kimyaExam, int kimyaOral) {
        if (matExam   >= 0 && matExam   <= 100) this.mat.examNote   = matExam;
        if (matOral   >= 0 && matOral   <= 100) this.mat.oralNote   = matOral;

        if (fizikExam >= 0 && fizikExam <= 100) this.fizik.examNote = fizikExam;
        if (fizikOral >= 0 && fizikOral <= 100) this.fizik.oralNote = fizikOral;

        if (kimyaExam >= 0 && kimyaExam <= 100) this.kimya.examNote = kimyaExam;
        if (kimyaOral >= 0 && kimyaOral <= 100) this.kimya.oralNote = kimyaOral;
    }

    public void calcAverage() {
        double matWeighted   = this.mat.calcWeightedNote();
        double fizikWeighted = this.fizik.calcWeightedNote();
        double kimyaWeighted = this.kimya.calcWeightedNote();
        this.average = (matWeighted + fizikWeighted + kimyaWeighted) / 3.0;
    }

    public boolean isCheckPass() {
        calcAverage();
        return this.average > 55;
    }

    public void isPass() {
        if (this.mat.examNote == 0 || this.fizik.examNote == 0 || this.kimya.examNote == 0) {
            System.out.println("Notlar tam olarak girilmemiş!");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.printf("Genel Ortalama : %.2f%n", this.average);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti ✓");
            } else {
                System.out.println("Sınıfta Kaldı ✗");
            }
        }
    }

    public void printNote() {
        System.out.println("=================================");
        System.out.println("Öğrenci     : " + this.name);
        System.out.println("Öğrenci No  : " + this.stuNo);
        System.out.println("---------------------------------");

        System.out.printf("Matematik  → Sınav: %d | Sözlü: %d | Ağırlıklı: %.2f%n",
                mat.examNote, mat.oralNote, mat.calcWeightedNote());

        System.out.printf("Fizik      → Sınav: %d | Sözlü: %d | Ağırlıklı: %.2f%n",
                fizik.examNote, fizik.oralNote, fizik.calcWeightedNote());

        System.out.printf("Kimya      → Sınav: %d | Sözlü: %d | Ağırlıklı: %.2f%n",
                kimya.examNote, kimya.oralNote, kimya.calcWeightedNote());

        System.out.println("---------------------------------");
    }
}