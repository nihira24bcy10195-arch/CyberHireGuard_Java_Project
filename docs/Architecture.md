# System Architecture

```mermaid
flowchart TD

    U[User] --> UI[Main Menu / Console Interface]

    UI --> INPUT[Job Offer Input]

    INPUT --> VALID[Input Validator]

    VALID --> ANALYZER[Rule Based Analyzer]

    ANALYZER --> RULES[Suspicious Keyword Rules]

    ANALYZER --> RESULT[Analysis Result]

    RESULT --> HISTORY[Analysis History]

    HISTORY --> COLLECTIONS[Java Collections]

    RESULT --> REPORT[Report Generator]

    REPORT --> STREAMS[Java Stream API]

    UI --> BATCH[Batch Analyzer]

    BATCH --> EXECUTOR[ExecutorService]

    EXECUTOR --> ANALYZER

    HISTORY --> OUTPUT[Console Reports]

    REPORT --> OUTPUT
