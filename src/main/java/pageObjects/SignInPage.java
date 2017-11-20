package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    private WebDriver driver;

    @FindBy(css = "div.fancybox-inner div input[name='username']")
    WebElement username1;

    @FindBy(css = "div.fancybox-inner div input[name='password']")
    WebElement password1;

    @FindBy(css = "div.fancybox-inner div input[type='submit']")
    WebElement btnSubmit;

    @FindBy(xpath = "//div[@id='login']")
    WebElement formModal;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage sendUsername (String varUser){
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(username1));

        username1.sendKeys(varUser);
        return  PageFactory.initElements(driver, SignInPage.class);
    }

    public SignInPage sendPassword (String varPasswd){
        password1.sendKeys(varPasswd);
        return  PageFactory.initElements(driver, SignInPage.class);
    }

    public SignInPage clickBtnSubmit() {
        btnSubmit.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }

}
