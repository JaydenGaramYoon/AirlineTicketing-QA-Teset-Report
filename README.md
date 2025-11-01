# Airline Ticketing System - QA Test Suite (JUnit + E2E)

This repository contains **automated JUnit test cases and QA analysis artifacts** for the Airline Ticketing System.  
It includes both **functional and non-functional testing** to validate core business logic, seat management, and console behavior.


## 1. Project Overview

This project focuses on **quality assurance testing** for the **Airline Ticketing Application** developed in **Java**. The goal was to verify that all business and non-functional requirements were correctly implemented through a combination of **JUnit and End-to-End (E2E) tests**. Key testing areas included **seat management, discount logic, and prompt validation**.


## 2. Key QA Metrics into Charts

The pass rate shows complete coverage but highlights **stability and validation gaps in the current build.**

### QA Analysis Summary (Integrated E2E + JUnit)

[Click here to view/download the full QA Analysis Summary](https://drive.google.com/file/d/1n77h9l8swsNiiOj4CLZjrl_jFBy4_DEm/view?usp=sharing) 
<img width="1083" height="652" alt="image" src="https://github.com/user-attachments/assets/d8711ddd-473e-4316-9542-4ce78c4dcc59" />


### Test1 - E2E Manual Testing Summary

[Click here to view/download the full E2E Testing Report & Summary]([https://drive.google.com/file/d/1enqC51quYm9jrQXN-RLd7kAvkiuWcCLb/view?usp=sharing](https://drive.google.com/file/d/1xbmxvMOjeuyBTCo_UiNEETREQYQ1GwvH/view?usp=sharing))
<img width="1451" height="482" alt="image" src="https://github.com/user-attachments/assets/affdb6ec-d4d6-4894-82f8-4d5b93c4ba63" />



### Test2 - JUnit Automation Testing Summary

[Click here to view/download the full JUnit Automation Testing Report & Summary](https://drive.google.com/file/d/1EAvdE0RuNw5F-Q_k2kUKj0SOO6EtxeQ7/view?usp=sharing)
<img width="1430" height="656" alt="image" src="https://github.com/user-attachments/assets/0e3a6ce3-24ee-4ba3-90e6-e8486c5f22a4" />




## 3. Requirement Traceability Matrix (Summary)

[Click here view/download the full RTM Summary](https://drive.google.com/file/d/1n77h9l8swsNiiOj4CLZjrl_jFBy4_DEm/view?usp=sharing) 

<img width="648" height="482" alt="image" src="https://github.com/user-attachments/assets/fb6a5ef3-a2dd-482d-9412-df52a75b1001" />
<img width="895" height="513" alt="image" src="https://github.com/user-attachments/assets/3889d754-18e6-4663-9da0-3e991a143eb1" />




## 4. Defect Analysis

**Most critical defects were related to synchronization issues in seat management**. Multiple tests confirmed that seat allocation states were not consistently updated between Business and Economy classes. **Another recurring issue was input validation failure in user prompts**, where the system failed to exit invalid input loops properly. These indicate the need for synchronization locks and centralized validation control.

## 5. Key Observations
<img width="851" height="308" alt="image" src="https://github.com/user-attachments/assets/a976e8b1-56b0-404a-9627-43a6e71999d3" />


## 6. Recommendations

- Implement synchronization locks in seat management.
- Centralize input validation to reduce redundant loops.
- Standardize console prompts for user consistency.
- Conduct regression tests after fixes are applied.

These actions aim to increase stability and maintain data integrity across seat and pricing modules.

## 7. Reflection

Through automating input validation loop tests, I learned **how automation can significantly reduce time and human error in repetitive QA tasks.** This process helped **identify infinite loop defects and inconsistent prompt handling more effectively than manual testing**. It reinforced my understanding that strategic automation not only improves testing efficiency but also enhances long-term system stability.

## How to Run Tests

```bash
# Clone the repository
git clone https://github.com/<your-username>/airline-ticketing-qasuite.git
cd airline-ticketing-qasuite

# Run all JUnit tests
mvn test

# Folder Structure
📁 JUnit/
│
├── src/
│   ├── com/cc/airline/passengers/
│   │   ├── FrequentFlyer.java
│   │   ├── Passenger.java
│   │   ├── PassengerName.java
│   │   └── StaffPassenger.java
│   │
│   ├── com/cc/airline/ticketing/
│   │   ├── Discountable.java
│   │   ├── Seat.java
│   │   ├── SeatingClass.java
│   │   ├── SeatingPlan.java
│   │   └── Ticket.java
│   │
│   ├── com/cc/airline/utilities/
│   │   ├── Manifest.java
│   │   ├── SeatReserver.java
│   │   └── UserPrompter.java
│   │
│   └── garam/yoon/airticket/requirements/tests/
│       ├── AirTicketTestSuite.java
│       ├── BusinessRowTest.java
│       ├── FrequentFlyerTest.java
│       ├── PassengerTypeTest.java
│       ├── SeatDuplicateAutoTest.java
│       ├── SeatingClassTest.java
│       ├── SeatingPlanTest.java
│       ├── SeatReserverAutoTest.java
│       └── SellTicketTest.java
│
├── META-INF/
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
└── README.md
```
