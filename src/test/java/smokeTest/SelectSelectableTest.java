package smokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

public class SelectSelectableTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        DatepickerPage = PageFactory.initElements(driver, DatepickerPage.class);
    }

    @Test
    public void testSelectSelectable () {
        DatepickerPage.clickSelectableLink();
    }

}

