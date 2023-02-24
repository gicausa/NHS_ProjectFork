@dashboardTables
  Feature: Testing the tables on dashboard page

    Background:
      Given User navigates to NHS app site
      When User enters username 'admin' and password 'admin'
      Then User validates the page title is 'NHS patients'

    # user story 3, US_003_T4-9 Dashboard Page Tables Header

    @NA-33
    Scenario: Validating the number of tables on Dashboard page
      Then User validates the number of tables is 3

    @NA-33
    Scenario: Validating the headers of PATIENTS WITH ROOMS table
      Then User validates the table headers
      |no.                |
      |Patients with rooms|
      |Room               |
      |Score              |