# CyberHireGuard_Java_Project

## Project working idea  is on -  Fake Job Offer Scam Detector


**Student Name:** Nihira Das
**Registration Number:** 24BCY10195
**Course:** Programming in Java (CSE 2006)

---

## 1. Overview

CyberHire Guard is a Java-based rule-based application to identify suspicious job offers.

The application will ananlyse  job offer messages using predefined template of security indicators it will generate a risk score and  will also calassift the risk.

The system maintains analysis history, generates security reports using Java Streams and supports batch analysis .

---

## 2. Problem

Online job scams often uses unrealistic salary promises, urgent requests, payment requirements, suspicious links, OTP requests and requests for confidential information like bank details, passwords.

CyberHire Guard provides a simple Java based system that helps users identify these warning signs.

---

## 3. Features

* Job offer analysis
* Risk scoring
* Risk classification
* Suspicious keyword detection
* Payment-request detection
* OTP/password detection
* Suspicious-link detection
* Analysis history
* Recent analysis tracking
* Company analysis frequency
* Stream-based security reports
* Batch analysis
* Concurrent processing
* Input validation
* Custom exception handling

---

## 4. Technologies Used

* Java
* Object Oriented Programming
* Java Collections Framework
* ArrayList
* LinkedList
* Deque
* HashMap
* TreeSet
* Iterator
* Lambda Expressions
* Stream API
* ExecutorService
* Multithreading
* Exception Handling
* Git and GitHub
* Visual Studio Code

---

### Java Fundamentals used in this project

* Variables
* Data types
* Operators
* Expressions
* Input/output
* Conditional statements
* Loops
* Switch statements

### Object-Oriented Programming

* Classes
* Objects
* Constructors
* Encapsulation
* Interfaces
* Method overriding

### Exception Handling

* Custom exceptions
* try-catch
* Input validation
* Error handling

### Collections

* ArrayList
* LinkedList
* Deque
* Set
* TreeSet
* Map
* HashMap
* Iterator

### Streams and Lambdas

* Filtering
* Mapping
* Sorting
* Counting
* Grouping
* Lambda expressions

### Multithreading

* ExecutorService
* Fixed thread pool
* Future
* Concurrent task execution
* Synchronization

---

## 6. Project Structure

```text
CyberHireGuard/
│
├── README.md
├── statement.md
├── .gitignore
│
├── src/
│   └── cyberhireguard/
│       ├── Main.java
│       ├── JobOffer.java
│       ├── AnalysisResult.java
│       ├── RiskLevel.java
│       ├── Analyzer.java
│       ├── RuleBasedAnalyzer.java
│       ├── InputValidator.java
│       ├── AnalysisHistory.java
│       ├── ReportGenerator.java
│       ├── BatchAnalyzer.java
│       └── AnalysisException.java
│
├── data/
│   └── sample_offers.txt
│
├── tests/
│   └── AnalyzerTest.java
│
└── docs/
    ├── architecture.md
    ├── workflow.md
    ├── use-case.md
    ├── class-diagram.md
    ├── sequence-diagram.md
    └── er-diagram.md
```

---

## 7. Installation

Install Java JDK 21 or later.

Verify Java:

```bash
java --version
```

Verify the Java compiler:

```bash
javac --version
```

Clone the repository:

```bash
git clone <repository-url>
```

Enter the project directory:

```bash
cd CyberHireGuard
```

---

## 8. Compilation

Compile the source files:

```bash
javac -d out src/cyberhireguard/*.java
```

---

## 9. Running the Application

Run:

```bash
java -cp out cyberhireguard.Main
```

-------

## 10. Testing

The application can be tested by:

* Entering valid job-offer information
* Entering empty fields
* Entering invalid salary values
* Testing suspicious messages
* Testing normal messages
* Running batch analysis
* Generating reports
* Viewing analysis history


