package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class homePage {

    private WebDriver driver;

    @FindBy(linkText = "Signin")
    WebElement lnkSignIn;

    @FindBy(linkText = "Datepicker")
    WebElement clickDatePicker;


    public homePage (WebDriver driver) {
        this.driver = driver;
    }

    public homePage clickSingInLink() {
        lnkSignIn.click();
        return PageFactory.initElements(driver, homePage.class);
    }

    public homePage clickDatePickerLink () {
        clickDatePicker.click();
        return PageFactory.initElements(driver, homePage.class);
    }


}
