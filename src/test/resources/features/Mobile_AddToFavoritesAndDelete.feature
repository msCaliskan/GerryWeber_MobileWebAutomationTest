Feature: Mobile | Add to favorites and delete
  @smoke
  Scenario: The user can add to favorites and delete

    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks login button
    And The user enters valid credentials for mobile
    And The user clicks "Giriş Yap" buttonn
    And The user clicks hamburger menu button
    And The user navigates to "Giyim" category
    Then The user verifies redirected to "/giyim" page
    And The user clicks anyone product
    And The user clicks Favorilere Ekle button
    And The user closes popUps
    And The user clicks login button
    Then The user clicks arrow button
    And The user clicks "Favori Listem" button
    And The user verifies redirected to "/account/favorites" page
    When The user clicks "Listeden Çıkar" button
    And The user verifies " Favori listenizde ürün bulunmamaktadır." message
    And The user clicks arrow button
    Then The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/tr-TR" page