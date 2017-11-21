package SmokeTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.DroppablePage;

public class DroppableTest extends TestBase{

    @BeforeTest(alwaysRun = true)
    public void setup() {
        DroppablePage = PageFactory.initElements(driver, DroppablePage.class);
    }

    @Test
    public void testDroppable () {
        DroppablePage.dragDrop();
        Assert.assertTrue(DroppablePage.checkDragDropSuccess());

    }
}

