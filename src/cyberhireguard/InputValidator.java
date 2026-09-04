package cyberhireguard;

public class InputValidator {

    public static void validate(JobOffer offer) throws AnalysisException {

        if (offer.getSender() == null ||
            offer.getSender().trim().isEmpty()) {

            throw new AnalysisException("Sender information cannot be empty.");
        }

        if (offer.getCompany() == null ||
            offer.getCompany().trim().isEmpty()) {

            throw new AnalysisException("Company name cannot be empty.");
        }

        if (offer.getMessage() == null ||
            offer.getMessage().trim().isEmpty()) {

            throw new AnalysisException("Job offer message cannot be empty.");
        }

        if (offer.getSalary() < 0) {
            throw new AnalysisException("Salary cannot be negative.");
        }
    }
}