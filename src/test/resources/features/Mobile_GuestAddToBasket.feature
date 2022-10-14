Feature: Mobile | Guest add to basket

  @smoke
  Scenario:Guest add to basket and delete product from basket

    And The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks hamburger menu button
    And The user navigates to "GİYİM" category
    Then The user verifies redirected to "/tr-TR/giyim" page
    And The user clicks anyone product
    Then The user clicks "Beden Seçiniz" button
    And The user chooses color and size
    And The user clicks "Sepete Git" button
    And The user verifies redirected to "/tr-TR/basket" page
    When The user clicks "Sepeti Onayla" button
    When The user clicks "Üye Olmadan Devam Et" button
    And The user verifies redirected to "/tr-TR/checkout/payment" page
    When The user enters valid informations for guest
    And The user clicks "Adresi Kaydet" button
    When The user clicks "Ödemeye Geç" button
    And The user enters invalid informations
    And The user selects On Bilgilendirme and Mesafeli Satis Sozlesmesi buttons
    And The user clicks "Siparişi Tamamla" button
    And The user verifies "Kart numarası geçersizdir" message
    Then The user clicks Back button
    Then The user clicks basket button
    And The user clicks "Sepete Git" button
    And The user clicks Sil button
