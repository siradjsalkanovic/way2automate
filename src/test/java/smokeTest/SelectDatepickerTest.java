package smokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

public class SelectDatepickerTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        HomePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void testSelectDatepicker() {
        HomePage.clickDatePickerLink();
    }

}