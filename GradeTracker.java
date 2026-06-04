import java.util.*;
import java.io.*;

public class GradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            students.add(new Student(name, marks));
        }

        int total = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (Student s : students) {
            int marks = s.getMarks();

            total += marks;

            if (marks > highest) {
                highest = marks;
            }

            if (marks < lowest) {
                lowest = marks;
            }
        }

        double average = (double) total / students.size();

        System.out.println("\n===== STUDENT REPORT =====");

        for (Student s : students) {
            System.out.println(s.getName() + " : " + s.getMarks());
        }

        System.out.println("\nAverage Marks : " + average);
        System.out.println("Highest Marks : " + highest);
        System.out.println("Lowest Marks  : " + lowest);

        saveReport(students, average, highest, lowest);

        sc.close();
    }

    public static void saveReport(ArrayList<Student> students,
                                  double average,
                                  int highest,
                                  int lowest) {

        try {
            FileWriter writer = new FileWriter("student_report.txt");

            writer.write("===== STUDENT REPORT =====\n\n");

            for (Student s : students) {
                writer.write(s.getName() + " : " + s.getMarks() + "\n");
            }

            writer.write("\nAverage Marks : " + average);
            writer.write("\nHighest Marks : " + highest);
            writer.write("\nLowest Marks  : " + lowest);

            writer.close();

            System.out.println("\nReport saved to student_report.txt");

        } catch (IOException e) {
            System.out.println("Error saving report.");
        }
    }
}
