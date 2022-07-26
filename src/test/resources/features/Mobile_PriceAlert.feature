Feature: Mobile | Price Alert
  @smoke
  Scenario: The user can select to PriceAlert and delete

    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks login button
    And The user enters valid credentials for mobile
    And The user clicks "Giriş Yap" buttonn
    And The user clicks hamburger menu button
    And The user navigates to "GİYİM" category
    Then The user verifies redirected to "/tr-TR/giyim" page
    And The user clicks anyone product
    Then The user clicks fiyat button
    And The user enters valid price
    Then The user clicks "Kaydet" button
    And The user verifies "İlgili ürün indirime girdiğinde sizleri bilgilendireceğiz. İlginiz için teşekkürler." message
    And The user closes popUps
    And The user clicks login button
    Then The user clicks arrow button
    Then The user clicks "Fiyat Alarmı" button
    And The user verifies redirected to "/tr-TR/account/price-subscription" page
    When The user clicks "Listeden Çıkar" button
    And The user verifies "Fiyat alarmınız bulunmamaktadır." message
    And The user clicks arrow button
    Then The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/tr-TR?logout=true" page