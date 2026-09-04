```java
package tests;

import cyberhireguard.AnalysisResult;
import cyberhireguard.Analyzer;
import cyberhireguard.JobOffer;
import cyberhireguard.RiskLevel;
import cyberhireguard.RuleBasedAnalyzer;

public class AnalyzerTest {

    public static void main(String[] args) {

        Analyzer analyzer = new RuleBasedAnalyzer();

        testSafeOffer(analyzer);
        testSuspiciousOffer(analyzer);
        testCriticalOffer(analyzer);

        System.out.println();
        System.out.println("All validation tests completed successfully.");
    }

    private static void testSafeOffer(Analyzer analyzer) {

        JobOffer offer = new JobOffer(
                "ABC Technologies",
                "Software Developer",
                "Join our development team. Apply through our official company website."
        );

        AnalysisResult result = analyzer.analyze(offer);

        if (result.getRiskLevel() == RiskLevel.LOW) {
            System.out.println("PASS: Safe offer test");
        } else {
            System.out.println("FAIL: Safe offer test");
        }
    }

    private static void testSuspiciousOffer(Analyzer analyzer) {

        JobOffer offer = new JobOffer(
                "Quick Jobs Online",
                "Work From Home Executive",
                "Earn a high salary from home. Pay a registration fee and click this link to continue."
        );

        AnalysisResult result = analyzer.analyze(offer);

        if (result.getRiskLevel() == RiskLevel.HIGH
                || result.getRiskLevel() == RiskLevel.CRITICAL
                || result.getRiskLevel() == RiskLevel.MEDIUM) {
            System.out.println("PASS: Suspicious offer test");
        } else {
            System.out.println("FAIL: Suspicious offer test");
        }
    }

    private static void testCriticalOffer(Analyzer analyzer) {

        JobOffer offer = new JobOffer(
                "Urgent Recruitment",
                "Remote Data Entry",
                "Congratulations! You have been selected. Pay the processing fee immediately. "
                        + "Send your password and OTP and click the verification link to receive your salary."
        );

        AnalysisResult result = analyzer.analyze(offer);

        if (result.getRiskLevel() == RiskLevel.CRITICAL) {
            System.out.println("PASS: Critical offer test");
        } else {
            System.out.println("FAIL: Critical offer test");
        }
    }
}
```
