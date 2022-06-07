package com.gerryweber.pages;

import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CategoryAndProductPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-sm-4 MuiGrid-grid-md-4')]") public List<WebElement> prodList_Loc;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-fullWidth MuiButtonBase-root has-stock')]") public List<WebElement> sizeList_Loc;

    @FindBy(xpath = "//*[@class='MuiTypography-root jss140 MuiTypography-body1']") public List<WebElement> productName_Loc;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium muirtl-1x0t2pd'])[2]") public WebElement uyari_Loc;

    @FindBy(xpath = "//*[text()='Favorilere Ekle']") public WebElement favoriBtn_Loc;

    @FindBy(xpath = "//*[text()='SEPETE EKLE']") public WebElement sepeteEkleBtn_Loc;

    @FindBy(xpath = "//*[@name='price']") public WebElement priceHolder_Loc;

    @FindBy(xpath = "//*[text()='Fiyatı Düşünce Haber Ver']") public WebElement fiyatDHVBtn_Loc;

    public void clickProductRandom(){

        Random rn = new Random();
        int a = rn.nextInt(prodList_Loc.size())+1;

        String loc = "(//*[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-sm-4 MuiGrid-grid-md-4')])["+a+"]";
        BrowserUtils.waitFor(1);
        WebElement randomProd = Driver.get().findElement(By.xpath(loc));
        BrowserUtils.waitFor(1);
        BrowserUtils.hover(randomProd);
        BrowserUtils.waitFor(1);
        randomProd.click();
        BrowserUtils.waitFor(2);

    }

    public void searchResult(String string){

        List<String> allNames = new ArrayList<>();
        for (WebElement element : prodList_Loc) {
        allNames.add(element.getText());
        }
        for (int i = 0; i < productName_Loc.size(); i++) {
             allNames.get(i).contains(string);
        }
    }

    public static void navigateMobile(String tab){
        String tabLocator = "//span[text()='"+tab+"']";

        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(tabLocator)), 5);
        Driver.get().findElement(By.xpath(tabLocator)).click();
        BrowserUtils.waitFor(2);
    }
    public void closePopUps(){
        uyari_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void selectSize(){

        Random rn = new Random();
        int a = rn.nextInt(sizeList_Loc.size())+1;
        String loc = "(//button[contains(@class, 'MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-fullWidth MuiButtonBase-root has-stock')])["+a+"]";

        WebElement randomSize = Driver.get().findElement(By.xpath(loc));

        BrowserUtils.waitFor(1);
        randomSize.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(sepeteEkleBtn_Loc);
        BrowserUtils.waitFor(2);

    }
    public void validPrice(){
        String price = priceHolder_Loc.getAttribute("value");

        int b = Integer.parseInt(price);
        int c= b-5;

        priceHolder_Loc.sendKeys(Keys.CONTROL+"a");
        priceHolder_Loc.sendKeys(Keys.DELETE);
        BrowserUtils.waitFor(1);
        priceHolder_Loc.sendKeys(Integer.toString(c));
        BrowserUtils.waitFor(2);

    }
    public void clickFiyatButton(){
        BrowserUtils.waitForClickablility(fiyatDHVBtn_Loc,5);
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(fiyatDHVBtn_Loc);
        BrowserUtils.waitFor(2);
    }

}