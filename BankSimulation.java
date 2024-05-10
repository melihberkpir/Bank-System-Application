
import java.util.Date;
import java.util.Scanner;

public class BankSimulation {

    public static void main(String[] args) {
        IndividualCustomer indc1 = new IndividualCustomer("Melih Berk Pir", "Ümraniye/İstanbul",
                "05353553535", "Male", "12134545345", "Student");
        FinancialPortfolio fp1 = new FinancialPortfolio();
        CheckingAccount ca1 = new CheckingAccount(1000, indc1, true, true, true);
        SavingsAccount sa1 = new SavingsAccount(500, 0.05, indc1, "active");
        SavingsAccount sa2 = new SavingsAccount(5000, 0.03, indc1, "active");
        indc1.createAccount(ca1);
        indc1.createAccount(sa1);
        indc1.createAccount(sa2);
        fp1.addAccount(sa1);
        fp1.addAccount(sa2);
        Transaction t1 = new Transaction(0, 500, new Date(), "deposit");
        Transaction t2 = new Transaction(0, 1000, new Date(), "deposit");
        Transaction t3 = new Transaction(0, 2000, new Date(), "deposit");
        System.out.println("How much money do you want to deposit?\n1.500\n2.1000\n3.2000");
        Scanner input = new Scanner(System.in);
        int depositmoney = input.nextInt();
        switch (depositmoney) {
            case 1:
            case 500:
                sa2.deposit(t1);
                break;
            case 2:
            case 1000:
                sa2.deposit(t2);
                break;
            case 3:
            case 2000:
                sa2.deposit(t3);
                break;
            default:
                System.out.println("Invalid Transaction");
                break;
        }

        indc1.displayAccountDetails();
        System.out.println(fp1.calculateTotalValue());
        fp1.removeAccount(sa2);
        System.out.println(fp1.calculateTotalValue());
        fp1.printAllAccounts();
        IndividualCustomer indc2 = new IndividualCustomer("Ezgi Baylam", "Sile/İstanbul",
                "0505055555", "Female", "12134545345", "Student");
        FinancialPortfolio fp2 = new FinancialPortfolio();
        CheckingAccount ca2 = new CheckingAccount(5000, indc2, false, false, false);
        indc2.createAccount(ca2);
        System.out.println(ca2.toString());
        fp2.addAccount(ca2);
        System.out.println(fp2.calculateTotalValue());
        fp2.printAllAccounts();
        System.out.println(fp1.equals(fp2));
        Transaction t4 = new Transaction(0, 2000, new Date(), "deposit");
        ca2.deposit(t4); 
        Transaction t5 = new Transaction(0, 500, new Date(), "transfer");
        ca1.transfer(ca2, t5);
        indc1.displayAccountDetails();
        indc2.displayAccountDetails();
        System.out.println(fp1.equals(fp2));

    }
}
