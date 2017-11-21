package SmokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AlertsTest extends TestBase{

    Properties prop;
    String varAlertMsg;
    String varTestName;

    @BeforeTest
    public void readFiles() {
        String workingDir = System.getProperty("user.dir");
        String pathToFile = "/src/test/resources/referenceUserData.txt";
        String varCompleteFilePath = workingDir + pathToFile;
        try {
            FileInputStream fis = new FileInputStream(varCompleteFilePath);
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
        AlertsPage = PageFactory.initElements(driver, AlertsPage.class);
    }

    @Test
    public void testAlertsShowFirstAlert(){
        AlertsPage.showAlert();
        Assert.assertTrue(AlertsPage.checkAlertMessage(varAlertMsg), "Alert message not ok.");
    }

    @Test(dependsOnMethods = "testAlertsShowFirstAlert")
    public void testAlertsAcceptAlert(){
        AlertsPage.acceptAlert();
    }

    @Test(dependsOnMethods = "testAlertsAcceptAlert")
    public void testAlertsTabInputAlert(){
        AlertsPage.selectTabInputAlert();
        Assert.assertTrue(AlertsPage.checkTabActive());
    }

    @Test(dependsOnMethods = "testAlertsTabInputAlert")
    public void testAlertsShowSecondAlert(){
        AlertsPage.showAlert2();
    }

    @Test(dependsOnMethods = "testAlertsShowSecondAlert")
    public void testAlertsInsertText(){
        AlertsPage.textIntoAlertBox(varTestName);
        Assert.assertTrue(AlertsPage.checkMessage(varTestName), "Message not ok.");
    }
}

