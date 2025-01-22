import java.util.ArrayList;
import java.util.Scanner;

class GU_Students {
    private int sno;
    private String sname;
    private int eng;
    private int hindi;

    // Getters and Setters
    public int getSno() {
        return sno;
    }

    public String getName() {
        return sname;
    }

    public int getEngMarks() {
        return eng;
    }

    public int getHindiMarks() {
        return hindi;
    }

    public void setData(Scanner sc) {
        System.out.print("Enter the Student Id: ");
        sno = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        System.out.print("Enter the name of the Student: ");
        sname = sc.nextLine();

        System.out.print("Enter the marks in English: ");
        eng = sc.nextInt();

        System.out.print("Enter the marks in Hindi: ");
        hindi = sc.nextInt();
        sc.nextLine(); // Consume the newline character
    }

    public void printData() {
        System.out.println("Student Id: " + sno + " | Student Name: " + sname + " | Marks In English: " + eng + " | Marks In Hindi: " + hindi);
    }

    public void updateDetails(Scanner sc) {
        System.out.println("Updating details for student: " + sname);
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter the new name: ");
        sname = sc.nextLine();

        System.out.print("Enter new marks in English: ");
        eng = sc.nextInt();

        System.out.print("Enter new marks in Hindi: ");
        hindi = sc.nextInt();
        sc.nextLine(); // Consume the newline character
    }

    // Method to print final data in tabular format
    public static void printFinalData(ArrayList<GU_Students> students) {
        System.out.println("\nFinal List of Students:");
        System.out.printf("%-10s%-20s%-15s%-15s\n", "Sno", "Name", "English Marks", "Hindi Marks");
        System.out.println("-------------------------------------------------------------");  // Separator line

        for (GU_Students student : students) {
            System.out.printf("%-10d%-20s%-15d%-15d\n", student.getSno(), student.getName(), student.getEngMarks(), student.getHindiMarks());
        }
    }
}
public class al4{

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<GU_Students> students = new ArrayList<>();
            int choice;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Add Student");
                System.out.println("2. Print All Students");
                System.out.println("3. Search Student by Roll Number");
                System.out.println("4. Update Student Details");
                System.out.println("5. Delete Student by Roll Number");
                System.out.println("6. Insert Student at Position");
                System.out.println("7. Print Final List of Students");
                System.out.println("8. Exit");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        GU_Students student = new GU_Students();
                        student.setData(sc); // Pass the scanner here
                        students.add(student);
                    }
                    case 2 -> {
                        for (GU_Students s : students) {
                            s.printData();
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter the roll number to search: ");
                        int rollNoToSearch = sc.nextInt();
                        boolean found = false;
                        for (GU_Students s : students) {
                            if (s.getSno() == rollNoToSearch) {
                                s.printData();
                                found = true;
                                break;
                            }
                        }
                        if (!found) System.out.println("No Records Found.");
                    }
                    case 4 -> {
                        System.out.print("Enter the roll number to update: ");
                        int rollNoToUpdate = sc.nextInt();
                        boolean updated = false;
                        for (GU_Students s : students) {
                            if (s.getSno() == rollNoToUpdate) {
                                s.updateDetails(sc); // Pass the scanner here
                                s.printData();
                                updated = true;
                                break;
                            }
                        }
                        if (!updated) {
                            System.out.println("No Records Found to Update.");
                        }
                    }
                    case 5 -> {
                        System.out.print("Enter the roll number to delete: ");
                        int rollNoToDelete = sc.nextInt();
                        boolean isDeleted = false;
                        for (int i = 0; i < students.size(); i++) {
                            if (students.get(i).getSno() == rollNoToDelete) {
                                students.remove(i);
                                System.out.println("Student with Roll Number " + rollNoToDelete + " deleted.");
                                isDeleted = true;
                                break;
                            }
                        }
                        if (!isDeleted) {
                            System.out.println("No student found with Roll Number " + rollNoToDelete + ".");
                        }
                    }
                    case 6 -> {
                        System.out.print("Enter the position to insert the student: ");
                        int pos = sc.nextInt();
                        if (pos >= 0 && pos <= students.size()) {
                            GU_Students newStudent = new GU_Students();
                            newStudent.setData(sc); // Pass the scanner here
                            students.add(pos, newStudent);
                            System.out.println("Data inserted successfully at position " + pos + ".");
                        } else {
                            System.out.println("Invalid position.");
                        }
                    }
                    case 7 -> GU_Students.printFinalData(students); // Call the method to print final data
                    case 8 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 8);
        }
    }
}
