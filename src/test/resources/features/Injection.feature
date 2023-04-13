Feature: Login Admin Test (Injection and broken access control)
  As a functional

  Scenario: Attempt login with injection, Access the administration page and Deleting customer feedback
    Given I am on the login page "http://20.208.138.194:3000/"
    When I enter the email "' OR TRUE --" and password "password"
    And I click on the login button
    Then I can navigate to the administration page "http://20.208.138.194:3000/#/administration"
    And the Admin Content is displayed
    Then I attempt to delete the a customer feedback
    And the customer feedback is successfully deleted
