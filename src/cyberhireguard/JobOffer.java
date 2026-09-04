package cyberhireguard;

public class JobOffer {

    private String sender;
    private String company;
    private String message;
    private double salary;

    public JobOffer(String sender, String company, String message, double salary) {
        this.sender = sender;
        this.company = company;
        this.message = message;
        this.salary = salary;
    }

    public String getSender() {
        return sender;
    }

    public String getCompany() {
        return company;
    }

    public String getMessage() {
        return message;
    }

    public double getSalary() {
        return salary;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nSender: " + sender +
               "\nCompany: " + company +
               "\nSalary: ₹" + salary +
               "\nMessage: " + message;
    }
}