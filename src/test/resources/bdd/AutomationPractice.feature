@AutomationPractice
Feature: Automation practice project using Selenium Cucumber and Maven
  I want to demonstrate the ability to automate web applications testing using this project.

  @OrderTShirt
  Scenario: User orders a new T shirt and validates in order history
    #Given automation practice website is up and running
    When user logs in by entering below credentials
    | username             | password   |
    | kishork163@gmail.com | Kishor@123 |
    And user navigates to TShirts section
    And user adds item "Faded Short Sleeve T-shirts" to the cart
    And user proceeds to checkout
    And user selects payment method as "Pay by bank wire"
    And user confirms the order
    And user saves order reference in "$OrderReference"
    And user navigates back to orders
    And user validates that order "$OrderReference" is present in order history     
    

  @UpdatePersonalInformation
  Scenario: User updates personal information in My Account
    #Given automation practice website is up and running
    When user logs in by entering below credentials
    | username             | password   |
    | kishork163@gmail.com | Kishor@123 |
    When user navigates to my account
    And user updates first name as "Ravi" using password "Kishor@123"
    Then validate account name is "Ravi Kumar"
