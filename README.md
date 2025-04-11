# Level Supermind Automation : Android
the Level SuperMind app, organized by functional areas like onboarding, login, meditation sessions, user profile, subscription, and more.
##  Project Overview
Note Master is website that Project Overview the Level SuperMind app, organized by functional areas like onboarding, login, meditation sessions, user profile, subscription, and more.e. The Level supermind app This test plan outlines the testing approach, scope, objectives, test scenarios, test cases, and defect management for the Note Master Website, a collaborative writing platform. The primary focus is to validate UI, functionality, navigation, security, and performance to ensure all features work as expected.


This project focuses on **manual testing** of key modules within the Level supermind. The testing process involves verifying core functionalities, UI/UX aspects and system responses.

---

##  **Scope of Testing**
The **manual testing** process covers the following key modules:

###  **1. Dashboard Homepage**
 Verifying navigation, UI elements, and data consistency.  
 Ensuring dashboard statistics update correctly.  

###  **2. Plans**
 Checking if different plans are displayed with accurate details.  
 Validating selection and redirection functionalities.  

###  **3. Create Story**
 Creating story With adding the summary and details uploading files and create the story.  



---

##  **Testing Approach**
This project follows a **structured manual testing** approach, including:

###  **1. Functional Testing**
- Ensuring each feature works as expected.
- Validating system behaviors under different conditions.

###  **2. UI/UX Testing**
- Checking design consistency and responsiveness.
- Ensuring proper alignment and usability.

###  **3. Boundary Value Analysis**
- Testing input fields with minimum and maximum values.
- Ensuring correct error messages are displayed.

###  **4. Error Handling Testing**
- Checking how the system responds to invalid inputs.
- Verifying failure scenarios like incorrect login credentials Create story.

---


##  **Test Documents**
The following **test Documents** document the manual testing process:

###  **1. Test Plan**
- **Objectives:** 
- **Scope:** 
- **Testing Approach:** 
- **Test Environment:** 
- **Test Deliverables:** 
- **Risks & Mitigation:** 

###  **2. Test Scenario**
- **Test Scenario ID**
- **Module**
- **Test Scenario Description**
  
###  **2. Test Cases**
Each module has structured test cases, including:
- **Test Case ID**
- **Test Case Description**
- **Pre-Conditions** 
- **Test Steps**
- **Test Data**
- **Expected & Actual Results**
- **Status (Pass/Fail)**

###  **3. Bug Report**
- **Bug ID**
- **Description**
- **Steps to Reproduce**
- **Expected & Actual Results**
- **Severity & Priority**
- **Screenshots**


###  **5. Test Summary Report**
- **Summary of Test Execution**
- **Pass/Fail**




##  **Agile Methodology in Testing**
This testing process follows an **Agile Methodology** to ensure continuous and iterative testing:

 **Sprint-based Testing** – Dividing testing activities into multiple sprints.  
 **Daily Stand-up Meetings** – Discussing test progress, blockers, and solutions.  
 **Collaboration with Developers** – Continuous integration with the development team.  
 **Frequent Builds & Releases** – Ensuring testing is performed on updated builds.  
 **Exploratory Testing** – Conducting ad-hoc testing to uncover hidden defects.  

 **Documents Drive link**
 https://drive.google.com/drive/folders/1GJwZX_girwMiTizwxBinlNOFAvK7Dwky?usp=sharing 
 
 **Explaination Video link**
https://drive.google.com/drive/folders/1GJwZX_girwMiTizwxBinlNOFAvK7Dwky?usp=sharing


Appium-Selenium-TestNG Framework with POM structure
Table of Contents
Prerequisites
Installation
Folder Structure
Running Tests
Approach Taken
Challenges
## Prerequisites
Before you begin, ensure you have met the following requirements:

Java 8+
Maven
Appium 2.x
Android Studio
UiAutomator2 driver
Your Android device should connected to system
Any IDE (VS Code, Eclipse, etc.)
Installation


  cd android
Install the required dependencies:
  [cmd] mvn clean
## Folder Structure
~~~
  LevelSupermind_project/
  |
  |   ├── src/
  |   |   ├── main
          |   ├── java
              |   ├── config (initialize AndroidDriver with capabilities and all pages)
              ├── utils
                      ├── TouchActionApi      (utility methods
                      |
              ├── resources
                  ├── properties  (Setup driver capabilities & login email/phone)
 |   ├── src/
  |   |   ├── test
          |   ├── java     
                  ├── demo
                         ├── firstTest
                          ├── LoginTest
      ├── pom.xml (added all required dependencies & plugins)
      ├── README.md
  ~~~ 
## Running Tests
To run the tests, use the following maven commands:

  Open - src/test/resources/Properties/global.properties

  update with your connected device : 
  - platformVersion 
  - deviceName
  - userEmail ( valid / invalid )
  - userPhone ( valid / invalid )
1. To verify - Login functionality with Email

  [cmd] mvn test -P login-with-email
2. To verify - Login functionality with Phone

  [cmd] mvn test -P login-with-phone
## Approach Taken
## 1. Driver Initialization:
Centralized AndroidDriver initialization in the base package with customizable capabilities.
Capability settings stored in properties files for easy configuration changes without modifying code.
## 2. Test Design:
Used POM for structuring page-specific locators and methods, ensuring modular and reusable code.
Divided test cases into separate test classes for different login methods, making the framework scalable for future enhancements.
## 3. Utility Layer:
Encapsulated reusable methods for screenshot capturing, OTP handling, and UI interactions.
Notifications utility handles runtime OTP extraction, ensuring smooth test execution for login flows requiring OTP.
## 4. Handling positive/negative cases for email/phone inputs
Created validateInput() method in [pages.LoginPage] to handle valid/invalid inputs & log appropriate error messages
Handle mobile number format validation only for India
Positive Test : 
> accepts valid email/phone input
Negative Tests : 
> Blank input [""]  (show error message)
> Whitespace contains ["     "]  (show error message)
> Invalid inputs (show error message)
  Emails: @test@gmail.com
          gmail.com
          12345
          test 12@gmail.com

  Phone: (+91) 823712
         (+91) 2456987130

> Accept invalid inputs
  Emails: 12345@gmail.com
          nehabam945@pariag.com
          nehabam945@pariag.com

  Phone: (+91) 1236547890
         (+91) 5632147089
## 6. Test Execution:
TestNG XML files facilitate executing specific test suites (email/phone login).
7. Modular and Scalable Design:
Clear separation of concerns with dedicated folders for base setup, pages, utilities, and tests.

## Challenges
- Learn Appium in less time & use it practically 

- Appium flaky nature

- Handling toast alert

- Dynamic OTP handling

- Slow test execution
