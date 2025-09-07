import java.util.Scanner;

class Student {
    private String name;
    private String studentId;
    private double[] grades;

    // Constructor
    public Student(String name, String studentId, double[] grades) {
        this.name = name;
        this.studentId = studentId;
        this.grades = grades;
    }

    // Calculate average
    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    // Display grades
    public void displayGrades() {
        System.out.print("Grades: ");
        for (double grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }

    // Pass or Fail (pass if average >= 40)
    public boolean hasPassed() {
        return calculateAverage() >= 40;
    }

    // Display student info
    public void displayInfo() {
        System.out.println("\nStudent Name: " + name);
        System.out.println("Student ID: " + studentId);
        displayGrades();
        System.out.println("Average Grade: " + calculateAverage());
        System.out.println("Status: " + (hasPassed() ? "Passed" : "Failed"));
    }
}

// Main class
public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Student[] students = new Student[n];
        double totalClassAverage = 0;

        // Input student details
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter student ID: ");
            String id = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();

            double[] grades = new double[subjects];
            System.out.println("Enter grades: ");
            for (int j = 0; j < subjects; j++) {
                grades[j] = sc.nextDouble();
            }
            sc.nextLine(); // consume newline

            students[i] = new Student(name, id, grades);
            totalClassAverage += students[i].calculateAverage();
        }

        // Display student info
        System.out.println("\n=== Student Details ===");
        for (Student s : students) {
            s.displayInfo();
        }

        // Class average
        double classAverage = totalClassAverage / n;
        System.out.println("\nClass Average Grade: " + classAverage);

        sc.close();
    }
}
