package cyberhireguard;

import java.util.List;

public class AnalysisResult {

    private JobOffer offer;
    private int riskScore;
    private RiskLevel riskLevel;
    private List<String> warnings;

    public AnalysisResult(JobOffer offer, int riskScore,
                          RiskLevel riskLevel, List<String> warnings) {
        this.offer = offer;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.warnings = warnings;
    }

    public JobOffer getOffer() {
        return offer;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    @Override
    public String toString() {
        return "\n===== ANALYSIS RESULT =====" +
               "\nCompany: " + offer.getCompany() +
               "\nRisk Score: " + riskScore +
               "\nRisk Level: " + riskLevel +
               "\nWarnings: " + warnings;
    }
}