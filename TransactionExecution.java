
public interface TransactionExecution {
    //we used TransactionExecution interface for Account class because Account make same transactions and this transactions
    //must comply with "Transaction Execution"
    public abstract void deposit(Transaction t1);
    public abstract void withdraw(Transaction t1);
    public abstract void transfer(Account destination, Transaction t1);
}
