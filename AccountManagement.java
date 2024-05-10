
public interface AccountManagement {
    //We used AccountManagement interface for Customer class because all the objects of 
    //customer class should be able to use this methods

    abstract void createAccount(Account a1);

    abstract void displayAccountDetails();

    abstract void updateContactDetails(String phoneNumber);
}
