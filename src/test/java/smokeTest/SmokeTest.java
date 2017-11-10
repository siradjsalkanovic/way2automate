package smokeTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.datepickerPage;
import pageObjects.homePage;
import pageObjects.signInPage;
import pageObjects.selectablePage;
import pageObjects.alertsPage;
import pageObjects.droppablePage;
import pageObjects.sliderPage;

public class SmokeTest extends TestBase {

    String varUser="demotest123";
    String varPwd="demotest123";
    String varAlertMsg="I am an alert box!";
    String varTestName="Siradj";
    String dateFormat="Thursday, 2 November, 2017";

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

    @Test(dependsOnMethods = "testSelectDatepicker")
    public void testDatePicker(){
        datepickerPage.fillDatePicker();
        datepickerPage.selectTabAnimations();
        datepickerPage.tabAnimationsCommands();
        datepickerPage.selectTabDisplayMonthAndYear();
        datepickerPage.tabDisplayMonthAndYearCommands();
        datepickerPage.selectTabFormatDate();
        datepickerPage.tabFormatDateCommands();
        Assert.assertTrue(datepickerPage.compareDateFormat(dateFormat),"Verification failed");
        datepickerPage.clickShowDatePicker();
        Assert.assertTrue(datepickerPage.isDateBoxShown(),"Date Picker not visible");
    }

    @Test(dependsOnMethods = "testDatePicker")
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
