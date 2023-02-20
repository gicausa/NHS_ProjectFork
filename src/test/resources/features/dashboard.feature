@dashboard
Feature: Testing the dashboard display characteristics

  Background:
    Given User navigates to NHS app site
    When User enters username 'admin' and password 'admin'
    Then User validates the page title is 'NHS patients'

  Scenario: Validating the number of cards on Dashboard page
    Then User validates the number of cards is 3

  Scenario: Validating the text on the cards
    Then User validates the text on the cards
    | Patients with rooms |
    | Patients waiting    |
    | Free rooms          |

  Scenario: Validating the color of the cards
    Then User validates the color of the cards
    | rgba(51, 122, 183, 1) |
    | rgba(217, 83, 79, 1)  |
    | rgba(232, 145, 6, 1)  |

  Scenario: Validating the number on the cards
    Then User validates the numbers on the cards






