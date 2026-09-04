package cyberhireguard;

public interface Analyzer {

    AnalysisResult analyze(JobOffer offer) throws AnalysisException;
}