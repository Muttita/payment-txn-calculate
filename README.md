# Payment Transaction Calculator

A Java application that reads payment transaction data from a CSV file and calculates
the **minimum, maximum, and average payment amounts**.

---
## 🛠️ Technologies Used
- Java 21
- Maven
- JUnit 5
- Docker
---

## 👩‍💻  Project Overview

This project is designed to:
- Read payment transaction records from a CSV file
- Calculate `min`, `max` and `average` payment amounts.
- Display results via the console

---

## 📂 Project Structure

```text
payment-txn-calculate
├── src
│   ├── main
│   │   └── java
│   │       ├── reader
│   │       │   └── PaymentTxnReader.java
│   │       ├── calculator
│   │       │   └── PaymentTxnCalculator.java
│   │       └── Main.java
│   └── test
│       └── java
│           ├── reader
│           │   └── PaymentTxnReaderTest.java
│           └── calculator
│               └── PaymentTxnCalculatorTest.java
├── data
│   └── payments.csv
├── Dockerfile
├── pom.xml
└── README.md
```

---
## ❤️ How to Run the Application

### Option 1: Run **Without Docker**

#### Prerequisites
- Java JDK 21
- Maven 3.x

#### 1. Build the project
```bash
mvn clean package
```
#### 2. Run the application
```bash
java -jar target/payment-txn-calculate-1.0-SNAPSHOT.jar data/payments.csv
```
If no file path is provided, the application will use the default file path:
```bash
data/payments.csv
```

### Option 2: Run **With Docker**

#### 1. Build the Docker image
```bash
docker build -t payment-txn-calculate .
```
#### 2. Run the Docker container
```bash
docker run --rm payment-txn-calculate
```
The application will automatically read the CSV file from:
```bash
data/payments.csv
```
If you want to use a different CSV file when running with Docker,
you can update the file path in the `Dockerfile` and rebuild the image.

After modifying the Dockerfile, rebuild the image using:
```bash
docker build -t payment-txn-calculate .
```
---
## 🧮 Calculation Logic
The program calculates the following values from valid payment amounts:
- Minimum (Min): the smallest payment amount
- Maximum (Max): the largest payment amount
- Average (Avg): total sum divided by the number of valid records

If no valid payment records are found, all calculated values will be `0.0`

---
## 🔑 Explanation of the Approach
### Separation of Responsibilities

- *PaymentTxnReader* : Reads and parses the CSV file, extracting valid payment amounts
- *PaymentTxnCalculator* : Calculates minimum, maximum, and average values
- *Main: Handles program flow*: input arguments, and console output

### Data Validation
- The first row (header) is skipped.
- Records are ignored if:
  - Coloumns are missing.
  - Payment amount is not numeric.
- Invalid records do not stop program execution.

### Unit Testing
- Implemented using JUnit 5.
- Covers:
  - Min, Max, and Average calculations.
  - Empty or null input handling.
  - CSV reading with valid and invalid records.

---
## 💭 Assumptions Made
- Input data is provided in CSV format.
- The first row is a header.
- Payment amount column position is fixed.
- Invalid records should be skipped.
- Currency values are not converted; calculations are performed assuming the same currency.
- Results are displayed in the console output.