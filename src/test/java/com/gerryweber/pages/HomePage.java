package com.gerryweber.pages;

import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.ConfigurationReader;
import com.gerryweber.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends BasePage{

    @FindBy(xpath = "(//*[@class='MuiBox-root muirtl-k008qs'])[2]") public WebElement loginBtn_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(xpath = "(//*[@class='MuiBox-root muirtl-k008qs'])[1]") public WebElement hamburgerMenuBtn_Loc;

    @FindBy(css = "#mui-1") public WebElement searchBox_Loc;

    @FindBy(xpath = "//*[contains(@class, 'MuiButtonBase-root MuiButton-root')]//*[contains(@class, 'MuiTypography-root MuiTypography-body3')]") public List<WebElement> categoriesList_Loc;

    @FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-h3 muirtl-14hb52n']") public List<WebElement> footerMenuNames_Loc;

    @FindBy(xpath = "//*[text()='Kurumsal']") public WebElement kurumsalButton_Loc;

    @FindBy(xpath = "//*[text()='Yardım']") public WebElement yardimButton_Loc;

    @FindBy(css = "a#socialInstagram") public WebElement instagramButton_Loc;

    @FindBy(css = "a#socialFacebook") public WebElement facebookButton_Loc;

    @FindBy(css = "[name='isConfirmPrivacyPolicy']") public WebElement confirmPrivacyButton_Loc;

    @FindBy(css = "button#submitNewsletterForm") public WebElement newsLetterButton_Loc;

    @FindBy(xpath = "//*[@class='MuiBox-root muirtl-j7qwjs']//p") public List<WebElement> footerLinks_Loc;

    @FindBy(xpath = "//*[@class='MuiBox-root muirtl-i3pbo']//h3") public WebElement title_Loc;

    public void gotoHomePage(){
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(5);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        WebElement accept = (WebElement) jse.executeScript("return document.querySelector('#usercentrics-root').shadowRoot.querySelector('#focus-lock-id > div.sc-ksBlkl.eOmAmn > div > div.sc-iAEawV.tEtgF > div > div > div.sc-kMjNwy.lfNWTX > div > div > button:nth-child(3)')");
        BrowserUtils.clickWithJS(accept);
        BrowserUtils.waitFor(1);
    }

    public static void checkHomePage(){
        String expectedTitle ="GERRY WEBER";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void clickLogin(){
        BrowserUtils.waitForClickablility(loginBtn_Loc,5);
        BrowserUtils.waitFor(2);
        loginBtn_Loc.click();
        BrowserUtils.waitFor(2);
    }

    public void clickHamburgerMenu(){
        BrowserUtils.waitForClickablility(hamburgerMenuBtn_Loc,5);
        hamburgerMenuBtn_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void searchBox(String string){
        searchBox_Loc.sendKeys(string+Keys.ENTER);
        BrowserUtils.waitFor(1);
    }

    List<String> allCategories = new ArrayList<>();
    public void checkCategories(List<String> categoriesList){

        for (WebElement element : categoriesList_Loc) {
            allCategories.add(element.getText());
        }

        Assert.assertTrue(allCategories.containsAll(categoriesList));
    }

    List<String> allNames = new ArrayList<>();
    public void checkFooterNames(List<String> headerNames){

        for (WebElement element : footerMenuNames_Loc) {
            allNames.add(element.getText());
        }
        Assert.assertTrue(allNames.containsAll(headerNames));
    }

    public void checkPageTitle(String button, String title){
        BrowserUtils.waitFor(1);
        kurumsalButton_Loc.click();
        BrowserUtils.waitFor(1);
        yardimButton_Loc.click();
        BrowserUtils.waitFor(1);
        for (int i = 0; i < footerLinks_Loc.size(); i++) {

            if (footerLinks_Loc.get(i).getText().contains(button)){

                BrowserUtils.clickWithJS(footerLinks_Loc.get(i));
                BrowserUtils.waitForPageToLoad(10);
                BrowserUtils.waitFor(2);
                String actualTitle = title_Loc.getText();
                Assert.assertEquals(title,actualTitle);
                BrowserUtils.waitFor(2);
            }
        }
    }

    public void clickInstagramButton(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(instagramButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void verifyInstagramPage(){
        BrowserUtils.waitFor(2);
        BrowserUtils.getWindowHandle();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Gerry Weber (@gerryweberturkiye) • Instagram photos and videos";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void clickFacebookButton(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(facebookButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void verifyFacebookPage(){
        BrowserUtils.waitFor(2);
        BrowserUtils.getWindowHandle();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Gerry Weber Türkiye";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void clickConfirmButton(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(confirmPrivacyButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void clickNewsLetterButton(){
        BrowserUtils.waitForClickablility(newsLetterButton_Loc,10);
        BrowserUtils.clickWithJS(newsLetterButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void sendInvalidEmail(){
        BrowserUtils.waitForClickablility(email_Loc,5);
        email_Loc.sendKeys("abcd");
        BrowserUtils.waitFor(1);
    }

    public void sendValidEmail(){
        BrowserUtils.waitForClickablility(email_Loc,5);
        Faker faker = new Faker();
        email_Loc.sendKeys(faker.internet().emailAddress());
        BrowserUtils.waitFor(1);
    }
}
