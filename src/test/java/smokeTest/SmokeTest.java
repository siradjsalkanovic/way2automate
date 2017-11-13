package smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;

public class SmokeTest extends TestBase {

    String varUser="demotest123";
    String varPwd="demotest123";
    String varAlertMsg="I am an alert box!";
    String varTestName="Siradj";
    String dateFormat="Thursday, 2 November, 2017";
    String varDropdown="Drop (UI Effect)";

    @FindBy(css = "select[id='anim']")
    WebElement dropdown;


    @BeforeClass
    public void setup() {
        homePage = PageFactory.initElements(driver,homePage.class);
        datepickerPage = PageFactory.initElements(driver, datepickerPage.class);
        signInPage = PageFactory.initElements(driver,signInPage.class);
        selectablePage = PageFactory.initElements(driver,selectablePage.class);
        alertsPage = PageFactory.initElements(driver,alertsPage.class);
        droppablePage = PageFactory.initElements(driver,droppablePage.class);
        sliderPage = PageFactory.initElements(driver, sliderPage.class);
    }

    @Test
    public void testOpenLoginPopup(){
       homePage.clickSingInLink();
    }

    @Test(dependsOnMethods = "testOpenLoginPopup")
    public void testFillInLogin () {
        signInPage.sendUsername(varUser);
        signInPage.sendPassword(varPwd);
        signInPage.clickBtnSubmit();
    }

    @Test(dependsOnMethods = "testFillInLogin")
    public void testSelectDatepicker () {
        homePage.clickDatePickerLink();
    }


    /* *** DATEPICKER TEST START *** */

    @Test(dependsOnMethods = "testSelectDatepicker")
    public void testFillDatePicker(){
        Assert.assertNotNull(driver.findElements(By.cssSelector("input[id='datepicker']")));
        datepickerPage.fillDatePicker();
    }

    @Test(dependsOnMethods = "testFillDatePicker")
    public void testSelTabAnimations(){
        datepickerPage.selectTabAnimations();
        Assert.assertTrue(datepickerPage.elementHasClass(driver.findElement(By.cssSelector("div.responsive-tabs-default ul.responsive-tabs li:nth-child(2)"))));
    }

    @Test(dependsOnMethods = "testSelTabAnimations")
    public void testTabAnimationsCommands(){
        Assert.assertNotNull(driver.findElements(By.cssSelector("select[id='anim']")));
        datepickerPage.tabAnimationsCommands();
    }

    @Test(dependsOnMethods = "testTabAnimationsCommands")
    public void testTabDisplayMonthAndYear(){
        datepickerPage.selectTabDisplayMonthAndYear();
        Assert.assertTrue(datepickerPage.elementHasClass(driver.findElement(By.cssSelector("div.responsive-tabs-default ul.responsive-tabs li:nth-child(3)"))));
    }

    @Test(dependsOnMethods = "testTabDisplayMonthAndYear")
    public void testTabDisplayMonthAndYearCommands(){
        Assert.assertNotNull(driver.findElements(By.cssSelector("input[id='datepicker']")));
        datepickerPage.tabDisplayMonthAndYearCommands();
    }

    @Test(dependsOnMethods = "testTabDisplayMonthAndYearCommands")
    public void testSelTabFormatDate(){
        datepickerPage.selectTabFormatDate();
        Assert.assertTrue(datepickerPage.elementHasClass(driver.findElement(By.cssSelector("div.responsive-tabs-default ul.responsive-tabs li:nth-child(4)"))));
    }

    @Test(dependsOnMethods = "testSelTabFormatDate")
    public void testTabFormatDateCommands(){
        datepickerPage.tabFormatDateCommands();
        Assert.assertTrue(datepickerPage.compareDateFormat(dateFormat),"Verification failed");
    }

    @Test(dependsOnMethods = "testTabFormatDateCommands")
    public void testShowDatePicker(){
        datepickerPage.clickShowDatePicker();
        Assert.assertTrue(datepickerPage.isDateBoxShown(),"Date Picker not visible");
    }

    /* *** DATEPICKER TEST STOP *** */


    @Test(dependsOnMethods = "testShowDatePicker")
    public void testSelectSelectable () {
        datepickerPage.clickSelectableLink();
    }

    @Test(dependsOnMethods = "testSelectSelectable")
    public void testSelectable () {
        selectablePage.selectOptionIterator();
        selectablePage.selectTabDisplayAsGrid();
        selectablePage.selectOptionIterator2();
        selectablePage.selectTabSerialize();
        selectablePage.selectOptionIterator3();
    }

    @Test(dependsOnMethods = "testSelectable")
    public void testSelectAlerts (){
        selectablePage.clickAlertsLink();
    }

    @Test(dependsOnMethods = "testSelectAlerts")
    public void testAlerts(){
        alertsPage.showAlert();
        Assert.assertTrue(alertsPage.checkAlertMessage(varAlertMsg), "Alert message not ok.");
        alertsPage.acceptAlert();
        alertsPage.selectTabInputAlert();
        alertsPage.showAlert2();
        alertsPage.textIntoAlertBox(varTestName);
        Assert.assertTrue(alertsPage.checkMessage(varTestName), "Message not ok.");
        alertsPage.clickDroppableLink();
    }

    @Test (dependsOnMethods = "testAlerts")
    public void testDroppable () {
        droppablePage.dragDrop();
        droppablePage.clickSliderLink();
    }

    @Test(dependsOnMethods = "testDroppable")
    public void testSlider () {
        sliderPage.moveSlider();
        Assert.assertTrue(sliderPage.verifyAmount("10"), "Amounts different.");
    }

}
