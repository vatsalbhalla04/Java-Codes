import java.util.Scanner;

class Bank_Function {
    private String cname;
    private long acc_num;
    private int acc_bal;

    // Method to handle all account functions
    /**
     * 
     */
    public void Account_Functions() {
        try (Scanner sc = new Scanner(System.in)) {
            openacc(sc);
            printacc();
            deposit(sc);
            withdraw(sc);
        }
        printacc();
    }

    // Method to open an account
    public void openacc(Scanner sc) {
        System.out.print("Enter the name of customer: ");
        cname = sc.nextLine();
        System.out.print("Enter the account number: ");
        acc_num = sc.nextLong();
        System.out.print("Enter the account balance: ");
        acc_bal = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.println("Account created successfully!\n");
    }

    // Method to print account details in one line with pipes
    public void printacc() {
        System.out.println("\nAccount Details: Customer Name: " + cname + " | Account Number: " + acc_num + " | Account Balance: " + acc_bal);
    }

    // Method to deposit money
    public void deposit(Scanner sc) {
        System.out.print("\nEnter the amount to deposit: ");
        int deposit_amt = sc.nextInt();
        if (deposit_amt > 0) {
            acc_bal = acc_bal + deposit_amt;
            System.out.println("Deposit successful! New balance: " + acc_bal);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(Scanner sc) {
        System.out.print("\nEnter the amount to withdraw: ");
        int withdraw_amt = sc.nextInt();
        if (withdraw_amt > 0 && withdraw_amt <= acc_bal) {
            acc_bal = acc_bal - withdraw_amt;
            System.out.println("Withdrawal successful! New balance: " + acc_bal);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

public class al5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create Scanner for menu selection
        
        // Create an object of Bank_Function class
        Bank_Function bank = new Bank_Function();
        
        // Display menu for options
        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Open Account");
            System.out.println("2. Print Account Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            switch (choice) {
                case 1 -> bank.openacc(sc);
                case 2 -> bank.printacc();
                case 3 -> bank.deposit(sc);
                case 4 -> bank.withdraw(sc);
                case 5 -> {
                    System.out.println("Exited Succesfully");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
