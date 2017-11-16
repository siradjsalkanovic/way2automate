package smokeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected String baseUrl;
    protected homePage homePage;
    protected datepickerPage datepickerPage;
    protected signInPage signInPage;
    protected selectablePage selectablePage;
    protected alertsPage alertsPage;
    protected droppablePage droppablePage;
    protected sliderPage sliderPage;

    @BeforeSuite
    public void setUp() {
        baseUrl = "http://way2automation.com/way2auto_jquery/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }


    @AfterSuite
    public void tearDown() {
        //driver.quit();
    }
}
