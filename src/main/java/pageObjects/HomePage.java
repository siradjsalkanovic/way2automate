package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(linkText = "Signin")
    WebElement lnkSignIn;

    @FindBy(linkText = "Datepicker")
    WebElement clickDatePicker;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage clickSingInLink() {
        lnkSignIn.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public HomePage clickDatePickerLink () {
        clickDatePicker.click();
        return PageFactory.initElements(driver, HomePage.class);
    }


}
