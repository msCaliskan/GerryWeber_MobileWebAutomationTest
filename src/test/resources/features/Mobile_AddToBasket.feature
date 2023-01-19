Feature: Mobile | Add to basket

 @smoke1
  Scenario:Add to basket and delete product from basket

  Given The user visits GerryWeber homepage
  And The user verifies redirected to homepage
  And The user clicks login button
  And The user enters valid credentials
  And The user clicks "Giriş Yap" buttonn
  And The user clicks hamburger menu button
  And The user navigates to "GİYİM" category
  Then The user verifies redirected to "/tr-TR/giyim" page
  And The user clicks any product
  Then The user clicks "Beden Seçiniz" button
  And The user chooses size
  And The user clicks "Sepete Git" button
  And The user verifies redirected to "/tr-TR/basket" page
  When The user clicks "Sepeti Onayla" button
  And The user verifies redirected to "/tr-TR/checkout/payment" page
  When The user enters valid informations
  And The user clicks "Adresi Kaydet" button
  When The user clicks "Ödemeye Geç" button
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
  And The user verifies redirected to "/tr-TR?logout=true" page
