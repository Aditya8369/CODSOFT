/******************************************************************************
Problem statement:- ATM interface
1.Create a class to represent the ATM machine.
2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.
3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().
4. Create a class to represent the user's bank account, which stores the account balance.
5. Connect the ATM class with the user's bank account class to access and modify the account
balance.
6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions.

*******************************************************************************/


import java.util.Scanner;

class BankAccount{
    private double balance;
    
    public BankAccount(double initialBalance){
        balance=initialBalance;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public void deposit(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("Money deposited:"+amount);
        } 
        else{
            System.out.println("Invalid amount for deposit!");
        }
    }
    
    public void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            System.out.println("Money withdrawn:"+amount);
        }
        else{
            System.out.println("Insufficient balance ");
        }
    }
}

class ATM{
    private BankAccount account;
    private Scanner scanner;
    
    public ATM(BankAccount account){
        this.account=account;
        scanner= new Scanner(System.in);
    }
    
    public void showMenu(){
        System.out.println("***** WELCOME TO ATM *****");
        System.out.println("ATM Menu:");
        System.out.println("1.Check balance");
        System.out.println("2.Deposit cash");
        System.out.println("3.Withdraw cash");
        System.out.println("4.Exit");
    }
    
    public void start(){
        int choice;
        do{
            showMenu();
            System.out.print("Enter your choice::");
            choice=scanner.nextInt();
            switch(choice){
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting ATM.....");
                    break;
                default:
                    System.out.println("Invalid choice entered. Please select a valid choice");
                    
            }
        } while(choice!=4);
    }
    
    private void checkBalance(){
        System.out.println("Current balance:"+account.getBalance());
    }
    
    private void deposit(){
        System.out.print("Enter deposit amount:");
        double amount=scanner.nextDouble();
        account.deposit(amount);
    }
    
    private void withdraw(){
        System.out.print("Enter withdrawal amount:");
        double amount=scanner.nextDouble();
        account.withdraw(amount);
    }
}


public class Main
{
	public static void main(String[] args) {
		BankAccount userAccount=new BankAccount(1000);
		ATM atm=new ATM(userAccount);
		atm.start();
	}
}
