# Project Workflow

```mermaid
flowchart TD

    START([Start]) --> MENU[Display Main Menu]

    MENU --> CHOICE{User Choice}

    CHOICE -->|1| INPUT[Enter Job Offer Details]
    INPUT --> VALIDATE[Validate Input]
    VALIDATE --> ANALYZE[Analyze Job Offer]
    ANALYZE --> SCORE[Calculate Risk Score]
    SCORE --> CLASSIFY[Assign Risk Level]
    CLASSIFY --> STORE[Store Analysis Result]
    STORE --> DISPLAY[Display Result]
    DISPLAY --> MENU

    CHOICE -->|2| HISTORY[View Analysis History]
    HISTORY --> MENU

    CHOICE -->|3| REPORT[Generate Security Report]
    REPORT --> MENU

    CHOICE -->|4| BATCH[Start Batch Analysis]
    BATCH --> THREADS[Create Worker Threads]
    THREADS --> ANALYSEBATCH[Analyze Multiple Offers]
    ANALYSEBATCH --> STOREBATCH[Store Results]
    STOREBATCH --> MENU

    CHOICE -->|5| RECENT[View Recent Analyses]
    RECENT --> MENU

    CHOICE -->|6| FREQUENCY[View Company Analysis Frequency]
    FREQUENCY --> MENU

    CHOICE -->|7| EXIT([Exit Program])
