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

## Folder Structure
```bash
📁 airline-ticketing-qasuite/
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
