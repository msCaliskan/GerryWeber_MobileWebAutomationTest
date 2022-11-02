package com.gerryweber.pages;


import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountPage extends BasePage{

    @FindBy(css = "#firstName") public WebElement ad_Loc;

    @FindBy(css = "#lastName") public WebElement soyad_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#phone") public WebElement telefon_Loc;

    @FindBy(xpath = "//*[contains(@class, 'MuiAccordionSummary-expandIconWrapper')]") public WebElement arrowBtn_Loc;

    @FindBy(xpath = "(//*[text()='Şifremi Sıfırla'])[2]") public WebElement sifremiSifirla_Loc;

    @FindBy(xpath = "//*[text()='Çıkış']") public WebElement cikisYap_Loc;

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
