@AutomationPractice
Feature: Automation practice project using Selenium Cucumber and Maven
  I want to demonstrate the ability to automate web applications testing using this project.
  
  @Login
  Scenario: User logs-in to online store
  When user navigates to "Login" page
  And clicks "signIn" button
  And enters "username" as "kishork163@gmail.com"
  And enters "password" as "Kishor@123"
  And clicks "submit" button
  Then user navigates to "Home" page
  Then "accountName" should be displayed as "Ravi Kumar"

  @UpdatePersonalInformation
  Scenario: User updates personal information in My Account
    #Given automation practice website is up and running
    When user navigates to "Home" page
  	And clicks "accountName" button
  	Then user navigates to "myAccount" page
  	And clicks "personalInformation" button
  	And enters "firstName" as "Ravi"
  	And enters "currentPassword" as "Kishor@123"
  	And clicks "save" button
  	Then "accountName" should be displayed as "Ravi Kumar"
  	
    #When user navigates to my account
    #And user updates first name as "Kishor" using password "Kishor@123"
    #Then validate account name is "Kishor Kumar"
  
  
  #@OrderTShirt
  #Scenario: User orders a new T shirt and validates in order history
    #Given automation practice website is up and running
    #When user logs in by entering below credentials
    #| username             | password   |
    #| kishork163@gmail.com | Kishor@123 |
    #And user navigates to TShirts section
    #And user adds item "Faded Short Sleeve T-shirts" to the cart
    #And user proceeds to checkout
    #And user selects payment method as "Pay by bank wire"
    #And user confirms the order
    #And user saves order reference in "$OrderReference"
    #And user navigates back to orders
    #And user validates that order "$OrderReference" is present in order history     
    

  