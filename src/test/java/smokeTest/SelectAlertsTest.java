package smokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.SelectablePage;

public class SelectAlertsTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        SelectablePage = PageFactory.initElements(driver, SelectablePage.class);
    }

    @Test
    public void testSelectAlerts (){
        SelectablePage.clickAlertsLink();
    }

}

