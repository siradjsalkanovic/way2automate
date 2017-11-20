package smokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AlertsPage;

public class SelectDroppableTest extends TestBase{


    @BeforeTest(alwaysRun = true)
    public void setup() {
        AlertsPage = PageFactory.initElements(driver, AlertsPage.class);
    }

    @Test
    public void testSelectDroppable () {
        AlertsPage.clickDroppableLink();
    }


}

