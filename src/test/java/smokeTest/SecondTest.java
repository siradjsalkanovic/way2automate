package smokeTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SecondTest{
    String varUser;
    String varPwd;
    Properties prop;
    String varAlertMsg;
    String varTestName;
    String dateFormat;
    String varDropdown;

    @FindBy(css = "select[id='anim']")
    WebElement dropdown;

    WebDriver driver;
    String baseUrl;
    homePage homePage;
    datepickerPage datepickerPage;
    signInPage signInPage;
    selectablePage selectablePage;
    alertsPage alertsPage;
    droppablePage droppablePage;
    sliderPage sliderPage;

    @BeforeTest
    public void setUp() {
        baseUrl = "http://way2automation.com/way2auto_jquery/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @BeforeTest
    public void readFiles() {
        String workingDir = System.getProperty("user.dir");
        try {
            FileInputStream fis = new FileInputStream(workingDir + "/src/test/resources/referenceUserData.txt");
            prop = new Properties();
            prop.load(fis);

            varUser = prop.getProperty("username");
            varPwd = prop.getProperty("password");
            varAlertMsg = prop.getProperty("alertMessage");
            varTestName = prop.getProperty("testName");
            dateFormat = prop.getProperty("dateFormat");
            varDropdown = prop.getProperty("varDropdown");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest(alwaysRun = true)
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
    public void testSelectDatepicker() {
        homePage.clickDatePickerLink();
    }

//    /* *** DATEPICKER TEST START *** */
//
//    @Test(dependsOnMethods = "testSelectDatepicker")
//    public void testFillDatePicker(){
//        Assert.assertNotNull(driver.findElements(By.cssSelector("input[id='datepicker']")));
//        datepickerPage.fillDatePicker();
//    }
//
//    @Test(dependsOnMethods = "testFillDatePicker")
//    public void testSelTabAnimations(){
//        datepickerPage.selectTabAnimations();
//        Assert.assertTrue(datepickerPage.elementHasClass(driver.findElement(By.cssSelector("div.responsive-tabs-default ul.responsive-tabs li:nth-child(2)"))));
//    }
//
//    @Test(dependsOnMethods = "testSelTabAnimations")
//    public void testTabAnimationsCommands(){
//        Assert.assertNotNull(driver.findElements(By.cssSelector("select[id='anim']")));
//        datepickerPage.tabAnimationsCommands();
//    }
//
//    @Test(dependsOnMethods = "testTabAnimationsCommands")
//    public void testTabDisplayMonthAndYear(){
//        datepickerPage.selectTabDisplayMonthAndYear();
//        Assert.assertTrue(datepickerPage.elementHasClass(driver.findElement(By.cssSelector("div.responsive-tabs-default ul.responsive-tabs li:nth-child(3)"))));
//    }
//
//    @Test(dependsOnMethods = "testTabDisplayMonthAndYear")
//    public void testTabDisplayMonthAndYearCommands(){
//        Assert.assertNotNull(driver.findElements(By.cssSelector("input[id='datepicker']")));
//        datepickerPage.tabDisplayMonthAndYearCommands();
//    }
//
//    @Test(dependsOnMethods = "testTabDisplayMonthAndYearCommands")
//    public void testSelTabFormatDate(){
//        datepickerPage.selectTabFormatDate();
//        Assert.assertTrue(datepickerPage.elementHasClass(driver.findElement(By.cssSelector("div.responsive-tabs-default ul.responsive-tabs li:nth-child(4)"))));
//    }
//
//    @Test(dependsOnMethods = "testSelTabFormatDate")
//    public void testTabFormatDateCommands(){
//        datepickerPage.tabFormatDateCommands();
//        Assert.assertTrue(datepickerPage.compareDateFormat(dateFormat),"Verification failed");
//    }
//
//    @Test(dependsOnMethods = "testTabFormatDateCommands")
//    public void testShowDatePicker(){
//        datepickerPage.clickShowDatePicker();
//        Assert.assertTrue(datepickerPage.isDateBoxShown(),"Date Picker not visible");
//    }
//
//    /* *** DATEPICKER TEST STOP *** */
//
//
//    @Test(dependsOnMethods = "testShowDatePicker")
//    public void testSelectSelectable () {
//        datepickerPage.clickSelectableLink();
//    }
//
//    @Test(dependsOnMethods = "testSelectSelectable")
//    public void testSelectable () {
//        selectablePage.selectOptionIterator();
//        selectablePage.selectTabDisplayAsGrid();
//        selectablePage.selectOptionIterator2();
//        selectablePage.selectTabSerialize();
//        selectablePage.selectOptionIterator3();
//    }
//
//    @Test(dependsOnMethods = "testSelectable")
//    public void testSelectAlerts (){
//        selectablePage.clickAlertsLink();
//    }
//
//    @Test(dependsOnMethods = "testSelectAlerts")
//    public void testAlerts(){
//        alertsPage.showAlert();
//        Assert.assertTrue(alertsPage.checkAlertMessage(varAlertMsg), "Alert message not ok.");
//        alertsPage.acceptAlert();
//        alertsPage.selectTabInputAlert();
//        alertsPage.showAlert2();
//        alertsPage.textIntoAlertBox(varTestName);
//        Assert.assertTrue(alertsPage.checkMessage(varTestName), "Message not ok.");
//        alertsPage.clickDroppableLink();
//    }
//
//    @Test (dependsOnMethods = "testAlerts")
//    public void testDroppable () {
//        droppablePage.dragDrop();
//        droppablePage.clickSliderLink();
//    }
//
//    @Test(dependsOnMethods = "testDroppable")
//    public void testSlider () {
//        sliderPage.moveSlider();
//        Assert.assertTrue(sliderPage.verifyAmount("10"), "Amounts different.");
//    }

}

