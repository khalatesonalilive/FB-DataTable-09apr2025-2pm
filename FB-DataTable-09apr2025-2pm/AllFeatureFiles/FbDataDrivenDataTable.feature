Feature: Test Facebook Application

@Regression
  Scenario: Test Register Page Functionality
    Given user is on register page
    When user enter valid firstname, lastname , username and password
      | Sonali | Khalate | khalatesonali@gmail.com | khalatesonali@123 |
    And user select valid DOB
      | 14 | Mar | 2024 |
    And user select the gender
      | gender |
      | Female |
