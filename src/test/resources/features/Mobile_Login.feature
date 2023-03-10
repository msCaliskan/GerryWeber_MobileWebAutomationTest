@smoke
Feature: Mobile | Login with valid and invalid credentials

  Background:

    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks login button

  Scenario: Login with valid credentials
    And The user enters valid credentials
    And The user clicks "Giriş Yap" buttonn
    And The user clicks login button
    And The user verifies redirected to "/tr-TR/account/info" page
    And The user checks "Musa", "Caliskan", "musainveonn@gmail.com" and "0507 500 29 20" informations
    Then The user clicks arrow button
    And The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/tr-TR?logout=true" page

  Scenario: The user must not be able to login with invalid email
    And The user enters invalid email for mobile
    And The user clicks "Giriş Yap" buttonn
    And The user verifies "E-posta adresiniz ve/veya şifreniz hatalıdır." message

  Scenario: The user must not be able to login with invalid password
    And The user enters invalid password for mobile
    And The user clicks "Giriş Yap" buttonn
    And The user verifies "E-posta adresiniz ve/veya şifreniz hatalıdır." message