package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class datepickerPage {

    private WebDriver driver;


    String dateFormat;
    Select dropdown;

    @FindBy(linkText = "Datepicker")
    WebElement clickDatePicker;

    @FindBy(linkText = "Selectable")
    WebElement clickSelectable;

    @FindBy(css = "div#example-1-tab-1 div.freme_box iframe")
    WebElement iFrameWindow1;

    @FindBy(css = "div#example-1-tab-2 div.freme_box iframe")
    WebElement iFrameWindow2;

    @FindBy(css = "div#example-1-tab-3 div.freme_box iframe")
    WebElement iFrameWindow3;

    @FindBy(css = "div#example-1-tab-4 div.freme_box iframe")
    WebElement iFrameWindow4;

    @FindBy(css = "input[id='datepicker']")
    WebElement datePicker;

    @FindBy(css = "div.responsive-tabs-default ul.responsive-tabs li:nth-child(2)")
    WebElement tabAnimations;

    @FindBy(css = "div.responsive-tabs-default ul.responsive-tabs li:nth-child(3)")
    WebElement tabDisplayMonthYear;

    @FindBy(css = "div.responsive-tabs-default ul.responsive-tabs li:nth-child(4)")
    WebElement tabFormatDate;

    @FindBy(css = "select[id='anim']")
    WebElement selectBoxAnimation;

    @FindBy(css = "select[id='format']")
    WebElement selectBoxDateFormat;

    @FindBy(css = "div[id='ui-datepicker-div']")
    WebElement dateBox;

    @FindBy(css = "div[id='ui-datepicker-div']")
    WebElement dateBoxSelectMonth;



    public datepickerPage(WebDriver driver) {
        this.driver = driver;
    }

    public datepickerPage clickDatePickerLink () {
        clickDatePicker.click();
        return PageFactory.initElements(driver, datepickerPage.class);

    }

    public datepickerPage fillDatePicker () {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(iFrameWindow1));

        driver.switchTo().frame(iFrameWindow1);
        datePicker.click();
        datePicker.sendKeys("11/02/2017");
        driver.switchTo().defaultContent();
        return PageFactory.initElements(driver, datepickerPage.class);
    }

    public datepickerPage selectTabAnimations() {

        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(tabAnimations));
        tabAnimations.click();
        return PageFactory.initElements(driver, datepickerPage.class);
    }

    public datepickerPage selectTabDisplayMonthAndYear(){
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(tabDisplayMonthYear));
        tabDisplayMonthYear.click();
        return PageFactory.initElements(driver, datepickerPage.class);
    }

    public datepickerPage selectTabFormatDate(){
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(tabFormatDate));
        tabFormatDate.click();
        return PageFactory.initElements(driver, datepickerPage.class);
    }

    public datepickerPage tabAnimationsCommands() {

        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(iFrameWindow2));

        driver.switchTo().frame(iFrameWindow2);
        datePicker.sendKeys("11/02/2017");

        dropdown = new Select(selectBoxAnimation);
        dropdown.selectByVisibleText("Bounce (UI Effect)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        datePicker.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        datePicker.sendKeys(Keys.ESCAPE);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dropdown.selectByVisibleText("Drop (UI Effect)");

        driver.switchTo().defaultContent();
        return PageFactory.initElements(driver, datepickerPage.class);

    }

    public datepickerPage tabDisplayMonthAndYearCommands() {
        driver.switchTo().frame(iFrameWindow3);
        datePicker.sendKeys("11/02/2017");
        driver.switchTo().defaultContent();

        return PageFactory.initElements(driver, datepickerPage.class);
    }

    public datepickerPage tabFormatDateCommands() {
        driver.switchTo().frame(iFrameWindow4);
        datePicker.sendKeys("11/02/2017");

        Select dropdown = new Select(selectBoxDateFormat);
        dropdown.selectByIndex(4);
        dateFormat=datePicker.getAttribute("value");
        driver.switchTo().defaultContent();

        return PageFactory.initElements(driver, datepickerPage.class);
    }

    public datepickerPage clickSelectableLink(){
        driver.switchTo().defaultContent();
        clickSelectable.click();
        return PageFactory.initElements(driver, datepickerPage.class);
    }

    public datepickerPage clickShowDatePicker(){
        driver.switchTo().frame(iFrameWindow4);

        datePicker.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, datepickerPage.class);
    }

    public Boolean compareDateFormat(String date1){
        Boolean result = dateFormat.equals(date1);
        driver.switchTo().defaultContent();
        return result;
    }

    public Boolean isDateBoxShown(){
        Boolean result = dateBox.getCssValue("display").equals("block");
        return result;
    }

    public boolean elementHasClass(WebElement element) {
        return element.getAttribute("class").contains("active");
    }

    public Boolean dateBoxMonth() {
        return dateBoxSelectMonth.getCssValue("display").equals("block");
    }



}
