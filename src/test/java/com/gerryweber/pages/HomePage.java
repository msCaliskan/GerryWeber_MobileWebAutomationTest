package com.gerryweber.pages;

import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.ConfigurationReader;
import com.gerryweber.utilities.Driver;
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

    @FindBy(xpath = "//*[contains(@class, 'MuiBadge-root')]//*[contains(@class, 'MuiTypography-root MuiTypography-body3')]") public List<WebElement> categoriesList_Loc;

    @FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-h3 muirtl-14hb52n']") public List<WebElement> footerMenuNames_Loc;

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
        loginBtn_Loc.click();
        BrowserUtils.waitFor(1);
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
}
