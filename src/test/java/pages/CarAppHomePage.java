package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CarAppHomePage {
    public CarAppHomePage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[contains(text(),'News & Videos')]")
    public WebElement newsAndVideosButton;

    @FindBy(id = "make-model-search-stocktype")
    public WebElement newUsedButton;

    @FindBy(id = "makes")
    public WebElement carTypeButton;

    @FindBy(id = "make-model-max-price")
    public WebElement priceButton;

    @FindBy(xpath = "//button[@data-activity-rule-type='page-over-page'][1]")
    public WebElement searchButton;

    @FindBy(xpath = "//a[@data-linkname='header-service']")
    public WebElement serviceRepairButton;

    @FindBy(id = "make-model-zip")
    public WebElement zipCodeBox;

    @FindBy(id = "slider-control-SI_1TBB7Wwk1H3W7v7")
    public WebElement feedbackButton;
}

