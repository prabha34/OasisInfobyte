package JavaProject;
import java.util.Scanner;

class BankAccount{


    String userid;
    String userPin;
    float balance = 10000f;
    int transactions = 0;
    String transactionHistory = "";

    public void login() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter your Userid: ");
        this.userid = sc.nextLine();
        System.out.println("\nEnter your userPin: ");
        this.userPin = sc.nextLine();
        System.out.println("\n Successful . Please Log in to your Bank Account");
    }


    public void withdraw() {
        System.out.println("\nEnter Amount to Withdraw: ");
        Scanner sc=new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if(balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("\nWithdral Successful.");
                String str = amount + "Rs Withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            }else {
                System.out.println("\nInsufficient Balance.");
            }
        }catch(Exception e) {

        }

    }

    public void deposit() {
        System.out.println("\nEnter Amount to Deposit: ");
        Scanner sc=new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if(amount <= 10000f) {
                transactions++;
                balance += amount;
                System.out.println("\nDeposit Successful.");
                String str = amount + "Rs deposited\n";
                transactionHistory = transactionHistory.concat(str);
            }else {
                System.out.println("\nSorry. The limit is 10000.");
            }
        }catch(Exception e) {

        }

    }

    public void transfer() {
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter Receipent's Name: ");
        String receipent = sc.nextLine();
        System.out.println("\nEnter Amount to transfer: ");
        float amount = sc.nextFloat();
        try {
            if(balance>= amount) {
                if(amount <= 50000f) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccesfully Transferred to "+ receipent);
                    String str = amount + "Rs transferred to " + receipent+"\n";
                    transactionHistory = transactionHistory.concat(str);
                }else {
                    System.out.println("\nSorry. The limit is 50000.");
                }
            }else{
                System.out.println("\nInsufficient Balance.");
            }}catch(Exception e) {
        }

    }

    public void checkBalance() {
        System.out.println("\n"+balance+"Rs");
    }




    public void transHistory() {
        if(transactions ==0) {
            System.out.println("No TRansactions happened");
        }else {
            System.out.print("\n"+transactionHistory);
        }
    }
}

public class ATMInterface {

    public static int takenIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && input > limit || input < 1) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value.");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\n********************WELCOME TO  ATM INTERFACE*******************");
        System.out.println("\n1.Register \n2.Exit");
        System.out.println("Choose one option: ");
        int choose = takenIntegerInput(2);

        if (choose == 1) {
            BankAccount b = new BankAccount();
            b.login();
            while (true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.println("Enter your choice: ");
                int ch = takenIntegerInput(2);

                System.out.println("\n1.withdraw \n2.Deposit \n3.Transfer \n4.check balance \n5.Transaction History \n6.Exit");
                System.out.println("Enter your choice: ");
                int c = takenIntegerInput(6);
                switch (c) {
                    case 1:
                        b.withdraw();
                        break;
                    case 2:
                        b.deposit();
                        break;
                    case 3:
                        b.transfer();
                        break;
                    case 4:
                        b.checkBalance();
                        break;
                    case 5:
                        b.transHistory();
                        break;

                }
            }
        }
    }
}

