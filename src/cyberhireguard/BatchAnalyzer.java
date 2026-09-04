package cyberhireguard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BatchAnalyzer {

    private final Analyzer analyzer;
    private final AnalysisHistory history;

    public BatchAnalyzer(
            Analyzer analyzer,
            AnalysisHistory history) {

        this.analyzer = analyzer;
        this.history = history;
    }

    public void analyzeBatch(List<JobOffer> offers) {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        List<Future<AnalysisResult>> futures =
                new ArrayList<>();

        for (JobOffer offer : offers) {

            Future<AnalysisResult> future =
                    executor.submit(() -> {

                        AnalysisResult result =
                                analyzer.analyze(offer);

                        history.addResult(result);

                        return result;
                    });

            futures.add(future);
        }

        System.out.println(
            "\n- BATCH ANALYSIS -"
        );

        for (Future<AnalysisResult> future : futures) {

            try {

                AnalysisResult result =
                        future.get();

                System.out.println(
                    result.getOffer().getCompany() +
                    " -> " +
                    result.getRiskLevel() +
                    " (" +
                    result.getRiskScore() +
                    ")"
                );

            }
            catch (Exception e) {

                System.out.println(
                    "Error during batch analysis: " +
                    e.getMessage()
                );
            }
        }

        executor.shutdown();
    }
}