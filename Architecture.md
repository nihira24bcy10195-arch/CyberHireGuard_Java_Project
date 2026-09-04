
---

# `docs/class-diagram.md`

```markdown
# Class Diagram

```mermaid
classDiagram

    class JobOffer {
        -String sender
        -String company
        -String message
        -double salary
        +JobOffer()
        +getSender()
        +getCompany()
        +getMessage()
        +getSalary()
        +setSender()
        +setCompany()
        +setMessage()
        +setSalary()
    }

    class AnalysisResult {
        -JobOffer offer
        -int riskScore
        -RiskLevel riskLevel
        -List~String~ warnings
        +getOffer()
        +getRiskScore()
        +getRiskLevel()
        +getWarnings()
    }

    class Analyzer {
        <<interface>>
        +analyze(JobOffer)
    }

    class RuleBasedAnalyzer {
        -Set~String~ suspiciousKeywords
        +analyze(JobOffer)
    }

    class AnalysisHistory {
        -List~AnalysisResult~ results
        -Deque~AnalysisResult~ recentResults
        -Map~String,Integer~ companyFrequency
        +addResult()
        +displayHistory()
        +displayRecentResults()
        +displayCompanyFrequency()
    }

    class ReportGenerator {
        +generateReport()
    }

    class BatchAnalyzer {
        -Analyzer analyzer
        -AnalysisHistory history
        +analyzeBatch()
    }

    class InputValidator {
        +validate()
    }

    class AnalysisException {
        +AnalysisException()
    }

    class RiskLevel {
        <<enumeration>>
        LOW
        MEDIUM
        HIGH
        CRITICAL
    }

    Analyzer <|.. RuleBasedAnalyzer

    JobOffer --> AnalysisResult
    AnalysisResult --> RiskLevel

    AnalysisHistory --> AnalysisResult
    BatchAnalyzer --> Analyzer
    BatchAnalyzer --> AnalysisHistory
    RuleBasedAnalyzer --> InputValidator

