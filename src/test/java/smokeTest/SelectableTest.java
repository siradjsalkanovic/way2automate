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

public class SelectableTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        selectablePage = PageFactory.initElements(driver,selectablePage.class);
    }

    @Test
    public void testSelectableStep1 () {
        selectablePage.selectOptionIterator();
    }

    @Test(dependsOnMethods = "testSelectableStep1")
    public void testSelectableStep2 () {
        selectablePage.selectTabDisplayAsGrid();
    }

    @Test(dependsOnMethods = "testSelectableStep2")
    public void testSelectableStep3 () {
        selectablePage.selectOptionIterator2();
    }

    @Test(dependsOnMethods = "testSelectableStep3")
    public void testSelectableStep4 () {
        selectablePage.selectTabSerialize();
    }

    @Test(dependsOnMethods = "testSelectableStep4")
    public void testSelectableStep5 () {
        selectablePage.selectOptionIterator3();
    }


}

