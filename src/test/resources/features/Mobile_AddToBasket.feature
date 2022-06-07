Feature: Mobile | Add to basket

 @smoke
  Scenario:Add to basket and delete product from basket

  Given The user visits GerryWeber homepage
  And The user verifies redirected to homepage
  And The user clicks login button
  And The user enters valid credentials for mobile
  And The user clicks "Giriş Yap" buttonn
  And The user clicks hamburger menu button
  And The user navigates to "Giyim" category
  Then The user verifies redirected to "/giyim" page
  And The user clicks anyone product
  Then The user clicks "Beden Seçiniz" button
  And The user chooses color and size
  And The user clicks "Sepete Git" button
  And The user verifies redirected to "/basket" page
  When The user clicks "Sonraki Adım" button
  And The user verifies redirected to "/tr-TR/checkout/payment" page
  When The user enters valid informations
  And The user clicks "Adresi Kaydet" button
  When The user clicks "Sonraki Adım" button
  And The user enters invalid informations
  And The user selects On Bilgilendirme and Mesafeli Satis Sozlesmesi buttons
  And The user clicks "Siparişi Tamamla" button
  And The user verifies "Kart numarası geçersizdir" message
  Then The user clicks Back button
  And The user clicks Sil button
  And The user verifies "Alışveriş sepetiniz boş!" message
  And The user clicks login button
  And The user clicks arrow button
  And The user clicks "Adreslerim" button
  And The user clicks "Sil" button
  And The user verifies "Kayıtlı adresiniz bulunmamaktadır." message
  And The user clicks arrow button
  Then The user clicks "Çıkış Yap" button
  And The user verifies redirected to "/tr-TR" page
