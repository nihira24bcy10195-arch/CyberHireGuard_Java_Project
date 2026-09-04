# Sequence Diagram

```mermaid
sequenceDiagram

    actor User
    participant Main
    participant Validator as InputValidator
    participant Analyzer as RuleBasedAnalyzer
    participant History as AnalysisHistory
    participant Report as ReportGenerator

    User->>Main: Select "Analyze Job Offer"
    Main->>User: Request job offer details
    User->>Main: Enter sender, company, salary and message

    Main->>Validator: Validate JobOffer
    Validator-->>Main: Validation successful

    Main->>Analyzer: Analyze JobOffer
    Analyzer->>Analyzer: Check suspicious keywords
    Analyzer->>Analyzer: Calculate risk score
    Analyzer->>Analyzer: Assign risk level

    Analyzer-->>Main: Return AnalysisResult

    Main->>History: Store AnalysisResult
    History-->>Main: Result stored

    Main->>User: Display analysis result

    User->>Main: Select "Generate Security Report"
    Main->>Report: Generate report
    Report->>History: Retrieve analysis results
    History-->>Report: Return stored results

    Report->>Report: Process results using Stream API
    Report-->>Main: Return security report
    Main->>User: Display security report
