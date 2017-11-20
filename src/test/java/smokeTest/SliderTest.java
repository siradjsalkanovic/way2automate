package smokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.SliderPage;

public class SliderTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        SliderPage = PageFactory.initElements(driver, SliderPage.class);
    }

    @Test
    public void testSlider () {
        SliderPage.moveSlider();
        Assert.assertTrue(SliderPage.verifyAmount("10"), "Amounts different.");
    }

}

