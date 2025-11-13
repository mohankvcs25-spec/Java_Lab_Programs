import java.util.Scanner;

// Base Account class
class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    Scanner sc = new Scanner(System.in);

    // Constructor
    Account(String cname, int accno, String type, double bal) {
        customerName = cname;
        accountNumber = accno;
        accountType = type;
        balance = bal;
    }

    // Deposit method
    void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        balance += amt;
        System.out.println("Amount deposited successfully.");
        displayBalance();
    }

    // Display balance
    void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Withdrawal method (to be overridden in derived classes)
    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        if (amt > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amt;
            System.out.println("Withdrawal successful.");
        }
        displayBalance();
    }
}

// Derived class for Savings Account
class SavAcct extends Account {
    double interestRate = 5.0; // annual interest rate %

    SavAcct(String cname, int accno, double bal) {
        super(cname, accno, "Savings", bal);
    }

    // Compute and deposit compound interest
    void computeAndDepositInterest() {
        System.out.print("Enter number of years for interest calculation: ");
        int years = sc.nextInt();
        double interest = balance * Math.pow((1 + interestRate / 100), years) - balance;
        balance += interest;
        System.out.printf("Interest of ₹%.2f added to balance.\n", interest);
        displayBalance();
    }

    // Override withdrawal (no cheque book)
    @Override
    void withdraw() {
        System.out.println("No cheque facility available for savings account.");
        super.withdraw();
    }
}

// Derived class for Current Account
class CurAcct extends Account {
    final double minBalance = 1000.0;
    final double serviceCharge = 200.0;

    CurAcct(String cname, int accno, double bal) {
        super(cname, accno, "Current", bal);
    }

    // Check for minimum balance and apply penalty if needed
    void checkMinBalance() {
        if (balance < minBalance) {
            System.out.println("Balance below minimum! Service charge of ₹" + serviceCharge + " imposed.");
            balance -= serviceCharge;
        }
    }

    // Override withdrawal method
    @Override
    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        if (amt > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amt;
            System.out.println("Withdrawal successful.");
        }
        checkMinBalance();
        displayBalance();
    }

    void chequeBookFacility() {
        System.out.println("Cheque book facility available for current accounts.");
    }
}

// Main Bank class
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Welcome to the Bank System ===");
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        int accno = sc.nextInt();

        System.out.print("Enter account type (1 - Savings, 2 - Current): ");
        int choice = sc.nextInt();

        System.out.print("Enter initial balance: ");
        double bal = sc.nextDouble();

        if (choice == 1) {
            SavAcct sa = new SavAcct(name, accno, bal);
            int ch;
            do {
                System.out.println("\n--- Savings Account Menu ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Compute Interest");
                System.out.println("4. Display Balance");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                ch = sc.nextInt();

                switch (ch) {
                    case 1 -> sa.deposit();
                    case 2 -> sa.withdraw();
                    case 3 -> sa.computeAndDepositInterest();
                    case 4 -> sa.displayBalance();
                    case 5 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice!");
                }
            } while (ch != 5);
        } else if (choice == 2) {
            CurAcct ca = new CurAcct(name, accno, bal);
            int ch;
            do {
                System.out.println("\n--- Current Account Menu ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Minimum Balance");
                System.out.println("4. Display Balance");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                ch = sc.nextInt();

                switch (ch) {
                    case 1 -> ca.deposit();
                    case 2 -> ca.withdraw();
                    case 3 -> ca.checkMinBalance();
                    case 4 -> ca.displayBalance();
                    case 5 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice!");
                }
            } while (ch != 5);
        } else {
            System.out.println("Invalid account type!");
        }

        sc.close();
        System.out.println("\nThank you for banking with us!");
    }
}
