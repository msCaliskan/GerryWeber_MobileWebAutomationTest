package com.gerryweber.pages;

import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.ConfigurationReader;
import com.gerryweber.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends BasePage{

    @FindBy(css = "#firstName") public WebElement ad_Loc;

    @FindBy(css = "#lastName") public WebElement soyad_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#phone") public WebElement telefon_Loc;

    @FindBy(css = "#title") public WebElement adresBasligi_Loc;

    @FindBy(css = "#cityId") public WebElement sehir_Loc;

    @FindBy(css = "#countyId") public WebElement ilce_Loc;

    @FindBy(xpath = "//*[contains(@class, 'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters')]") public List<WebElement> dataList_Loc;

    @FindBy(css = "#zipPostalCode") public WebElement postaKodu_Loc;

    @FindBy(css = "#identifier") public WebElement tcKimlik_Loc;

    @FindBy(css = "#streetAddress") public WebElement adres_Loc;
    @FindBy(xpath = "//*[@id='cardnumber']") public WebElement kartNo_Loc;

    @FindBy(xpath = "//*[@id='ccname']") public WebElement adSoyad_Loc;

    @FindBy(xpath = "(//*[@id='ccexpmonth'])[2]") public WebElement sktAy_Loc;

    @FindBy(xpath = "(//*[@id='ccexpyear'])[2]") public WebElement sktYil_Loc;

    @FindBy(xpath = "//*[@id='cvc']") public WebElement cvc_Loc;

    @FindBy(xpath = "//*[@id='isPolicyConfirmed']") public WebElement mesafeliSatis_Loc;

    @FindBy(xpath = "//button[contains (@class, 'basket-delete-button')]") public WebElement deleteBtn_Loc;

    @FindBy(xpath = "(//button[contains(@class, 'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall')])[2]") public WebElement basketButton_Loc;

    public void invalidCard(){
        kartNo_Loc.sendKeys("4444444444444444");
        adSoyad_Loc.sendKeys("Test Test");

        BrowserUtils.waitFor(1);

        sktAy_Loc.click();
        BrowserUtils.waitFor(1);
        List<WebElement> allMonths = dataList_Loc;

        for (int i = 1; i <= allMonths.size(); i++) {
            if (allMonths.get(i).getText().contains("10")){
                allMonths.get(i).click();
                break;
            }
        }
        BrowserUtils.waitFor(1);

        sktYil_Loc.click();
        BrowserUtils.waitFor(1);
        List<WebElement> allYear = dataList_Loc;

        for (int i = 1; i <= allYear.size(); i++) {
            if (allYear.get(i).getText().contains("2027")){
                allYear.get(i).click();
                break;
            }
        }
        cvc_Loc.click();
        cvc_Loc.sendKeys("295");
        BrowserUtils.waitFor(2);
    }

    public void enterGuestAdress(){
        BrowserUtils.scrollDown();
        BrowserUtils.waitFor(1);

        adresBasligi_Loc.sendKeys(ConfigurationReader.get("adress_title"));
        ad_Loc.sendKeys(ConfigurationReader.get("user_firstName"));
        soyad_Loc.sendKeys(ConfigurationReader.get("user_lastName"));
        email_Loc.sendKeys(ConfigurationReader.get("user_email"));
        telefon_Loc.click();
        telefon_Loc.sendKeys(ConfigurationReader.get("user_phone1"));
        BrowserUtils.waitFor(1);
        postaKodu_Loc.click();
        postaKodu_Loc.sendKeys("34340");
        tcKimlik_Loc.click();
        tcKimlik_Loc.sendKeys(ConfigurationReader.get("user_identifier"));
        BrowserUtils.waitFor(1);

        sehir_Loc.click();
        BrowserUtils.waitFor(1);

        for (int i = 1; i <= dataList_Loc.size(); i++) {
            if (dataList_Loc.get(i).getText().contains("Ankara")){
                dataList_Loc.get(i).click();
                break;
            }
        }
        BrowserUtils.waitFor(1);

        ilce_Loc.click();
        BrowserUtils.waitFor(1);

        for (int i = 1; i <= dataList_Loc.size(); i++) {
            if (dataList_Loc.get(i).getText().contains("EVREN")){
                dataList_Loc.get(i).click();
                break;
            }
        }
        adres_Loc.sendKeys("test test test");
    }

    public void checkBox(){
        mesafeliSatis_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void delete(){
        BrowserUtils.waitForClickablility(deleteBtn_Loc,5);
        BrowserUtils.clickWithJS(deleteBtn_Loc);
        BrowserUtils.waitFor(2);
    }

    public void backToBasket(){
        Driver.get().navigate().back();
    }

    public void clickBasketButton(){
        BrowserUtils.waitForClickablility(basketButton_Loc,5);
        basketButton_Loc.click();
        BrowserUtils.waitFor(1);
    }
}
