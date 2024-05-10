
import java.util.ArrayList;

public class InstitutionalCustomer extends Customer {
    //this class is a subclass of Customer class because all InstitutionalCustomer's are already 
    //a Customer and can use the Customer classes methods and properties

    private static int totalInstitutionalCustomers = 0;
    private String typeOfInstitution;
    private String industrySector;
    private double annualRevenue;

    ArrayList<Account> accounts = new ArrayList<>();

    public InstitutionalCustomer(String name, String address, String phoneNumber, String typeOfInstitution, String industrySector, double annualRevenue) {
        super(name, address, phoneNumber);
        this.typeOfInstitution = typeOfInstitution;
        this.industrySector = industrySector;
        this.annualRevenue = annualRevenue;//budget
        totalInstitutionalCustomers++;
    }

    public int getId() {
        return super.getCustomerId();
    }

    public String getTypeOfInstitution() {
        return typeOfInstitution;
    }

    public void setTypeOfInstitution(String typeOfInstitution) {
        this.typeOfInstitution = typeOfInstitution;
    }

    public String getSector() {
        return industrySector;
    }

    public void setIndustrySector(String industrySector) {
        this.industrySector = industrySector;
    }

    public double getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(double annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public static int getTotalInstitutionalCustomers() {
        return totalInstitutionalCustomers;
    }

    public String getIndustrySector() {
        return industrySector;
    }
    //checking if other institutionalcustomer or not
    public boolean equals(Object other) {
        double totalthis = 0;
        double totalother = 0;

        if (other instanceof InstitutionalCustomer) {
            for (int i = 0; i < accounts.size(); i++) {
                totalthis += accounts.get(i).getBalance();

            }
            for (int i = 0; i < ((InstitutionalCustomer) other).accounts.size(); i++) {
                totalother += accounts.get(i).getBalance();
            }
            if (totalthis == totalother) {
                System.out.println("This two Institutional customers's monetory value is equal");
                return true;
            }

        }
        return false;

    }

    @Override
    public String toString() {
        return super.toString()+"InstitutionalCustomer" + "typeOfInstitution=" + typeOfInstitution + ", industrySector=" + industrySector + ", annualRevenue=" + annualRevenue;
    }
    
}
