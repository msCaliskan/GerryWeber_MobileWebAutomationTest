package com.gerryweber.pages;

import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends BasePage{

    @FindBy(xpath = "//*[@id='cardnumber']") public WebElement kartNo_Loc;

    @FindBy(xpath = "//*[@id='ccname']") public WebElement adSoyad_Loc;

    @FindBy(xpath = "(//*[@id='ccexpmonth'])[2]") public WebElement sktAy_Loc;

    @FindBy(xpath = "//*[contains(@class, 'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters')]") public List<WebElement> dataList_Loc;

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
