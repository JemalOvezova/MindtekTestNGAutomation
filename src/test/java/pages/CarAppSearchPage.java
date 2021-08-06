package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class CarAppSearchPage {
    public CarAppSearchPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//[@id='phx-Fpg6jRZ2b8bP6cSl']/form/input")
    public WebElement searchButton;
    @FindBy(xpath = "//h1[@class='sds-heading--1 sds-page-section__title']")
    public WebElement titleButton;
}
