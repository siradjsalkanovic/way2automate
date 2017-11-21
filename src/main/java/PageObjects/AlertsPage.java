package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage {
    private WebDriver driver;

    @FindBy(tagName = "button")
    WebElement btnShowAlert;

    @FindBy(css = "div#example-1-tab-1 div.freme_box iframe")
    WebElement iFrameWindow1;

    @FindBy(css = "div#example-1-tab-2 div.freme_box iframe")
    WebElement iFrameWindow2;

    @FindBy(css = "div.responsive-tabs-default ul.responsive-tabs li:nth-child(2)")
    WebElement tabInputAlert;

    @FindBy(id = "demo")
    WebElement textBoxDemo;

    @FindBy(linkText = "Droppable")
    WebElement clickDroppable;


    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public SelectablePage selectTabInputAlert() {

        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(tabInputAlert));

        tabInputAlert.click();

        return PageFactory.initElements(driver, SelectablePage.class);
    }

    public AlertsPage showAlert(){
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(iFrameWindow1));

        driver.switchTo().frame(iFrameWindow1);

        btnShowAlert.click();
        return PageFactory.initElements(driver, AlertsPage.class);
    }

    public Boolean checkAlertMessage(String Msg){
        String alertMsg = driver.switchTo().alert().getText();
        Boolean result =alertMsg.equals(Msg);
        return result;
    }

    public AlertsPage showAlert2(){
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(iFrameWindow2));

        driver.switchTo().frame(iFrameWindow2);

        btnShowAlert.click();
        return PageFactory.initElements(driver, AlertsPage.class);
    }

    public AlertsPage acceptAlert(){
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        return PageFactory.initElements(driver, AlertsPage.class);
    }

    public AlertsPage textIntoAlertBox(String name){
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        return PageFactory.initElements(driver, AlertsPage.class);
    }

    public Boolean checkMessage(String name){

        driver.switchTo().frame(iFrameWindow2);

        String Msg = textBoxDemo.getText();
        Boolean result = Msg.equals("Hello "+name+"! How are you today?");
        return result;
    }

    public Boolean checkTabActive(){

        Boolean result = tabInputAlert.getAttribute("class").equals("active");
        return result;
    }

    public AlertsPage clickDroppableLink(){
        driver.switchTo().defaultContent();
        clickDroppable.click();
        return PageFactory.initElements(driver, AlertsPage.class);
    }
}
