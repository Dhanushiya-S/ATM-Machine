import java.util.*;

public class ATM{
    private double balance;
    private double depositAmount;
    private double withdrawAmount;

    //default constructor
    public ATM(){

    }
    //getter setter
    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getDepositAmount(){
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount){
        this.depositAmount = depositAmount;
    }

    public double getWithdrawAmount(){
        return withdrawAmount;
    }

    public void setWithdrawAmount(double withdrawAmount){
        this.withdrawAmount = withdrawAmount;
    }

}

//interface

interface AtmOperationinterf{
    public void viewBalance();
    public void withdrawAmount(double withdrawAmount);
    public void depositAmount(double depositAmount);
    public void viewMiniStatement();
}

class AtmOperationimpl implements AtmOperationinterf{
    ATM atm = new ATM();
    Map<Double,String> ministmt = new HashMap<>();

    public void viewBalance(){
        System.out.println("Available Balance is : "+atm.getBalance());
    }

    public void withdrawAmount(double withdrawAmount){
        if(withdrawAmount <= atm.getBalance()){
            ministmt.put(withdrawAmount," Amount Withdrawn");
            System.out.println("Collect the cash "+withdrawAmount);
            atm.setBalance(atm.getBalance() - withdrawAmount);
            viewBalance();
        }
        else{
            System.out.println("Insufficient Balance !!");
        }
    }    

    public void depositAmount(double depositAmount){
        ministmt.put(depositAmount," Amount Deposited");
        System.out.println(depositAmount+" Deposited Successfully !!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();
    }  

    public void viewMiniStatement(){
        for(Map.Entry<Double,String> m : ministmt.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }
    }  
}

class Main{
    public static void main(String args[]){
        AtmOperationinterf op = new AtmOperationimpl();
        int atmnumber;
        int atmpin;

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ATM Machine!");
        System.out.println("Enter ATM number : ");
        atmnumber = sc.nextInt();
        System.out.println("Enter Pin : ");
        atmpin = sc.nextInt();
        if(atmnumber == atmpin){
            while(true){
                System.out.println("1. View Available Balance\n2. WithDraw Amount\n3. Deposit Amount\n4. View Ministatement\n5. Exit");
                System.out.println("Enter Choice : ");
                int ch = sc.nextInt();
                if(ch == 1){
                    op.viewBalance();
                }
                else if(ch == 2){
                    System.out.println("Enter the amount to Withdraw : ");
                    double withdrawAmount = sc.nextDouble();
                    op.withdrawAmount(withdrawAmount);
                }
                else if(ch == 3){
                    System.out.println("Enter the amount to Deposit : ");
                    double depositAmount = sc.nextDouble();
                    op.depositAmount(depositAmount);
                }
                else if(ch == 4){
                    op.viewMiniStatement();
                }
                else if(ch == 5){
                    System.out.println("Collect your ATM card\nThank You :)");
                    System.exit(0);
                }
                else{
                    System.out.println("Please enter correct Choice : ");
                }
            }

        }
        else{
            System.out.println("Incorrect ATM number or pin");
            System.exit(0);
        }

    }
}