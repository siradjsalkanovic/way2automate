package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class signInPage {
    private WebDriver driver;

    @FindBy(css = "div.fancybox-inner div input[name='username']")
    WebElement username1;

    @FindBy(css = "div.fancybox-inner div input[name='password']")
    WebElement password1;

    @FindBy(css = "div.fancybox-inner div input[type='submit']")
    WebElement btnSubmit;

    @FindBy(xpath = "//div[@id='login']")
    WebElement formModal;

    public signInPage(WebDriver driver) {
        this.driver = driver;
    }

    public signInPage sendUsername (String varUser){
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(username1));

        username1.sendKeys(varUser);
        return  PageFactory.initElements(driver, signInPage.class);
    }

    public signInPage sendPassword (String varPasswd){
        password1.sendKeys(varPasswd);
        return  PageFactory.initElements(driver, signInPage.class);
    }

    public signInPage clickBtnSubmit() {
        btnSubmit.click();
        return PageFactory.initElements(driver, signInPage.class);
    }

}
