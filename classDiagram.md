# Class Diagram

```mermaid
classDiagram

    class JobOffer {
        -String sender
        -String company
        -String message
        -double salary
        +JobOffer(String, String, String, double)
        +getSender() String
        +getCompany() String
        +getMessage() String
        +getSalary() double
        +setSender(String)
        +setCompany(String)
        +setMessage(String)
        +setSalary(double)
        +toString() String
    }

    class AnalysisResult {
        -JobOffer offer
        -int riskScore
        -RiskLevel riskLevel
        -List~String~ warnings
        +AnalysisResult(JobOffer, int, RiskLevel, List)
        +getOffer() JobOffer
        +getRiskScore() int
        +getRiskLevel() RiskLevel
        +getWarnings() List
        +toString() String
    }

    class Analyzer {
        <<interface>>
        +analyze(JobOffer) AnalysisResult
    }

    class RuleBasedAnalyzer {
        -Set~String~ suspiciousKeywords
        +RuleBasedAnalyzer()
        +analyze(JobOffer) AnalysisResult
    }

    class InputValidator {
        +validate(JobOffer)
    }

    class AnalysisHistory {
        -List~AnalysisResult~ results
        -Deque~AnalysisResult~ recentResults
        -Map~String,Integer~ companyFrequency
        +addResult(AnalysisResult)
        +getResults() List
        +displayHistory()
        +displayRecentResults()
        +displayCompanyFrequency()
    }

    class ReportGenerator {
        +generateReport(List~AnalysisResult~)
    }

    class BatchAnalyzer {
        -Analyzer analyzer
        -AnalysisHistory history
        +BatchAnalyzer(Analyzer, AnalysisHistory)
        +analyzeBatch(List~JobOffer~)
    }

    class AnalysisException {
        +AnalysisException(String)
    }

    class RiskLevel {
        <<enumeration>>
        LOW
        MEDIUM
        HIGH
        CRITICAL
    }

    class Main {
        -Scanner scanner
        -Analyzer analyzer
        -AnalysisHistory history
        +main(String[])
    }

    Analyzer <|.. RuleBasedAnalyzer

    AnalysisResult --> JobOffer
    AnalysisResult --> RiskLevel

    RuleBasedAnalyzer --> InputValidator
    RuleBasedAnalyzer --> AnalysisResult

    AnalysisHistory --> AnalysisResult

    ReportGenerator --> AnalysisResult

    BatchAnalyzer --> Analyzer
    BatchAnalyzer --> AnalysisHistory
    BatchAnalyzer --> JobOffer

    Main --> Analyzer
    Main --> AnalysisHistory
    Main --> BatchAnalyzer

    RuleBasedAnalyzer ..> AnalysisException
    InputValidator ..> AnalysisException
