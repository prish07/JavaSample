package JavaSample;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String name) {
        students.removeIf(student -> student.getName().equals(name));
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    // Getter method for students
    public List<Student> getStudents() {
        return students;
    }
    
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.addStudent(new Student("Alice", 17, 3.8));
        manager.addStudent(new Student("Bob", 18, 3.6));
        manager.addStudent(new Student("Charlie", 16, 3.9));

        System.out.println("All Students:");
        manager.displayStudents();

        manager.removeStudent("Bob");

        System.out.println("\nAfter Removing Bob:");
        manager.displayStudents();
    }
}
