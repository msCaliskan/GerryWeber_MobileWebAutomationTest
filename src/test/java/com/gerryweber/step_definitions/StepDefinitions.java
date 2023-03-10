package com.gerryweber.step_definitions;

import com.gerryweber.pages.*;
import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class StepDefinitions {

    AccountPage accountPage = new AccountPage();
    AddressPage addressPage = new AddressPage();
    CategoryAndProductPage categoryAndProductPage = new CategoryAndProductPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    
    @Given("The user visits GerryWeber homepage")
    public void the_user_visits_GerryWeber_homepage() {
        homePage.gotoHomePage();
    }

    @And("The user verifies redirected to homepage")
    public void the_user_verifies_redirected_to_homepage() {
        HomePage.checkHomePage();
    }

    @When("The user clicks login button")
    public void the_user_clicks_login_button() {
        homePage.clickLogin();
    }

    @And("The user enters invalid email for mobile")
    public void theUserEntersInvalidEmailForMobile() {
        loginPage.invalidEmailMobile();
    }

    @And("The user enters invalid password for mobile")
    public void theUserEntersInvalidPasswordForMobile() {
        loginPage.invalidPasswordMobile();
    }

    @Given("The user clicks hamburger menu button")
    public void the_user_clicks_hamburger_menu_button() {
        homePage.clickHamburgerMenu();
    }

    @When("The user verifies redirected to {string} page")
    public void the_user_verifies_redirected_to_page(String expUrl) {
        BasePage.verifyUrl(expUrl);
    }

    @When("The user checks {string}, {string}, {string} and {string} informations")
    public void the_user_checks_and_informations(String name, String lastName, String email, String phone) {
        accountPage.getInformation(name, lastName, email, phone);
    }

    @When("The user clicks arrow button")
    public void the_user_clicks_arrow_button() {
        accountPage.arrowBtn_Loc.click();
    }

    @When("The user clicks {string} button")
    public void the_user_clicks_button(String button) {
        BasePage.clickButton(button);
    }

    @And("The user clicks {string} buttonn")
    public void theUserClicksButtonn(String str) {
        BasePage.clickButton2(str);
    }

    @When("The user enters old, new and confirm new password")
    public void the_user_enters_old_new_and_confirm_new_password() {
        changePasswordPage.changePassword();
    }

    @When("The user enters valid informations")
    public void the_user_enters_valid_informations() {
        addressPage.enterAdress();
    }

    @When("The user enters valid informations for guest")
    public void theUserEntersValidInformationsForGuest() {
        checkoutPage.enterGuestAdress();
    }

    @When("The user clicks any product")
    public void the_user_clicks_any_product() {
        categoryAndProductPage.clickProductRandom();
    }

    @When("The user verifies {string} message")
    public void the_user_verifies_message(String message) {
        Assert.assertEquals(message.trim(), BasePage.verifyMessage(message));
    }

    @When("The user verifies {string} messagee")
    public void the_user_verifies_messagee(String message) {
        Assert.assertEquals(message.trim(), BasePage.verifyMessagee(message));
    }

    @When("The user enters invalid informations")
    public void the_user_enters_invalid_informations() {
        checkoutPage.invalidCard();
    }

    @Then("The user clicks Back button")
    public void the_user_clicks_Back_button() {
     checkoutPage.backToBasket();
    }

    @Then("The user enters forget password email address")
    public void the_user_enters_forget_password_email_address() {
        homePage.email_Loc.sendKeys(ConfigurationReader.get("user_email"));
    }

    @Given("The user fills {string} in the searchbox and click")
    public void the_user_fills_in_the_searchbox_and_click(String string) {
        homePage.searchBox(string);
    }

    @Then("The user should see all search results match with {string}")
    public void the_user_should_see_all_search_results_match_with(String string) {
        categoryAndProductPage.searchResult(string);
    }

    @And("The user enters valid credentials")
    public void theUserEntersValidCredentials() {
        loginPage.mobilLogin();
    }

    @When("The user selects On Bilgilendirme and Mesafeli Satis Sozlesmesi buttons")
    public void the_user_selects_On_Bilgilendirme_and_Mesafeli_Satis_Sozlesmesi_buttons() {
        checkoutPage.checkBox();
    }

    @And("The user navigates to {string} category")
    public void theUserNavigatesToCategory(String category) {
        CategoryAndProductPage.navigateMobile(category);
    }

    @And("The user closes popUps")
    public void theUserClosesPopUps() {
        categoryAndProductPage.closePopUps();
    }

    @And("The user chooses size")
    public void theUserChoosesSize() {
        categoryAndProductPage.selectSize();
    }

    @And("The user clicks Sil button")
    public void theUserClicksSilButton() {
        checkoutPage.delete();
    }

    @And("The user enters wrong old password")
    public void theUserEntersWrongOldPassword() {
        changePasswordPage.wrongOldPassword();
    }

    @And("The user enters different passwords")
    public void theUserEntersDifferentPasswords() {
        changePasswordPage.differentPassword();
    }

    @And("The user clicks Favorilere Ekle button")
    public void theUserClicksFavorilereEkleButton() {
        BrowserUtils.clickWithJS(categoryAndProductPage.favoriBtn_Loc);
    }

    @And("The user enters valid price")
    public void theUserEntersValidPrice() {
        categoryAndProductPage.validPrice();
    }

    @Then("The user clicks fiyat button")
    public void theUserClicksFiyatButton() {
        categoryAndProductPage.clickFiyatButton();
    }

    @Then("The user clicks basket button")
    public void theUserClicksBasketButton() {
        checkoutPage.clickBasketButton();
    }

    @And("The user verifies categories")
    public void theUserVerifiesCategories(List<String> categorieList) {
        homePage.checkCategories(categorieList);
    }

    @And("The user clicks {string} and verifies {string}")
    public void theUserClicksAndVerifies(String button, String title) {
        homePage.checkPageTitle(button,title);
    }

    @And("The user verifies footer menu names")
    public void theUserVerifiesFooterMenuNames(List<String> footerMenuNames) {
        homePage.checkFooterNames(footerMenuNames);
    }

    @And("The user clicks Instagram button")
    public void theUserClicksInstagramButton() {
        homePage.clickInstagramButton();
    }

    @And("The user verifies redirected to Instagram page")
    public void theUserVerifiesRedirectedToInstagramPage() {
        homePage.verifyInstagramPage();
    }

    @And("The user clicks Facebook button")
    public void theUserClicksFacebookButton() {
        homePage.clickFacebookButton();
    }

    @And("The user verifies redirected to Facebook page")
    public void theUserVerifiesRedirectedToFacebookPage() {
        homePage.verifyFacebookPage();
    }

    @And("The user clicks submit button")
    public void theUserClicksSubmitButton() {
        homePage.clickNewsLetterButton();
    }

    @And("The user clicks Confirm Privacy Policy button")
    public void theUserClicksConfirmPrivacyPolicyButton() {
        homePage.clickConfirmButton();
    }

    @And("The user enters invalid emails")
    public void theUserEntersInvalidEmails() {
        homePage.sendInvalidEmail();
    }

    @And("The user enters valid emails")
    public void theUserEntersValidEmails() {
        homePage.sendValidEmail();
    }
}
