package cyberhireguard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final Analyzer analyzer =
            new RuleBasedAnalyzer();

    private static final AnalysisHistory history =
            new AnalysisHistory();

    public static void main(String[] args) {

        System.out.println(
            "--------------------------------------------"
        );

        System.out.println(
            "          CYBERHIRE GUARD"
        );

        System.out.println(
            "       Fake Job Offer Scam Detector"
        );

        System.out.println(
            "------------------------------------------------------"
        );

        boolean running = true;

        while (running) {

            displayMenu();

            try {

                int choice =
                        Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        analyzeOffer();
                        break;

                    case 2:
                        displayHistory();
                        break;

                    case 3:
                        generateReport();
                        break;

                    case 4:
                        runBatchAnalysis();
                        break;

                    case 5:
                        history.displayRecentResults();
                        break;

                    case 6:
                        history.displayCompanyFrequency();
                        break;

                    case 7:
                        System.out.println(
                            "\nThank you for using our  CyberHire Guard."
                        );

                        running = false;
                        break;

                    default:
                        System.out.println(
                            "\nInvalid choice. Try again."
                        );
                }

            }
            catch (NumberFormatException e) {

                System.out.println(
                    "\nenter a valid number."
                );
            }
            catch (Exception e) {

                System.out.println(
                    "\nUnexpected error: " +
                    e.getMessage()
                );
            }
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println(
            "\n------ Main Window ------"
        );

        System.out.println(
            "1. Analyze Job Offer"
        );

        System.out.println(
            "2. View Analysis History"
        );

        System.out.println(
            "3. Generate Security Report"
        );

        System.out.println(
            "4. Running Batch Analysis"
        );

        System.out.println(
            "5. Viewing Recent Analyses"
        );

        System.out.println(
            "6. View Company's Analysis Frequency"
        );

        System.out.println(
            "7. Exit"
        );

        System.out.print(
            "Enter choice: "
        );
    }

    private static void analyzeOffer()
            throws AnalysisException {

        System.out.println(
            "\n-------- NEW JOB OFFER ----------"
        );

        System.out.print(
            "Enter sender email/name: "
        );

        String sender =
                scanner.nextLine();

        System.out.print(
            "Enter company name: "
        );

        String company =
                scanner.nextLine();

        System.out.print(
            "Enter offered annual salary: ₹"
        );

        double salary;

        try {

            salary =
                Double.parseDouble(
                    scanner.nextLine()
                );

        }
        catch (NumberFormatException e) {

            throw new AnalysisException(
                "Salary must be a valid number."
            );
        }

        System.out.println(
            "Enter the job offer message:"
        );

        String message =
                scanner.nextLine();

        JobOffer offer =
                new JobOffer(
                    sender,
                    company,
                    message,
                    salary
                );

        AnalysisResult result =
                analyzer.analyze(offer);

        history.addResult(result);

        System.out.println(result);

        if (result.getWarnings().isEmpty()) {

            System.out.println(
                "\nNo major suspicious indicators detected."
            );

        }
        else {

            System.out.println(
                "\nRecommended Action: Proceed with caution."
            );
        }
    }

    private static void displayHistory() {

        history.displayHistory();
    }

    private static void generateReport() {

        ReportGenerator.generateReport(
            history.getResults()
        );
    }

    private static void runBatchAnalysis() {

        List<JobOffer> offers =
                new ArrayList<>();

        offers.add(
            new JobOffer(
                "hr@company.com",
                "TechNova",
                "Congratulations! You have been selected. " +
                "Pay a registration fee immediately.",
                600000
            )
        );

        offers.add(
            new JobOffer(
                "recruitment@securejobs.com",
                "SecureJobs",
                "We would like to schedule an interview " +
                "for the software developer position.",
                800000
            )
        );

        offers.add(
            new JobOffer(
                "unknown@gmail.com",
                "Global Careers",
                "URGENT! Click this link and provide your " +
                "OTP and bank password to receive your salary.",
                1500000
            )
        );

        BatchAnalyzer batchAnalyzer =
                new BatchAnalyzer(
                    analyzer,
                    history
                );

        batchAnalyzer.analyzeBatch(offers);
    }
}
