package SmokeTest;


import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.*;

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
        String pathToFile = "/src/test/resources/referenceUserData.txt";
        String varCompleteFilePath = workingDir + pathToFile;
        try {
            FileInputStream fis = new FileInputStream(varCompleteFilePath);
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
        DatepickerPage = PageFactory.initElements(driver, DatepickerPage.class);
    }


    @Test
    public void testFillDatePicker() {
        Assert.assertNotNull(driver.findElements(By.cssSelector("input[id='datepicker']")));
        DatepickerPage.fillDatePicker();
    }

    @Test(dependsOnMethods = "testFillDatePicker")
    public void testSelTabAnimations() {
        DatepickerPage.selectTabAnimations();
        Assert.assertTrue(DatepickerPage.elementHasClass(driver.findElement(By.cssSelector("div.responsive-tabs-default ul.responsive-tabs li:nth-child(2)"))));
    }

    @Test(dependsOnMethods = "testSelTabAnimations")
    public void testTabAnimationsCommands() {
        Assert.assertNotNull(driver.findElements(By.cssSelector("select[id='anim']")));
        DatepickerPage.tabAnimationsCommands();
    }

    @Test(dependsOnMethods = "testTabAnimationsCommands")
    public void testTabDisplayMonthAndYear() {
        DatepickerPage.selectTabDisplayMonthAndYear();
        Assert.assertTrue(DatepickerPage.elementHasClass(driver.findElement(By.cssSelector("div.responsive-tabs-default ul.responsive-tabs li:nth-child(3)"))));
    }

    @Test(dependsOnMethods = "testTabDisplayMonthAndYear")
    public void testTabDisplayMonthAndYearCommands() {
        Assert.assertNotNull(driver.findElements(By.cssSelector("input[id='datepicker']")));
        DatepickerPage.tabDisplayMonthAndYearCommands();
    }

    @Test(dependsOnMethods = "testTabDisplayMonthAndYearCommands")
    public void testSelTabFormatDate() {
        DatepickerPage.selectTabFormatDate();
        Assert.assertTrue(DatepickerPage.elementHasClass(driver.findElement(By.cssSelector("div.responsive-tabs-default ul.responsive-tabs li:nth-child(4)"))));
    }

    @Test(dependsOnMethods = "testSelTabFormatDate")
    public void testTabFormatDateCommands() {
        DatepickerPage.tabFormatDateCommands();
        Assert.assertTrue(DatepickerPage.compareDateFormat(dateFormat), "Verification failed");
    }

    @Test(dependsOnMethods = "testTabFormatDateCommands")
    public void testShowDatePicker() {
        DatepickerPage.clickShowDatePicker();
        Assert.assertTrue(DatepickerPage.isDateBoxShown(), "Date Picker not visible");
    }
}