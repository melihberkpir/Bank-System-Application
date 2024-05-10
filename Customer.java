
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Customer implements AccountManagement {
//abstract class because customer has to be an individualcustomer or institutionalcustomer 
    private static int totalCustomers = 0;
    private int customerId;
    private String name;
    private String address;
    private String phoneNumber;
    ArrayList<Account> accounts = new ArrayList<Account>();

    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        totalCustomers++;
        this.customerId = totalCustomers;
    }

    public static int getTotalCustomers() {
        return totalCustomers;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAdress(String address) {
        this.address = address;
    }
    //from accountmanagement
    @Override
    public void updateContactDetails(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //from accountmanagement
    @Override
    public void displayAccountDetails() {
        for (int i = 0; i < accounts.size(); i++) {
            Account a1 = accounts.get(i);
            System.out.println(a1.toString());
        }

    }
    //from accountmanagement
    @Override
    public void createAccount(Account a1) {
        accounts.add(a1);
        
    }

    @Override
    public String toString() {
        return "customerId=" + customerId + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber;
    }


}
