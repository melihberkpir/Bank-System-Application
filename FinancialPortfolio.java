
import java.util.ArrayList;
import java.util.Objects;

public class FinancialPortfolio {

    ArrayList<Account> accounts = new ArrayList<Account>();

    public FinancialPortfolio() {

    }

    // Method to add an account to the portfolio
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Method to remove a specific account from the portfolio
    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    // Method to calculate the total money value of the accounts in the portfolio
    public double calculateTotalValue() {
        double totalValue = 0;
        for (int i = 0; i < accounts.size(); i++) {
            totalValue += accounts.get(i).getBalance();
        }
        return totalValue;
    }

    public void printAllAccounts() {
        for (int i = 0; i < accounts.size(); i++) {
            Account a1 = accounts.get(i);
            System.out.println(a1.toString());
        }
    }
    //checking if the fp1 FinancialPortfolio or not
    @Override
    public boolean equals(Object fp1) {
        if (fp1 instanceof FinancialPortfolio) {
            if (this.calculateTotalValue() == ((FinancialPortfolio) fp1).calculateTotalValue()) {
                return true;
            }
        }
        return false;
    }
    

}
