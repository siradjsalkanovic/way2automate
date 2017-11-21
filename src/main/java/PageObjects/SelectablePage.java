package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectablePage {
    private WebDriver driver;

    @FindBy(linkText = "Datepicker")
    WebElement clickDatePicker;

    @FindBy(css = "div#example-1-tab-1 div.freme_box iframe")
    WebElement iFrameWindow1;

    @FindBy(css = "div#example-1-tab-2 div.freme_box iframe")
    WebElement iFrameWindow2;

    @FindBy(css = "div#example-1-tab-3 div.freme_box iframe")
    WebElement iFrameWindow3;

    @FindBy(css = "div.responsive-tabs-default ul.responsive-tabs li:nth-child(2)")
    WebElement tabDisplayAsGrid;

    @FindBy(css = "div.responsive-tabs-default ul.responsive-tabs li:nth-child(3)")
    WebElement tabSerialize;

    @FindBy(css= "ol#selectable")
    WebElement listOfItems;

    @FindBy(linkText = "Alert")
    WebElement clickAlertLink;

    public SelectablePage(WebDriver driver) {
        this.driver = driver;
    }


    public SelectablePage selectTabDisplayAsGrid() {

        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(tabDisplayAsGrid));

        tabDisplayAsGrid.click();

        return PageFactory.initElements(driver, SelectablePage.class);
    }

    public SelectablePage selectTabSerialize() {

        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(tabSerialize));

        tabSerialize.click();

        return PageFactory.initElements(driver, SelectablePage.class);
    }

    public SelectablePage selectOptionIterator() {

        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(iFrameWindow1));

        driver.switchTo().frame(iFrameWindow1);

        WebDriverWait wait1 = new WebDriverWait(driver, 8);
        wait1.until(ExpectedConditions.visibilityOf(listOfItems));
        //listOfItems.click();

        WebElement table = listOfItems;
        List<WebElement> rows = table.findElements(By.tagName("li"));
        java.util.Iterator<WebElement> i = rows.iterator();

        while(i.hasNext()) {

            WebElement row = i.next();
            row.click();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.switchTo().defaultContent();

        return PageFactory.initElements(driver, SelectablePage.class);
    }

    public SelectablePage selectOptionIterator2() {

        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(iFrameWindow2));

        driver.switchTo().frame(iFrameWindow2);

        WebDriverWait wait1 = new WebDriverWait(driver, 8);
        wait1.until(ExpectedConditions.visibilityOf(listOfItems));

        WebElement table = listOfItems;
        List<WebElement> rows = table.findElements(By.tagName("li"));
        java.util.Iterator<WebElement> i = rows.iterator();

        while(i.hasNext()) {

            WebElement row = i.next();
            row.click();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.switchTo().defaultContent();

        return PageFactory.initElements(driver, SelectablePage.class);
    }

    public SelectablePage selectOptionIterator3() {

        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(iFrameWindow3));

        driver.switchTo().frame(iFrameWindow3);

        WebDriverWait wait1 = new WebDriverWait(driver, 8);
        wait1.until(ExpectedConditions.visibilityOf(listOfItems));
        //listOfItems.click();
        WebElement table = listOfItems;
        List<WebElement> rows = table.findElements(By.tagName("li"));
        java.util.Iterator<WebElement> i = rows.iterator();

        while(i.hasNext()) {

            WebElement row = i.next();
            row.click();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.switchTo().defaultContent();

        return PageFactory.initElements(driver, SelectablePage.class);
    }

    public DatepickerPage clickAlertsLink(){
        driver.switchTo().defaultContent();
        clickAlertLink.click();
        return PageFactory.initElements(driver, DatepickerPage.class);
    }
}
