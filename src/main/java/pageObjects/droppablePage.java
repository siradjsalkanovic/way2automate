package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class droppablePage {
    private WebDriver driver;

    @FindBy(css = "div#example-1-tab-1 div.freme_box iframe")
    WebElement iFrameWindow1;

    @FindBy(css="div#draggable")
    WebElement draggableDiv;

    @FindBy(css = "div#droppable")
    WebElement droppableDiv;

    @FindBy(linkText = "Slider")
    WebElement clickSlider;


    public droppablePage(WebDriver driver){
        this.driver = driver;
    }

    public droppablePage dragDrop () {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(iFrameWindow1));

        driver.switchTo().frame(iFrameWindow1);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableDiv, droppableDiv).perform();

        driver.switchTo().defaultContent();
        return PageFactory.initElements(driver, droppablePage.class);
    }

    public droppablePage clickSliderLink(){

        clickSlider.click();
        return PageFactory.initElements(driver, droppablePage.class);
    }


}
