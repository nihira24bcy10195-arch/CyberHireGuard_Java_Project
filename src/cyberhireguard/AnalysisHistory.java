package cyberhireguard;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AnalysisHistory {

    private final List<AnalysisResult> results;
    private final Deque<AnalysisResult> recentResults;
    private final Map<String, Integer> companyFrequency;

    public AnalysisHistory() {

        results = new ArrayList<>();
        recentResults = new LinkedList<>();
        companyFrequency = new HashMap<>();
    }

    public synchronized void addResult(AnalysisResult result) {

        results.add(result);

        recentResults.addFirst(result);

        if (recentResults.size() > 5) {
            recentResults.removeLast();
        }

        String company = result.getOffer().getCompany();

        companyFrequency.put(
            company,
            companyFrequency.getOrDefault(company, 0) + 1
        );
    }

    public List<AnalysisResult> getResults() {
        return results;
    }

    public void displayHistory() {

        if (results.isEmpty()) {

            System.out.println(
                "\nNo analysis has been performed yet."
            );

            return;
        }

        System.out.println(
            "\n========== ANALYSIS HISTORY =========="
        );

        Iterator<AnalysisResult> iterator =
                results.iterator();

        int count = 1;

        while (iterator.hasNext()) {

            AnalysisResult result =
                    iterator.next();

            System.out.println(
                count + ". " +
                result.getOffer().getCompany() +
                " | Risk: " +
                result.getRiskLevel() +
                " | Score: " +
                result.getRiskScore()
            );

            count++;
        }
    }

    public void displayRecentResults() {

        System.out.println(
            "\n========== RECENT ANALYSES =========="
        );

        for (AnalysisResult result : recentResults) {

            System.out.println(
                result.getOffer().getCompany() +
                " -> " +
                result.getRiskLevel()
            );
        }
    }

    public void displayCompanyFrequency() {

        System.out.println(
            "\n========== COMPANY ANALYSIS COUNT =========="
        );

        for (Map.Entry<String, Integer> entry :
                companyFrequency.entrySet()) {

            System.out.println(
                entry.getKey() +
                " : " +
                entry.getValue()
            );
        }
    }
}