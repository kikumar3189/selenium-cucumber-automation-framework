# selenium-automation-practice

Author: kishork163@gmail.com

Description: A learning project to learn web automation using Selenium. This includes writing scenarios following Behavior driven methodology using Cucumber.

Note: This project has been created using:

Java: 1.8

Maven: 3.6

Chrome: Version 79.0.3945.130 (Official Build) (64-bit)

OS: Windows 8.1

Instructions to run tests:
1. Launch a command prompt. 
2. Execute command git clone <repo> OR download the zip from <>
3. Simply execute command : mvn clean test 
4. This will start executing scenarios by using chrome browser.
5. Two scenarios will be executed: Order T Shirt and Update first Name.
6. On Test completion, open file target/index.html in a browser to view test results.
7. This project also includes support to run the tests in headless mode, simply pass a maven command line property mvn clean -Dheadless=true test . Please note that this has not been tested properly due to time crunch.
  
Possible Enhancements:
1. More browsers support can be added to DriverFactory class and a browser can be selected at run time by passing a mvn command line property like mvn -Dbrowser=IE test.

2. All application objects can be separated from code and managed in a central ObjectRepository(an XML file for example). This will help non technical team members to add/update application objects in project.

3. A variables file can be created storing the variables which needs to be reused in multiple tests. Variables can be General or feature specific. This will allow all static test data values to be managed at a single location. E.g. If username is used in multiple features them having it stored in central location will ease maintenance of tests. All features should refer to username from variables file.

