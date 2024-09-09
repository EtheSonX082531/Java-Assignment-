// BkashAccount.java

public class BkashAccount {
    // Attributes of the BkashAccount class
    private String accountHolderName;
    private String phoneNumber;
    private double balance;
    
    // Constructor to initialize the account
    public BkashAccount(String accountHolderName, String phoneNumber, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.phoneNumber = phoneNumber;
        this.balance = initialDeposit;
    }
    
    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance!");
        }
    }
    
    // Method to check the account balance
    public double checkBalance() {
        return balance;
    }
    
    // Method to display account information
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Current Balance: " + balance);
    }
    
    // Main method for demonstration
    public static void main(String[] args) {
        // Creating a Bkash account
        BkashAccount myAccount = new BkashAccount("John Doe", "017XXXXXXXX", 1000.00);
        
        // Displaying account information
        myAccount.displayAccountInfo();
        
        // Depositing money
        myAccount.deposit(500);
        
        // Checking balance
        System.out.println("Balance after deposit: " + myAccount.checkBalance());
        
        // Withdrawing money
        myAccount.withdraw(300);
        
        // Checking balance again
        System.out.println("Balance after withdrawal: " + myAccount.checkBalance());
        
        // Displaying account information again
        myAccount.displayAccountInfo();
    }
}
