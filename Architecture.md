
---

# `docs/sequence-diagram.md`

```markdown
# Sequence Diagram

```mermaid
sequenceDiagram

    actor User
    participant Main
    participant Validator
    participant Analyzer
    participant History
    participant Report

    User->>Main: Select Analyze Job Offer
    User->>Main: Enter job offer data

    Main->>Validator: Validate offer

    Validator-->>Main: Valid input

    Main->>Analyzer: analyze(offer)

    Analyzer->>Analyzer: Check suspicious keywords
    Analyzer->>Analyzer: Calculate risk score
    Analyzer->>Analyzer: Determine risk level

    Analyzer-->>Main: AnalysisResult

    Main->>History: addResult(result)

    History-->>Main: Result stored

    Main-->>User: Display analysis result

    User->>Main: Generate report

    Main->>Report: generateReport(history)

    Report->>Report: Stream filtering
    Report->>Report: Stream sorting
    Report->>Report: Stream grouping

    Report-->>Main: Security report

    Main-->>User: Display report

    
