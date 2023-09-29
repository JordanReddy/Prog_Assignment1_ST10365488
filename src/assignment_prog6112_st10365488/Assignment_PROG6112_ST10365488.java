package assignment_prog6112_st10365488;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Assignment_PROG6112_ST10365488 {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Student Management Application");
        System.out.println("Enter [1] to launch the menu or any other key to quit \n");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            while (true) {
                System.out.println("[1] Capture a new student");
                System.out.println("[2] Search for a student");
                System.out.println("[3] Delete a student");
                System.out.println("[4] View student report");
                System.out.println("[5] Exit application");
                System.out.println("Please select an option");
                
                int option = getIntInput(scanner);
                
                switch (option) {
                    case 1:
                        newStudentCapture(scanner, students);
                        break;
                    case 2:
                        studentSearch(scanner, students);
                        break;
                    case 3:
                        studentDelete(scanner, students);
                        break;
                    case 4:
                        studentReport(students);
                        break;
                    case 5:
                        System.out.println("Exiting the application.....");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice, please try again");
                }
            }
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, Please enter a valid number");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    private static void newStudentCapture(Scanner scanner, List<Student> students) {
        scanner.nextLine(); // Consume the newline
        System.out.println("Enter student name");
        String name = scanner.nextLine();
        
        int age;
        while (true) {
            System.out.println("Enter student age");
            age = getIntInput(scanner);
            
            if (age >= 16) {
                break;
            } else {
                System.out.println("Invalid age, age must be 16 years or older");
            }
        }
        
        students.add(new Student(name, age));
        System.out.println("Student details have been successfully captured");
    }

    private static void studentSearch(Scanner scanner, List<Student> students) {
        System.out.println("Enter student name to search");
        String searchName = scanner.next();
        boolean found = false;
        
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Student found");
                System.out.println(student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found");
        }
    }

    private static void studentDelete(Scanner scanner, List<Student> students) {
        System.out.println("Enter student name to delete: ");
        String deleteName = scanner.next();
        boolean deleted = false;
        
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(deleteName)) {
                students.remove(student);
                System.out.println("Student has been deleted");
                deleted = true;
                break;
            }
        }
        if (!deleted) {
            System.out.println("Student not found");
        }
    }

    private static void studentReport(List<Student> students) {
        System.out.println("Student Report");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
