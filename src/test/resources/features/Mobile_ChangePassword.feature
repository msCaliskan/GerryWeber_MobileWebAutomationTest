@smoke
Feature: Mobile | Change password of the account

  Background:
    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks login button
    And The user enters valid credentials
    And The user clicks "Giriş Yap" buttonn
    And The user clicks login button
    Then The user clicks arrow button
    And The user clicks "Şifre Değiştir" button
    And The user verifies redirected to "/tr-TR/account/change-password" page

  Scenario: Change password of the current customer

    And The user enters old, new and confirm new password
    And The user clicks "Bilgilerimi Kaydet" button
    Then The user verifies "Şifreniz başarıyla değiştirilmiştir." message
    When The user clicks arrow button
    And The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/tr-TR?logout=true" page

  Scenario: The user enters wrong old password

    And The user enters wrong old password
    And The user clicks "Bilgilerimi Kaydet" button
    Then The user verifies "Girmiş olduğunuz parola eski parola ile uyuşmamaktadır." message
    When The user clicks arrow button
    And The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/tr-TR?logout=true" page

  Scenario: The user enters different new and confirm new passwords

    And The user enters different passwords
    And The user clicks "Bilgilerimi Kaydet" button
    Then The user verifies "Girilen şifreler birbiriyle aynı olmalıdır." message
    When The user clicks arrow button
    And The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/tr-TR?logout=true" page