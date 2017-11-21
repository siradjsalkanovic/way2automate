package SmokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.HomePage;

public class OpenLoginPopupTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        HomePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void testOpenLoginPopup() {
        HomePage.clickSingInLink();
    }
}

