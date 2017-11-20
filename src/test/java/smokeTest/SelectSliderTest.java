package smokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DroppablePage;

public class SelectSliderTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        DroppablePage = PageFactory.initElements(driver, DroppablePage.class);
    }

    @Test
    public void testSelectDroppable () {
        DroppablePage.clickSliderLink();
    }

}

