package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class StoreAppHomePage {

    public StoreAppHomePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@title='Contact Us']")
    public WebElement contactUsButton;

    @FindBy(xpath = "//a[@class='login']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[@class='price product-price']")
    public List<WebElement> prices;

    @FindBy(xpath = "//ul[@id='homefeatured']//a[@data-id-product='1']")
    public WebElement addToCartItem1;

    @FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']//h2")
    public WebElement addCartSuccessMessage;

    @FindBy(xpath = "//ul[@id='homefeatured']/li")
    public WebElement item1;

    @FindBy(id = "layer_cart_product_quantity")
    public WebElement quantity;

    @FindBy(id = "layer_cart_product_price")
    public WebElement totalPrice;

    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//div/a[@title='Add to cart'])[2]")
    public WebElement addToCartItem2;

    @FindBy(xpath = "(//img[@title='Blouse'])[1]")
    public WebElement item2;




}
