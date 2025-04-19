import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentView {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n1. Add Student\n2. View Students\n3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    StudentController.addStudent(new Student(id, name, department, marks));
                } else if (choice == 2) {
                    List<Student> students = StudentController.getAllStudents();
                    students.forEach(s -> System.out.println(s.getStudentID() + " | " + s.getName()));
                } else {
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
