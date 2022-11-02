Feature: Mobile | Order Tracking feature

  @wip
  Scenario: Order tracking with informations

    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks hamburger menu button
    And The user clicks "Sipariş Takip" button
    And The user verifies redirected to "/tr-TR/order-tracking" page
    And The user enters informations
    And The user clicks "Sorgula" button
    And The user verifies "Sipariş kaydı bulunamadı." message

#    Mobil görünümde Sipariş Takip butonu olmadığı için beklemeye alındı, Zeynep'e chatten yazıldı