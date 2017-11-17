package smokeTest;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FillInLoginTest extends TestBase{
    String varUser;
    String varPwd;
    Properties prop;

    @BeforeTest
    public void readFiles() {
        String workingDir = System.getProperty("user.dir");
        try {
            FileInputStream fis = new FileInputStream(workingDir + "/src/test/resources/referenceUserData.txt");
            prop = new Properties();
            prop.load(fis);
            varUser = prop.getProperty("username");
            varPwd = prop.getProperty("password");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest(alwaysRun = true)
    public void setup() {
        signInPage = PageFactory.initElements(driver,signInPage.class);
    }

    @Test
    public void testFillInLogin() {
        signInPage.sendUsername(varUser);
        signInPage.sendPassword(varPwd);
        signInPage.clickBtnSubmit();
    }
}

