
import java.util.Date;

public class Transaction {

    private int transactionId;
    private double amount;
    private String type; // "deposit" or "withdrawal"or"transfer"
    private final Date DATE_CREATED;

    // Constructor
    public Transaction(int transactionId, double amount, Date date, String type) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.DATE_CREATED = date;
        this.type = type;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return DATE_CREATED;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionId=" + transactionId + ", amount=" + amount + ", type="
                + type + ", dateCreated=" + DATE_CREATED + '}';
    }
}
