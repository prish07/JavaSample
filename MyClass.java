package JavaSample;

import java.io.*;
import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.addStudent(new Student("Alice", 17, 3.8));
        manager.addStudent(new Student("Bob", 18, 3.6));
        manager.addStudent(new Student("Charlie", 16, 3.9));

        // Save students to a file
        saveStudentsToFile(manager, "students.txt");

        // Load students from a file
        StudentManager loadedManager = loadStudentsFromFile("students.txt");

        System.out.println("Loaded Students:");
        loadedManager.displayStudents();
    }

    public static void saveStudentsToFile(StudentManager manager, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : manager.getStudents()) {
                writer.println(student.getName() + "," + student.getAge() + "," + student.getGpa());
            }
        } catch (IOException e) {
            System.err.println("Error saving students to file: " + e.getMessage());
        }
    }

    public static StudentManager loadStudentsFromFile(String filename) {
        StudentManager manager = new StudentManager();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                double gpa = Double.parseDouble(data[2]);
                manager.addStudent(new Student(name, age, gpa));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error loading students from file: " + e.getMessage());
        }
        return manager;
    }
}
