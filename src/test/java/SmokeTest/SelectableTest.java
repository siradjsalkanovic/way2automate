package SmokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.*;

public class SelectableTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        SelectablePage = PageFactory.initElements(driver, SelectablePage.class);
    }

    @Test
    public void testSelectableFirstIteration () {
        SelectablePage.selectOptionIterator();
    }

    @Test(dependsOnMethods = "testSelectableFirstIteration")
    public void testSelectableDisplayAsGrid () {
        SelectablePage.selectTabDisplayAsGrid();
    }

    @Test(dependsOnMethods = "testSelectableDisplayAsGrid")
    public void testSelectableSecondIteration () {
        SelectablePage.selectOptionIterator2();
    }

    @Test(dependsOnMethods = "testSelectableSecondIteration")
    public void testSelectableTabSerialize () {
        SelectablePage.selectTabSerialize();
    }

    @Test(dependsOnMethods = "testSelectableTabSerialize")
    public void testSelectableThirdIterator () {
        SelectablePage.selectOptionIterator3();
    }


}

