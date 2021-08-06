package pages;


    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
    import utilities.Driver;

    public class CarAppServiceRepairPage {

        public CarAppServiceRepairPage(){
            WebDriver driver= Driver.getDriver();
            PageFactory.initElements(driver,this);
        }
        @FindBy(id = "make-select")
        public WebElement selectCarType;

        @FindBy(id = "model-select")
        public WebElement modelSelectButton;

        @FindBy(id = "year-select")
        public WebElement yearSelectButton;

        @FindBy(xpath = "//button[@class='sds-button--fluid']")
        public WebElement searchButton;

        @FindBy(xpath = "//h1[@class='sds-heading--1 sds-page-section__title recall-header']")
        public WebElement titlePage;
    }

