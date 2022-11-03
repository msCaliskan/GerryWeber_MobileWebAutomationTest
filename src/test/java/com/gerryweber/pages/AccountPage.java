package com.gerryweber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

public class AccountPage extends BasePage{

    @FindBy(css = "#firstName") public WebElement ad_Loc;

    @FindBy(css = "#lastName") public WebElement soyad_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#phone") public WebElement telefon_Loc;

    @FindBy(xpath = "//*[contains(@class, 'MuiAccordionSummary-expandIconWrapper')]") public WebElement arrowBtn_Loc;

    public void getInformation(String name, String lastname, String email, String phone){
        String actName = ad_Loc.getAttribute("value");
        String actlastName = soyad_Loc.getAttribute("value");
        String actEmail = email_Loc.getAttribute("value");
        String actPhone = telefon_Loc.getAttribute("value");

        assertEquals(name,actName);
        assertEquals(lastname,actlastName);
        assertEquals(email,actEmail);
        assertEquals(phone,actPhone);
    }
}
