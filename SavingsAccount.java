
public class SavingsAccount extends Account {
    //this class is a subclass of Account class because all SavingsAccount's are already 
    //an Account and can use the Account classes methods and properties
    private static int totalSavingsAccounts = 0;
    private double rate;
    private String accountStatus; //active,dormant,closed
    
    
    public SavingsAccount(double balance,double rate,Customer owner,String accountStatus){
        super(balance,owner);
        this.rate=rate;
        this.accountStatus=accountStatus;
        totalSavingsAccounts++;
    }
    public double getRate() {
        return rate;
    }
    public void SetRate(double rate) {
        this.rate=rate;
    }
    
    @Override
    public String toString() {
        return super.toString()+"Savings Account rate=" + rate + ", accountStatus=" + getAccountStatus() + '}'+"Balance one year later:"+calculateBalanceOneYearLater();
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
    // Override the calculateBalanceOneYearLater method
    @Override
    public double calculateBalanceOneYearLater() {
        // simple interest calculation after one year
        return balance* (1 + rate);
    }
    //checking if the obj is savingsaccount or not
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof SavingsAccount) {

            if (this.balance == ((SavingsAccount) obj).getBalance()&&this.getOwner()==((SavingsAccount) obj).getOwner()) {
                return true;
            }

        }
        return false;
    }
    

}


