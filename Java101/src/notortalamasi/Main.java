package notortalamasi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Physics"));
        courses.add(new Course("Chemistry"));
        courses.add(new Course("Turkish"));
        courses.add(new Course("History"));
        courses.add(new Course("Music"));

        Scanner input = new Scanner(System.in);
        double totalGrade = 0;
        for(Course c: courses) {
            System.out.println("Enter grade for "+ c.getName());
            double grade = input.nextDouble();
            c.setGrade(grade);
            totalGrade += grade;
        }

        double averageGrade = totalGrade / courses.size();

        System.out.println(averageGrade > 60 ? "Sınıfı Geçti"  : "Sınıfta Kaldı");
    }
}