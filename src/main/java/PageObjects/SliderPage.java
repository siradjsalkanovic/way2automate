package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SliderPage {

    private WebDriver driver;

    @FindBy(css = "div#example-1-tab-1 div.freme_box iframe")
    WebElement iFrameWindow1;

    @FindBy(css="div#slider-range-max")
    WebElement sliderMain;

    @FindBy(css="div#slider-range-max span")
    WebElement sliderHandle;

    @FindBy(css="input#amount")
    WebElement sliderValue;

    @FindBy(linkText = "Registration")
    WebElement clikRegistration;


    public SliderPage(WebDriver driver){
        this.driver = driver;
    }

    public SliderPage moveSlider(){

        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(iFrameWindow1));

        driver.switchTo().frame(iFrameWindow1);

        int sliderWidth = sliderMain.getSize().width;
        //System.out.println(sliderWidth);

        int xPosition = sliderHandle.getLocation().getX();
        //System.out.println(xPosition);

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(sliderHandle,sliderWidth-xPosition,0).perform();

        return PageFactory.initElements(driver, SliderPage.class);
    }

    public Boolean verifyAmount (String value) {
        String amount = sliderValue.getAttribute("value");
        Boolean result = amount.equals(value);
        driver.switchTo().defaultContent();
        return result;
    }

    public SliderPage clickRegistrationLink(){
        clikRegistration.click();
        return PageFactory.initElements(driver, SliderPage.class);

    }






}
