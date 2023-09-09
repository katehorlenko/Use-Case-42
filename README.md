All technologies

Web Automation: The framework should be capable of automating browser-based applications. It should support 
the Chrome browser.

WebDriver Singleton Pattern: The framework should have a singleton implementation of WebDriver to ensure that only 
a single instance of WebDriver is created and utilized for test execution.

Thread Safe WebDriver: The framework should support the use of ThreadLocal WebDriver to ensure thread-safety 
when running tests in parallel. Each test thread should have its own isolated WebDriver instance.

Page Object Model: The framework should support the Page Object Model design pattern, which should promote better code 
organization and reduce code duplication. 
Each page of the web application should be represented by a separate Java class.

Reporting: The framework should integrate with Allure Reports or generate comprehensive HTML test execution reports.

TestNG Integration: The framework should integrate with TestNG to allow the creation of test suites, test cases,
and test methods.

Maven Integration: The framework should use Maven for project build and dependency management.

Parallel Execution: The framework should support the execution of tests in parallel on multiple threads,
using TestNG parallel execution capability.

Logger Implementation: The framework should have a utility for logging, using Log4j 2. It should log all necessary
information during test execution for better debugging and understanding of the test flow.

Automated Setup of WebDriver binaries: The framework should use WebDriverManager for automatic setup and management
of WebDriver binaries.

Framework should have 3 automated tests, which are provided in the next section. 