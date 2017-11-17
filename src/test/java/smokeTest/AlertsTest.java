package smokeTest;


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

public class AlertsTest extends TestBase{

    Properties prop;
    String varAlertMsg;
    String varTestName;

    @FindBy(css = "select[id='anim']")
    WebElement dropdown;

    @BeforeTest
    public void readFiles() {
        String workingDir = System.getProperty("user.dir");
        try {
            FileInputStream fis = new FileInputStream(workingDir + "/src/test/resources/referenceUserData.txt");
            prop = new Properties();
            prop.load(fis);
            varAlertMsg = prop.getProperty("alertMessage");
            varTestName = prop.getProperty("testName");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest(alwaysRun = true)
    public void setup() {
        alertsPage = PageFactory.initElements(driver,alertsPage.class);
    }

    @Test
    public void testAlertsStep1(){
        alertsPage.showAlert();
        Assert.assertTrue(alertsPage.checkAlertMessage(varAlertMsg), "Alert message not ok.");
    }

    @Test(dependsOnMethods = "testAlertsStep1")
    public void testAlertsStep2(){
        alertsPage.acceptAlert();
    }

    @Test(dependsOnMethods = "testAlertsStep2")
    public void testAlertsStep3(){
        alertsPage.selectTabInputAlert();
    }

    @Test(dependsOnMethods = "testAlertsStep3")
    public void testAlertsStep4(){
        alertsPage.showAlert2();
    }

    @Test(dependsOnMethods = "testAlertsStep4")
    public void testAlertsStep5(){
        alertsPage.textIntoAlertBox(varTestName);
        Assert.assertTrue(alertsPage.checkMessage(varTestName), "Message not ok.");
    }

    @Test(dependsOnMethods = "testAlertsStep5")
    public void testAlertsStep6(){
        alertsPage.clickDroppableLink();
    }
}

