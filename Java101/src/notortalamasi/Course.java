package notortalamasi;

public class Course {
    public String name;
    public double grade;

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, Double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
