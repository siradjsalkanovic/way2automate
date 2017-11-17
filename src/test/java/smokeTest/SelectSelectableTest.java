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

public class SelectSelectableTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        datepickerPage = PageFactory.initElements(driver, datepickerPage.class);
    }

    @Test
    public void testSelectSelectable () {
        datepickerPage.clickSelectableLink();
    }

}

