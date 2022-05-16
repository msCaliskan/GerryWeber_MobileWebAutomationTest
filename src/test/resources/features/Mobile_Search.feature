Feature: Mobile | Search User searchs for a product

  @smoke
  Scenario: User searchs for a product

    And The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user fills "Etek" in the searchbox and click
    And The user verifies redirected to "/tr-TR/tum-urunler?searchValue=Etek" page
    Then The user should see all search results match with "Etek"


