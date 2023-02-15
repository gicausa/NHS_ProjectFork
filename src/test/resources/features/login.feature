@login
Feature: Testing the login functionality on NHS app

  Scenario: Testing successful login

    Given User navigates to NHS app site
    When User enters username 'admin' and password 'admin'
    Then User validates the page title is 'NHS patients'







