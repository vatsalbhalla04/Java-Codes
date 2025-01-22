// Make a class name : GU : sno sname eng hindi implement using arraylist 
import java.util.ArrayList;
import java.util.Scanner;

class GU{
    private int sno ; 
    private String sname ; 
    private int eng; 
    private int hindi ; 

    public int getSno()
    {
        return sno;
    }
    public String getname(){
        return sname ; 
    }
    public int engMarks(){
        return eng;
    }    
    public int hindiMarks(){
        return hindi;
    }
    
    public void setData(){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Student Id:");
        sno = sc.nextInt();
        sc.nextLine(); 
        
        System.out.print("Enter the name of the Student :");
        sname = sc.nextLine();

        System.out.print("Enter the marks in english : ");
        eng = sc.nextInt();

        System.out.print("Enter the marks in hindi : ");
        hindi = sc.nextInt();
    }
    public void printData(){
        System.out.println("Student Id : " +sno + "| Student Name : " +sname + "| Marks In English : " +eng + "| Marks in Hindi :" + hindi);
    }

    public void updateDetails() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Updating details for student: " + sname);
        System.out.print("Enter the new name: ");
        sname = sc.nextLine();

        System.out.print("Enter new marks in English: ");
        eng = sc.nextInt();

        System.out.print("Enter new marks in Hindi: ");
        hindi = sc.nextInt();
    }
}

public class al3 {
    public static void main(String[] args) {

        // 1) Setting / Adding students to the Arraylist
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        ArrayList<GU> l3 = new ArrayList<>();

        System.out.print("Enter the number of students : ");
        int n = sc.nextInt(); // number of stundents to be added.

        for(int i = 0 ; i<n ; i++){
            GU student = new GU();
            student.setData();
            l3.add(student);
        }
        for(GU s1:l3)
        {
            s1.printData();
        }

        // 2) Ask the user for the roll number they want to search
        System.out.print("Enter the roll number to search for:");
        int rollNo = sc.nextInt();
        boolean found = false ; 
        for(GU s : l3){
            if(s.getSno() == rollNo){
                s.printData();
                found = true;
                break ; 
            }
        }
        if(!found) System.out.println("No Records Found");

        // 3) Now want to udpate the student details. 
        System.out.print("Enter the roll number to update the details: ");
        int details = sc.nextInt();
        boolean update = false;
        for (GU s : l3) {
            if (s.getSno() == details) {
                System.out.println("Now modify this record");
                s.setData();
                s.printData();  
                update = true;
                break;
            }
        }
        if (!update) {
            System.out.println("No Records Found to Update");
        }

        // 4) Placing a new student at the index of a specific position
        System.out.print("Enter the position where you want to place a new student: ");
        int pos = sc.nextInt();

        boolean isPlaced = false;
        if (pos >= 0 && pos <= l3.size()) {  // Check for valid index range
            GU student = new GU();
            student.setData();  // Set the data for the new student
            l3.add(pos, student);  // Insert the student at the specified position
            System.out.println("Data inserted successfully at position " + pos + ": " + student);
            isPlaced = true;
        } 
        if (!isPlaced) {
            System.out.println("Failed to insert the student.");
        }

        //  5) Deleting a student at a specific Roll No given by the user
        System.out.print("Enter the Roll Number of the student you want to delete: ");
        int rollNoToDelete = sc.nextInt();

        boolean isDeleted = false;
        for (int i = 0; i < l3.size(); i++) {
            if (l3.get(i).getSno() == rollNoToDelete) {
                GU removedStudent = l3.remove(i);  // Remove the student at the specified roll number
                System.out.println("Student with Roll Number " + rollNoToDelete + " deleted: " + removedStudent);
                isDeleted = true;
                break;
            }
        }
        if (!isDeleted) {
            System.out.println("No student found with Roll Number " + rollNoToDelete + ".");
        }

        // 6) Printing the final list of students in a table format
        System.out.println("\nFinal List of Students:");
        System.out.printf("%-10s%-20s%-15s%-15s\n", "Sno", "Name", "English Marks", "Hindi Marks");  // Table header
        for (GU student : l3) {
            System.out.printf("%-10d%-20s%-15d%-15d\n", student.getSno(), student.getname(), student.engMarks(), student.hindiMarks());
}
    }
}
