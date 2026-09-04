# Data Storage / ER Diagram

## Current Storage Design

CyberHire Guard does not currently use a relational database.

Analysis data is maintained in memory using Java Collections:

- `ArrayList<AnalysisResult>` stores all analysis results.
- `Deque<AnalysisResult>` maintains the five most recent results.
- `HashMap<String, Integer>` maintains company analysis frequency.
- `TreeSet<String>` stores suspicious keywords in sorted order.

The conceptual relationship between a job offer and its analysis result is shown below.

```mermaid
erDiagram

    JOB_OFFER {
        string sender
        string company
        string message
        double salary
    }

    ANALYSIS_RESULT {
        int riskScore
        string riskLevel
        string warnings
    }

    JOB_OFFER ||--|| ANALYSIS_RESULT : "produces"
