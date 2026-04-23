package siniflar.ogrencibilgi;

// Main.java
public class Main {
    public static void main(String[] args) {

        // Dersler: oralEffect → sözlünün ortalamaya etkisi
        Course mat   = new Course("Matematik", "MAT101", "MAT", 0.20); // %20 sözlü
        Course fizik = new Course("Fizik",     "FZK101", "FZK", 0.30); // %30 sözlü
        Course kimya = new Course("Kimya",     "KMY101", "KMY", 0.25); // %25 sözlü

        Teacher t1 = new Teacher("Mahmut Hoca", "90550000000", "MAT");
        Teacher t2 = new Teacher("Fatma Ayşe",  "90550000001", "FZK");
        Teacher t3 = new Teacher("Ali Veli",    "90550000002", "KMY");

        mat.addTeacher(t1);
        fizik.addTeacher(t2);
        kimya.addTeacher(t3);

        // addBulkExamNote(matSınav, matSözlü, fizikSınav, fizikSözlü, kimyaSınav, kimyaSözlü)
        Student s1 = new Student("İnek Şaban",   4, "140144015", mat, fizik, kimya);
        s1.addBulkExamNote(60, 90, 55, 70, 40, 80);
        s1.isPass();

        Student s2 = new Student("Güdük Necmi",  4, "2211133",   mat, fizik, kimya);
        s2.addBulkExamNote(100, 85, 50, 60, 40, 55);
        s2.isPass();

        Student s3 = new Student("Hayta İsmail", 4, "221121312", mat, fizik, kimya);
        s3.addBulkExamNote(30, 50, 20, 40, 35, 45);
        s3.isPass();
    }
}