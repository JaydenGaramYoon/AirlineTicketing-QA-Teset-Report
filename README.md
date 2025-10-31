📁 Repository Structure
airline-ticketing-qasuite/
│
├── src/
│   └── test/
│       └── java/
│           └── com/airline/
│               ├── SellTicketTest.java
│               ├── SeatReservationTest.java
│               ├── PassengerValidationTest.java
│               └── FlightManifestTest.java
│
├── reports/
│   ├── QA_Analysis_Summary.xlsx
│   ├── Requirement_Test_Mapping.xlsx
│   └── Defect_Log.xlsx
│
├── screenshots/
│   ├── BUG-JUNIT-TC08-005.png
│   ├── BUG-PROMPT-TC03-002.png
│   ├── BUG-PROMPT-TC06-005.png
│   └── ...
│
├── README.md
└── pom.xml

🧾 README.md
# Airline Ticketing System - QA Test Suite (JUnit + E2E)

This repository contains automated JUnit test cases and QA analysis artifacts for the Airline Ticketing System.  
It includes both functional and non-functional testing to validate core business logic, seat management, and console behavior.


## Overview

| Metric | Value |
|--------|--------|
| Total Test Cases | 24 |
| Pass Rate | 54.17% |
| Requirement Coverage | 100% |
| Defect Density | 45.83% |
| High/Critical Defects | 57% |


## Requirements Covered

**Business Requirements (BR):** 01–07  
**Non-Functional Requirements (NO):** 01–05  

Detailed mapping is available in [QA_Analysis_Summary.xlsx](reports/QA_Analysis_Summary.xlsx).


## Test Classes

| Test Class | Description |
|-------------|--------------|
| SellTicketTest.java | Validates ticket pricing, discount logic, and sale recording |
| SeatReservationTest.java | Checks seat duplication prevention and seat plan consistency |
| PassengerValidationTest.java | Verifies passenger type exclusivity and input validation |
| FlightManifestTest.java | Confirms seat state updates and manifest accuracy |


## How to Run Tests

```bash
# Clone the repository
git clone https://github.com/<your-username>/airline-ticketing-qasuite.git
cd airline-ticketing-qasuite

# Run all JUnit tests
mvn test


## 1. Project Overview

This project focuses on **quality assurance testing** for the **Airline Ticketing Application** developed in **Java**. The goal was to verify that all business and non-functional requirements were correctly implemented through a combination of **JUnit and End-to-End (E2E) tests**. Key testing areas included **seat management, discount logic, and prompt validation**.

---

## 2. Key QA Metrics into Charts

The pass rate shows complete coverage but highlights **stability and validation gaps in the current build.**

### QA Analysis Summary (Integrated E2E + JUnit)

[Click here to review the full QA Analysis Summary](https://docs.google.com/spreadsheets/d/e/2PACX-1vTa5k6aAdRJXrK7lw9Gk1bnGyRnWfn7vWqMmnKSOU_Mkj_ZLiTLr0hQPKQd8-UaPnYstwr4OF96IUrb/pubhtml?gid=69442221&single=true) 

![image.png](attachment:8c8a0be9-901f-4145-9b88-afc4f8e89aa9:88f886a6-cd08-4a43-b2d3-b5d9509bff7b.png)

### Test1 - E2E Manual Testing Summary

[Click here to review the full E2E Testing Report & Summary](https://docs.google.com/spreadsheets/d/e/2PACX-1vTa5k6aAdRJXrK7lw9Gk1bnGyRnWfn7vWqMmnKSOU_Mkj_ZLiTLr0hQPKQd8-UaPnYstwr4OF96IUrb/pubhtml?gid=0&single=true)

1. Test Metrics Summary

![image.png](attachment:b378013a-ed3c-4356-a010-44c71ff7d26e:image.png)

1. Defect Summary

![image.png](attachment:583dce32-768a-4023-87c6-93dc4db89f09:image.png)

### Test2 - JUnit Automation Testing Summary

[Click here to review the full JUnit Automation Testing Report & Summary](https://docs.google.com/spreadsheets/d/e/2PACX-1vTa5k6aAdRJXrK7lw9Gk1bnGyRnWfn7vWqMmnKSOU_Mkj_ZLiTLr0hQPKQd8-UaPnYstwr4OF96IUrb/pubhtml?gid=1885570547&single=true)

1. Test Metrics Summary

![image.png](attachment:1dc3f2cb-952b-4f3f-b2c7-36b3042f1c05:image.png)

1. Defect Summary

![image.png](attachment:622026b6-2b93-40e5-90e6-72de105fe25c:image.png)

---

## 3. Requirement Traceability Matrix (Summary)

[Click here to review the full RTM Summary](https://docs.google.com/spreadsheets/d/e/2PACX-1vTa5k6aAdRJXrK7lw9Gk1bnGyRnWfn7vWqMmnKSOU_Mkj_ZLiTLr0hQPKQd8-UaPnYstwr4OF96IUrb/pubhtml?gid=69442221&single=true) 

1. Requirements Traceability Matrix

![image.png](attachment:d6f8a4cf-1661-4398-bfd3-f0fa78b58d66:image.png)

1. Requirement Pass/Fail Status Overview

![image.png](attachment:2dd70b79-3f6c-4704-a660-6fd83b08428a:image.png)

## 4. Defect Analysis

**Most critical defects were related to synchronization issues in seat management**. Multiple tests confirmed that seat allocation states were not consistently updated between Business and Economy classes. **Another recurring issue was input validation failure in user prompts**, where the system failed to exit invalid input loops properly. These indicate the need for synchronization locks and centralized validation control.

![image.png](attachment:47428f0a-7cc6-424e-94a1-a21ecab027cb:image.png)

## 5. Key Observations

![image.png](attachment:fb2e1198-605d-466f-986c-0c10c5b49343:image.png)

## 6. Recommendations

- Implement synchronization locks in seat management.
- Centralize input validation to reduce redundant loops.
- Standardize console prompts for user consistency.
- Conduct regression tests after fixes are applied.

These actions aim to increase stability and maintain data integrity across seat and pricing modules.

## 7. Reflection

Through automating input validation loop tests, I learned **how automation can significantly reduce time and human error in repetitive QA tasks.** This process helped **identify infinite loop defects and inconsistent prompt handling more effectively than manual testing**. It reinforced my understanding that strategic automation not only improves testing efficiency but also enhances long-term system stability.
