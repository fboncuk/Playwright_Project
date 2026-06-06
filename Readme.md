Playwright + Java + TestNG Automation Framework

**********
Overview
This project is a UI test automation framework built using Playwright and Java.
The framework follows Page Object Model (POM) principles and focuses on
        * maintainability,
        * reusability,
        * scalability, and
        * clean test design.

**********
Technology Stack
* Java 17
* Playwright
* JUnit
* Maven
* SLF4J + Logback
* Faker
* Allure Report
* GitHub Actions (planned)

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
* BasePage and BaseTest architecture
* Smart waiting strategy
* Reusable utility classes

**********
Planned Improvements

Test Engine
* Faker integration
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
Project Goals
* Eliminate Thread.sleep usage
* Improve framework maintainability
* Increase test stability
* Enable scalable test execution
* Support CI/CD integration

**********
Sample Test Scenario
1. Navigate to Sign Up page
2. Fill account information
3. Submit registration form
4. Verify successful account creation


