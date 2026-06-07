Playwright + Java + JUnit 5 Automation Framework

**********
Overview
This project is a UI test automation framework built using Playwright and Java.
The framework follows Page Object Model (POM) principles and focuses on
        * maintainability,
        * reusability,
        * scalability, and
        * clean test design.

**********
Project Goals
* Playwright auto-waiting mechanism (no Thread.sleep usage)
* Improve framework maintainability
* Increase test stability
* Enable scalable test execution
* Support CI/CD integration

**********
Design Principles
* Page Object Model (POM)
* Single Responsibility Principle (SRP)
* Separation of Test Logic and Page Logic
* Reusable Component Design

**********
Technology Stack
* Java 17
* Playwright
* JUnit
* AssertJ
* Maven
* SLF4J + Logback
* Faker
* Allure Report
* GitHub Actions

**********
Why these tools?
* Playwright → fast, stable, modern UI automation
* AssertJ → readable assertions
* Faker → dynamic test data
* SLF4J + Logback → structured logging

**********
Framework Structure

src
├─ main
│  ├─ java
│  │  ├─ pages
│  │  │  └─ CreateAccountPage
│  │  │
│  │  └─ utils
│  │     └─ ConfigReader
│  │
│  └─ resources
│     ├─ config.properties
│     └─ logback.xml
│
└─ test
    └─ java
        ├─ base
        │  └─ PlaywrightBaseTest
        │  └─ TestListener
        │
        └─ tests
            ├─ FirstTest
            └─ SignUp


**********
Implemented Features
* Page Object Model (POM)
* Configuration management
* Logging with SLF4J & Logback
* Screenshot capture on failure
* Exception handling
* Smart waiting strategy
* Reusable utility classes
* Allure reporting

**********
Planned Improvements

Test Engine
* Retry mechanism
* Parallel execution

**********
Reporting
* Allure reporting
* Enhanced assertion strategy

**********
DevOps
* GitHub Actions CI pipeline
* Docker support

**********
Sample Test Scenario
1. Navigate to Sign Up page
2. Fill account information
3. Submit registration form
4. Verify successful account creation

## Setup
### Prerequisites
* Java 17 or higher
* Maven 3.9+
* Git

### Clone Repository
```bash
git clone https://github.com/fboncuk/Playwright_Project.git
cd Playwright_Project
```

### Install Dependencies
```bash
mvn clean install
```

### Browser Support
Tests run on Chromium browser by default using Playwright.


### Test Data Strategy
* Dynamic test data generation using Faker
* No hardcoded test data


### Run Tests
Run all tests:
```bash
mvn test
```

Run a specific test class:
```bash
mvn test -Dtest=SignUp
```

### Configuration
Test configuration values are stored in:
```text
src/main/resources/config.properties
```

Example:
```properties
baseUrl=https://www.bestbuy.com
```

### Logs
Framework logs are managed through SLF4J and Logback.
Configuration file:
```text
src/main/resources/logback.xml
```

### Screenshots
When a test fails, a screenshot is automatically captured by the TestListener and saved for debugging purposes.

