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

public class SelectDatepickerTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        homePage = PageFactory.initElements(driver,homePage.class);
    }

    @Test
    public void testSelectDatepicker() {
        homePage.clickDatePickerLink();
    }

}