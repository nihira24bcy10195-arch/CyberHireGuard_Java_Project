# Use Case Diagram

```mermaid
flowchart LR

    USER((User))

    USER --> UC1[Analyze Job Offer]
    USER --> UC2[View Analysis History]
    USER --> UC3[Generate Security Report]
    USER --> UC4[Run Batch Analysis]
    USER --> UC5[View Recent Analyses]
    USER --> UC6[View Company Analysis Frequency]

    UC1 --> V[Input Validation]
    UC1 --> A[Rule-Based Analysis]
    A --> R[Risk Classification]

    UC3 --> S[Java Stream API]

    UC4 --> E[ExecutorService]
