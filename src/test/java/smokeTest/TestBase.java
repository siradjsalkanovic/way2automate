package smokeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    protected String baseUrl;
    protected HomePage HomePage;
    protected DatepickerPage DatepickerPage;
    protected SignInPage SignInPage;
    protected SelectablePage SelectablePage;
    protected AlertsPage AlertsPage;
    protected DroppablePage DroppablePage;
    protected SliderPage SliderPage;

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
