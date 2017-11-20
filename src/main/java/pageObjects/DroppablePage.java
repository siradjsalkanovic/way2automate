package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DroppablePage {
    private WebDriver driver;

    @FindBy(css = "div#example-1-tab-1 div.freme_box iframe")
    WebElement iFrameWindow1;

    @FindBy(css="div#draggable")
    WebElement draggableDiv;

    @FindBy(css = "div#droppable")
    WebElement droppableDiv;

    @FindBy(linkText = "Slider")
    WebElement clickSlider;


    public DroppablePage(WebDriver driver){
        this.driver = driver;
    }

    public DroppablePage dragDrop () {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(iFrameWindow1));

        driver.switchTo().frame(iFrameWindow1);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableDiv, droppableDiv).perform();

        driver.switchTo().defaultContent();
        return PageFactory.initElements(driver, DroppablePage.class);
    }

    public DroppablePage clickSliderLink(){

        clickSlider.click();
        return PageFactory.initElements(driver, DroppablePage.class);
    }

    public Boolean checkDragDropSuccess(){

        driver.switchTo().frame(iFrameWindow1);
        Boolean result = droppableDiv.getAttribute("class").contains("ui-state-highlight");
        System.out.println(result);
        driver.switchTo().defaultContent();
        return result;
    }


}
