package smokeTest;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DroppablePage;

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

