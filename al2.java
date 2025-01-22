// Take the input from the user 
import java.util.ArrayList;
import java.util.Scanner;

public class al2 {
        public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);   
         ArrayList <Integer> l2 = new ArrayList<>();
         System.out.println("Enter 7 digits : ");
         for(int i = 0 ; i<7 ; i++){
            int num = sc.nextInt();
            l2.add(num);
         }
         System.out.println(l2);

         System.out.println("Enter the index where you want to add an element: ");
         int index = sc.nextInt();
         
         System.out.println("Enter the element to add: ");
         int element = sc.nextInt();
         
         l2.add(index, element);
         System.out.println(l2);
         
         System.out.println("Enter the index where you want to remove an element: ");
         int index_r = sc.nextInt();
         l2.remove(index_r);
         System.out.println(l2);
        }
}
