package cyberhireguard;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGenerator {

    public static void generateReport(
            List<AnalysisResult> results) {

        if (results.isEmpty()) {

            System.out.println(
                "\nNo results available for reporting."
            );

            return;
        }

        long highRiskCount = results.stream()
                .filter(result ->
                    result.getRiskLevel() == RiskLevel.HIGH ||
                    result.getRiskLevel() == RiskLevel.CRITICAL)
                .count();

        double averageScore = results.stream()
                .mapToInt(AnalysisResult::getRiskScore)
                .average()
                .orElse(0.0);

        List<String> riskyCompanies = results.stream()
                .filter(result ->
                    result.getRiskLevel() == RiskLevel.HIGH ||
                    result.getRiskLevel() == RiskLevel.CRITICAL)
                .map(result ->
                    result.getOffer().getCompany())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        Map<RiskLevel, Long> riskDistribution =
                results.stream()
                        .collect(Collectors.groupingBy(
                            AnalysisResult::getRiskLevel,
                            Collectors.counting()
                        ));

        List<AnalysisResult> orderedResults =
                results.stream()
                        .sorted(
                            Comparator.comparingInt(
                                AnalysisResult::getRiskScore
                            ).reversed()
                        )
                        .collect(Collectors.toList());

        System.out.println(
            "\n========== SECURITY REPORT =========="
        );

        System.out.println(
            "Total Offers Analysed: " +
            results.size()
        );

        System.out.println(
            "High/Critical Risk Offers: " +
            highRiskCount
        );

        System.out.printf(
            "Average Risk Score: %.2f%n",
            averageScore
        );

        System.out.println(
            "\nRisk Distribution:"
        );

        riskDistribution.forEach(
            (level, count) ->
                System.out.println(
                    level + " : " + count
                )
        );

        System.out.println(
            "\nHigh-Risk Companies:"
        );

        riskyCompanies.forEach(
            company ->
                System.out.println("- " + company)
        );

        System.out.println(
            "\nOffers Ordered by Risk:"
        );

        orderedResults.forEach(
            result ->
                System.out.println(
                    result.getOffer().getCompany() +
                    " -> " +
                    result.getRiskScore()
                )
        );
    }
}