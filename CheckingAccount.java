
public class CheckingAccount extends Account {
    //this class is a subclass of Account class because all CheckingAccount's are already 
    //an Account and can use the Account classes methods and properties

    private static int totalCheckingAccounts = 0;
    private final double INTEREST_RATE = 0.03;
    private boolean debitCard;
    private boolean ATM;
    private boolean online;

    public CheckingAccount(double balance, Customer owner, boolean debitCard, boolean ATM, boolean online) {
        super(balance, owner);
        this.ATM = ATM;
        this.debitCard = debitCard;
        this.online = online;
        totalCheckingAccounts++;
    }

    public boolean isDebitCard() {
        return debitCard;
    }

    public boolean isATM() {
        return ATM;
    }

    public boolean isOnline() {
        return online;
    }

    public void setDebitCard(boolean debitCard) {
        this.debitCard = debitCard;
    }

    public void setATM(boolean ATM) {
        this.ATM = ATM;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public static int getTotalCheckingAccounts() {
        return totalCheckingAccounts;
    }

    public double getINTEREST_RATE() {
        return INTEREST_RATE;
    }
    

    // Override the calculateBalanceOneYearLater method
    @Override
    public double calculateBalanceOneYearLater() {
        // simple interest calculation after one year
        return balance * (1 + INTEREST_RATE);
    }

    @Override
    public String toString() {
        return super.toString() + "Checking Account details : " + "debitCard=" + debitCard + ", ATM=" + ATM
                + ", online=" + online + "Balance one year later:" + calculateBalanceOneYearLater();
    }
    //checking if the obj is checkingaccount or not
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof CheckingAccount) {

            if (this.balance == ((CheckingAccount) obj).getBalance()&&this.getOwner()==((CheckingAccount) obj).getOwner()) {
                return true;
            }

        }
        return false;
    }

}
