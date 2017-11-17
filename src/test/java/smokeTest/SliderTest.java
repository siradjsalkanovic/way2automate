package smokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.sliderPage;

public class SliderTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        sliderPage = PageFactory.initElements(driver, sliderPage.class);
    }

    @Test
    public void testSlider () {
        sliderPage.moveSlider();
        Assert.assertTrue(sliderPage.verifyAmount("10"), "Amounts different.");
    }

}

