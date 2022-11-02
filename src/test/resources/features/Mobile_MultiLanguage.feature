Feature: Mobile | Multi Language

  @smoke
  Scenario: User checks category names and header names and login

    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    Then The user clicks hamburger menu button
    And The user clicks "Türkçe" button
    And The user clicks "English" button
    Then The user verifies redirected to "/en-US" page
    And The user verifies categories
      | NEW            |
      | CLOTHING       |
      | SUSTAINABILITY |
      | INSPIRATION    |
      | BRANDS         |
    And The user clicks "Close" button
    And The user verifies footer menu names
      | Institutional     |
      | Help              |
      | Customer Services |
      | Payment Method    |
      | Etbis             |

    And The user clicks login button
    And The user enters valid credentials
    And The user clicks "Login" buttonn
    And The user clicks login button
    And The user verifies redirected to "/en-US/account/info" page
    And The user checks "Musa", "Caliskan", "musainveonn@gmail.com" and "0507 500 29 20" informations
    Then The user clicks arrow button
    And The user clicks "Log Out" button
    And The user verifies redirected to "/en-US?logout=true" page