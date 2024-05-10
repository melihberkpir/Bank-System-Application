
import java.util.ArrayList;
import java.util.Date;

public abstract class Account implements TransactionExecution {
//abstract class because account has to be a savings or checking account
    ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
    private static int totalAccounts = 0;
    private int accountId;
    protected double balance;
    private final Date DATE_CREATED;
    private Customer owner;
    private int countWithdraw = 0;
    private int countDeposit = 0;
    private int countTransfer = 0;

    public Account(double balance, Customer owner) {
        this.balance = balance;
        this.owner = owner;
        totalAccounts++;
        this.accountId = totalAccounts;
        DATE_CREATED = new Date();
    }
    //from transactionexecution
    @Override
    public void deposit(Transaction t1) {
        balance += t1.getAmount();
        countDeposit++;
        transactionHistory.add(new Transaction(transactionHistory.size() + 1, t1.getAmount(), new Date(), "deposit"));
    }
    //from transactionexecution
    @Override
    public void withdraw(Transaction t1) {
        if (balance >= t1.getAmount()) {
            balance -= t1.getAmount();
            countWithdraw++;
            transactionHistory.add(new Transaction(transactionHistory.size() + 1, t1.getAmount(), new Date(), "withdraw"));
        } else {
            System.out.println("Insufficient funds");
        }
    }
    //from transactionexecution
    @Override
    public void transfer(Account a1, Transaction t1) {
       if (a1 instanceof SavingsAccount) {
            if (((SavingsAccount) a1).getAccountStatus() == "closed") {//if the account is closed tranfer transaction cannot do
                System.out.println("This Account is closed.");

            } else if (((SavingsAccount) a1).getAccountStatus() == "dormant") {//if the account is dormant after the transaction this account going to be active account
                if (balance >= t1.getAmount()) {
                    balance -= t1.getAmount();
                    a1.setBalance(a1.getBalance() + t1.getAmount());
                    countTransfer++;
                    transactionHistory.add(new Transaction(transactionHistory.size() + 1, t1.getAmount(), new Date(), "transfer"));
                    System.out.println("Transfer is completed");
                    ((SavingsAccount) a1).setAccountStatus("active");
                } else {
                    System.out.println("Transfer is not completed");
                }

            } else {
                if (balance >= t1.getAmount()) {
                    balance -= t1.getAmount();
                    a1.setBalance(a1.getBalance() + t1.getAmount());
                    countTransfer++;
                    transactionHistory.add(new Transaction(transactionHistory.size() + 1, t1.getAmount(), new Date(), "transfer"));
                    System.out.println("Transfer is completed");
                } else {
                    System.out.println("Transfer is not completed");
                }

            }

        } else {
            if (balance >= t1.getAmount()) {
                balance -= t1.getAmount();
                a1.setBalance(a1.getBalance() + t1.getAmount());
                countTransfer++;
                transactionHistory.add(new Transaction(transactionHistory.size() + 1, t1.getAmount(), new Date(), "transfer"));
                System.out.println("Transfer is completed");
            } else {
                System.out.println("Transfer is not completed");
            }

        }
    }

    

    @Override
    public String toString() {
        return "Account Id: " + accountId + ", Balance: " + getBalance() + ", owner=" + owner.getName() + ", countWithdraw="
                + getCountWithdraw() + ", countDeposit=" + getCountDeposit() + ", dateCreated=" + DATE_CREATED + "Last two transactions : " + this.last2Transactions();
    }
    //The purpose of this method is finde the last 2 transactions and send to the toString method
    public String last2Transactions() {
        String c = "";
        if (transactionHistory.size() > 2) {
            for (int i = transactionHistory.size() - 2; i < transactionHistory.size(); i++) {
                Transaction t1 = transactionHistory.get(i);
                c += t1.toString();
            }
        } else if (transactionHistory.size() <= 2) {
            for (int i = 0; i < transactionHistory.size(); i++) {
                Transaction t1 = transactionHistory.get(i);
                c += t1.toString();
            }
        }

        return c;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public int getCountWithdraw() {
        return countWithdraw;
    }

    public int getCountDeposit() {
        return countDeposit;
    }

    public int getCountTransfer() {
        return countTransfer;
    }

    public abstract double calculateBalanceOneYearLater();

}
