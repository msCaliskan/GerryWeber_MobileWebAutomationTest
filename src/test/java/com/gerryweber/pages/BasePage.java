package com.gerryweber.pages;

import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }



    public static void verifyUrl(String expectedURL) {
        String actualTitle = Driver.get().getCurrentUrl();
        actualTitle = actualTitle.replace("https://www.gerryweber.com.tr","");
        Assert.assertEquals(expectedURL,actualTitle);
    }

    public static String verifyMessage(String msg){
        String msg_Loc = Driver.get().findElement(By.xpath("//*[text()='"+msg+"']")).getText();

        return msg_Loc;
    }

    public static String verifyMessagee(String msg){
        String msg_Loc = Driver.get().findElement(By.xpath("(//*[text()='"+msg+"'])[2]")).getText();

        return msg_Loc;
    }

    public static void clickButton(String button){
    String button_Loc = "//*[text()='"+button+"']";
    BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(button_Loc)),5);
    Driver.get().findElement(By.xpath(button_Loc)).click();
    BrowserUtils.waitFor(2);
    }

    public static void clickButton2(String button){
        String button_Loc = "(//*[text()='"+button+"'])[2]";
        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(button_Loc)),5);
        Driver.get().findElement(By.xpath(button_Loc)).click();
        BrowserUtils.waitFor(1);
    }
}
