package cyberhireguard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RuleBasedAnalyzer implements Analyzer {

    private final Set<String> suspiciousKeywords;

    public RuleBasedAnalyzer() {

        suspiciousKeywords = new TreeSet<>();

        suspiciousKeywords.add("urgent");
        suspiciousKeywords.add("fee");
        suspiciousKeywords.add("payment");
        suspiciousKeywords.add("bank");
        suspiciousKeywords.add("password");
        suspiciousKeywords.add("otp");
        suspiciousKeywords.add("guaranteed");
        suspiciousKeywords.add("click");
        suspiciousKeywords.add("crypto");
        suspiciousKeywords.add("investment");
    }

    @Override
    public AnalysisResult analyze(JobOffer offer)
            throws AnalysisException {

        InputValidator.validate(offer);

        String message = offer.getMessage().toLowerCase();

        int score = 0;

        List<String> warnings = new ArrayList<>();

        for (String keyword : suspiciousKeywords) {

            if (message.contains(keyword)) {

                score += 10;

                warnings.add(
                    "Suspicious keyword detected: " + keyword
                );
            }
        }

        if (message.contains("pay") ||
            message.contains("send money") ||
            message.contains("registration fee")) {

            score += 20;

            warnings.add(
                "The offer requests money or payment."
            );
        }

        if (message.contains("otp")) {

            score += 25;

            warnings.add(
                "The message requests an OTP."
            );
        }

        if (message.contains("password")) {

            score += 25;

            warnings.add(
                "The message requests a password."
            );
        }

        if (message.contains("click this link") ||
            message.contains("http://") ||
            message.contains("https://")) {

            score += 15;

            warnings.add(
                "Potentially suspicious link detected."
            );
        }

        if (offer.getSalary() >= 1000000) {

            score += 20;

            warnings.add(
                "Salary appears unusually high."
            );
        }

        RiskLevel level;

        if (score >= 70) {
            level = RiskLevel.CRITICAL;
        }
        else if (score >= 45) {
            level = RiskLevel.HIGH;
        }
        else if (score >= 20) {
            level = RiskLevel.MEDIUM;
        }
        else {
            level = RiskLevel.LOW;
        }

        return new AnalysisResult(
            offer,
            score,
            level,
            warnings
        );
    }
}