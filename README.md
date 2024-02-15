# Test Automation Framework

## Description

This project implements a Hybrid Test Automation Framework with an Object-Oriented Design. The framework incorporates both modular and data-driven approaches to facilitate reusable test methods and external test data storage. It utilizes TestNG for test execution, ExtentReports for detailed execution reports, and Selenium WebDriver for browser automation.

## Tools

- IDE (Eclipse)
- Selenium WebDriver + Java
- Webdriver manager
- Extent Reports
- TestNG
- Maven

## Features

- **Modular Design**: Automation scripts are organized into modular components, promoting code reusability and maintainability.
- **Data-Driven Testing**: Test data is stored in an external Excel file, allowing for easy modification and management of test scenarios.
- **Cross-Browser Support**: The framework supports cross-browser testing with Edge, Chrome, and Firefox.
- **Execution Report**: Detailed execution reports are generated using ExtentReports, providing insights into test execution status and failures.
- **Clean Code**: Codebase follows best practices for clean and maintainable code, enhancing readability and scalability.

## How It Works

The framework consists of the following components:

1. **BaseTest**: BaseTest class contains setup and teardown methods for WebDriver initialization and closing.
2. **Pages**: Pages package contains Page Object Model (POM) classes representing web pages. Each page class encapsulates locators and methods related to specific page functionalities.
3. **Utilities**: Utilities package includes utility classes for common functionalities such as ExtentManager for report generation and TestUtils for taking screenshots.
4. **TestCase**: TestCase package contains test classes written using TestNG annotations for verifying different functionalities of the application.

## Usage

1. Clone the repository.
2. Import the project into your preferred IDE.
3. Run pom.xml file to load dependencies.
4. Set the browser to be used in test execution in the config file.
5. Run the test suite file using TestNG for test execution.
6. View the execution report generated in the `src/test/resources/reports` directory.

## Self-Evaluation

| Evaluation Criteria                      | Evaluation Score |
| ---------------------------------------- | ---------------- |
| Script is Modular                        | Done             |
| All Dependencies are on Maven            | Done             |
| Test Data are in External Files          | Done             |
| Execution Browser is managed by the user | Done             |
| Browser Support – Edge                   | Done             |
| Browser Support – CH                     | Done             |
| Browser Support – FF                     | Done             |
| Junit/TestNG Tests                       | Done             |
| Execution Report                         | Done             |
| All Test Scenario Steps are covered      | Done             |
| Solution Description and documentation   | Done             |
| Extra 1: Selenium Grid Support           | Not Done         |
| Extra 2: Keyword-driven Framework        | Not Done         |

## Limitations

- Selenium Grid Support and Keyword-driven Framework are not implemented in the current version of the framework (They'll be added soon).
