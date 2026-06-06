


Tool Stack (Senior expectation)
-------------------------------
Java 17
Playwright
JUnit 5
Maven
SLF4J + Logback
Faker
Allure
GitHub Actions
(optional) Docker



Senior Proje Dönüşüm Planı

1. CORE (zorunlu foundation)
- Thread.sleep kaldırma + smart wait  (DONE)
- Config management                   (DONE)
- Logging (SLF4J + Logback)           (DONE)  
- Exception handling + screenshot on failure
- BasePage + BaseTest cleanup

2. TEST ENGINE IMPROVEMENT
- Faker                              (DONE)
- Retry mechanism
- Parallel execution

3. REPORTING & VISIBILITY
- Allure reporting
- Better assertions strategy

4. DEVOPS LEVEL
- GitHub Actions
- Docker (optional, en son)





Playwright_Framework
src
├─ main
│  ├─ java
│  │  ├─ core
│  │  │   ├─ DriverFactory
│  │  │   ├─ PlaywrightContext
│  │  │   └─ BasePage
│  │  │
│  │  ├─ pages
│  │  │   ├─ HomePage
│  │  │   ├─ CreateAccountPage
│  │  │   └─ LoginPage
│  │  │
│  │  ├─ utils
│  │  │   ├─ ConfigReader
│  │  │   ├─ FakerUtil
│  │  │   ├─ ScreenshotUtil
│  │  │   └─ WaitUtil
│  │  │
│  │  ├─ config
│  │  │   ├─ Environment
│  │  │   └─ TestConfig
│  │  │
│  │  ├─ models
│  │  │   └─ User
│  │  │
│  │  └─ listeners
│  │      └─ TestListener
│
├─ test
│  ├─ java
│  │  ├─ base
│  │  │   └─ BaseTest
│  │  │
│  │  ├─ tests
│  │  │   ├─ smoke
│  │  │   ├─ regression
│  │  │   └─ e2e
│  │  │
│  │  └─ runner
│  │      └─ TestSuiteRunner
│
└─ resources
    ├─ config.properties
    ├─ logback.xml
    ├─ allure.properties
    └─ testdata.json

