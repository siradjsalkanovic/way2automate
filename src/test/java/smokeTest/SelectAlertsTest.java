package smokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.selectablePage;

public class SelectAlertsTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        selectablePage = PageFactory.initElements(driver,selectablePage.class);
    }

    @Test
    public void testSelectAlerts (){
        selectablePage.clickAlertsLink();
    }

}

