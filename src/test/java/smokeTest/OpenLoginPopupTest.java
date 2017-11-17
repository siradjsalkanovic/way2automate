package smokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.homePage;

public class OpenLoginPopupTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        homePage = PageFactory.initElements(driver,homePage.class);
    }

    @Test
    public void testOpenLoginPopup() {
        homePage.clickSingInLink();
    }
}

