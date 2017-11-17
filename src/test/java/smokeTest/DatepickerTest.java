package smokeTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DatepickerTest extends TestBase {
    Properties prop;
    String dateFormat;

    @BeforeTest
    public void readFiles() {
        String workingDir = System.getProperty("user.dir");
        try {
            FileInputStream fis = new FileInputStream(workingDir + "/src/test/resources/referenceUserData.txt");
            prop = new Properties();
            prop.load(fis);
            dateFormat = prop.getProperty("dateFormat");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest(alwaysRun = true)
    public void setup() {
        datepickerPage = PageFactory.initElements(driver, datepickerPage.class);
    }


    @Test
    public void testFillDatePicker() {
        Assert.assertNotNull(driver.findElements(By.cssSelector("input[id='datepicker']")));
        datepickerPage.fillDatePicker();
    }

    @Test(dependsOnMethods = "testFillDatePicker")
    public void testSelTabAnimations() {
        datepickerPage.selectTabAnimations();
        Assert.assertTrue(datepickerPage.elementHasClass(driver.findElement(By.cssSelector("div.responsive-tabs-default ul.responsive-tabs li:nth-child(2)"))));
    }

    @Test(dependsOnMethods = "testSelTabAnimations")
    public void testTabAnimationsCommands() {
        Assert.assertNotNull(driver.findElements(By.cssSelector("select[id='anim']")));
        datepickerPage.tabAnimationsCommands();
    }

    @Test(dependsOnMethods = "testTabAnimationsCommands")
    public void testTabDisplayMonthAndYear() {
        datepickerPage.selectTabDisplayMonthAndYear();
        Assert.assertTrue(datepickerPage.elementHasClass(driver.findElement(By.cssSelector("div.responsive-tabs-default ul.responsive-tabs li:nth-child(3)"))));
    }

    @Test(dependsOnMethods = "testTabDisplayMonthAndYear")
    public void testTabDisplayMonthAndYearCommands() {
        Assert.assertNotNull(driver.findElements(By.cssSelector("input[id='datepicker']")));
        datepickerPage.tabDisplayMonthAndYearCommands();
    }

    @Test(dependsOnMethods = "testTabDisplayMonthAndYearCommands")
    public void testSelTabFormatDate() {
        datepickerPage.selectTabFormatDate();
        Assert.assertTrue(datepickerPage.elementHasClass(driver.findElement(By.cssSelector("div.responsive-tabs-default ul.responsive-tabs li:nth-child(4)"))));
    }

    @Test(dependsOnMethods = "testSelTabFormatDate")
    public void testTabFormatDateCommands() {
        datepickerPage.tabFormatDateCommands();
        Assert.assertTrue(datepickerPage.compareDateFormat(dateFormat), "Verification failed");
    }

    @Test(dependsOnMethods = "testTabFormatDateCommands")
    public void testShowDatePicker() {
        datepickerPage.clickShowDatePicker();
        Assert.assertTrue(datepickerPage.isDateBoxShown(), "Date Picker not visible");
    }
}