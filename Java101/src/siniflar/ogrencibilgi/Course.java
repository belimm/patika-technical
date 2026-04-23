package siniflar.ogrencibilgi;

// Course.java
public class Course {
    Teacher courseTeacher;
    String  name;
    String  code;
    String  prefix;
    int     examNote;    // Sınav notu
    int     oralNote;    // Sözlü notu
    double  oralEffect;  // Sözlü notunun ortalamaya etkisi (0.0 - 1.0)

    public Course(String name, String code, String prefix, double oralEffect) {
        this.name       = name;
        this.code       = code;
        this.prefix     = prefix;
        this.oralEffect = oralEffect;  // Örnek: 0.20 → %20 sözlü
        this.examNote   = 0;
        this.oralNote   = 0;
    }

    // Ağırlıklı ortalama: (sözlü * sözlüEtkisi) + (sınav * sınavEtkisi)
    public double calcWeightedNote() {
        double examEffect = 1.0 - oralEffect;
        return (oralNote * oralEffect) + (examNote * examEffect);
    }

    public void addTeacher(Teacher t) {
        if (this.prefix.equals(t.branch)) {
            this.courseTeacher = t;
            System.out.println("İşlem başarılı");
        } else {
            System.out.println(t.name + " Akademisyeni bu dersi veremez.");
        }
    }

    public void printTeacher() {
        if (courseTeacher != null) {
            System.out.println(this.name + " dersinin Akademisyeni : " + courseTeacher.name);
        } else {
            System.out.println(this.name + " dersine Akademisyen atanmamıştır.");
        }
    }
}