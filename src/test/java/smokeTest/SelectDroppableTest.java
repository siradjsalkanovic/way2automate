package smokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.alertsPage;

public class SelectDroppableTest extends TestBase{


    @BeforeTest(alwaysRun = true)
    public void setup() {
        alertsPage = PageFactory.initElements(driver,alertsPage.class);
    }

    @Test
    public void testSelectDroppable () {
        alertsPage.clickDroppableLink();
    }


}

