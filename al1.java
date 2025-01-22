import java.util.ArrayList;

public class al1 {
    public static void main(String[] args) {
        
        // Create an ArrayList of Integers
        ArrayList<Integer> l1 = new ArrayList<>();

         // 1)  Adding elements
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        System.out.println(l1);
        
        // 2) Adding element at a specific index 
        l1.add(1,10);
        System.out.println(l1);

        // 3) Removing an element from the ArrayList
        l1.remove(3);
        System.out.println(l1);

        // 4) Remove an element by value  
        l1.remove(Integer.valueOf(10));
        System.out.println(l1);

        // 5) Getting an element by value 
        int val = l1.get(2); 
        System.out.println(val);

        // 6) Setting an element at a speciifc index 
        l1.set(2,99);
        System.out.println(l1);

        // 7) Checking that if the list contains a value 
        boolean contains = l1.contains(3);
        System.out.println(contains);
        
        // 8) checking the size of the arraylist 
        int size = l1.size();
        System.out.println(size);
        
        // 9) Iterating through the arraylist using for loop 
        for(int i = 0 ; i<l1.size(); i++){
            System.out.println(l1.get(i));
        }
        
        // 10) Iterating through the arraylist using foreach 
        for(int i :l1) System.out.println(l1.get(i));

        // 11) Clearing all the elements from the Arraylist 
        l1.clear();
        System.out.println(l1);

        // 12) Checking if the Arraylist is empty
        boolean isEmpty = l1.isEmpty();
        System.out.println(isEmpty);
    }

}
