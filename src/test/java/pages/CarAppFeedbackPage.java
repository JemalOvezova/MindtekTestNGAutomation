package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CarAppFeedbackPage {

    public CarAppFeedbackPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "QID1-5-label")
    public WebElement loveButton;

    @FindBy(name = "survey-iframe-SI_1TBB7Wwk1H3W7v7")
    public WebElement iframeFeedback;

    @FindBy(id = "NextButton")
    public WebElement nextButton;
}
