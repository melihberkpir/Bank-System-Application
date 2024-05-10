
import java.util.ArrayList;

public class IndividualCustomer extends Customer {
    //this class is a subclass of Customer class because all IndividualCustomer's are already 
    //a Customer and can use the Customer classes methods and properties

    private static int totalIndividualCustomers = 0;
    private String gender;
    private String identificationInfo;
    private String occupation;

    ArrayList<Account> accounts = new ArrayList<Account>();

    public IndividualCustomer(String name, String address, String phoneNumber, String gender, String identificationInfo, String occupation) {
        super(name, address, phoneNumber);
        this.gender = gender;
        this.identificationInfo = identificationInfo;
        this.occupation = occupation;
        totalIndividualCustomers++;
    }

    public String getGender() {
        return gender;
    }

    public String getIdentificationInfo() {
        return identificationInfo;
    }

    public int getId() {
        return super.getCustomerId();
    }

    public String getOccupation() {
        return occupation;
    }

    public static int getTotalIndividualCustomers() {
        return totalIndividualCustomers;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    //checking if other individualcustomer or not
    public boolean equals(Object other) {
        double totalthis = 0;
        double totalother = 0;
        if (other instanceof IndividualCustomer) {

            for (int i = 0; i < accounts.size(); i++) {
                totalthis += accounts.get(i).getBalance();

            }
            for (int i = 0; i < ((IndividualCustomer) other).accounts.size(); i++) {
                totalother += accounts.get(i).getBalance();
            }
            if (totalthis == totalother) {
                System.out.println("This two Individual customers's monetory value is equal");
                return true;
            }

        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString()+"IndividualCustomer" + "gender=" + gender + ", identificationInfo=" + identificationInfo + ", occupation=" + occupation;
    }
    

}
