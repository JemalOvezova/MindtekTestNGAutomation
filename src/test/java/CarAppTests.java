import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarAppHomePage;
import pages.CarAppSearchPage;
import pages.CarAppServiceRepairPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class CarAppTests {
    WebDriver driver = Driver.getDriver();
    @Test
    public void test1(){
        //Verify recalls search
        driver.get(ConfigReader.getProperty("CarsAppURL"));
        CarAppHomePage carAppHomePage=new CarAppHomePage();
        CarAppSearchPage carAppSearchPage=new CarAppSearchPage();
        CarAppServiceRepairPage carAppServiceRepairPage=new CarAppServiceRepairPage();
        carAppHomePage.serviceRepairButton.click();
        BrowserUtils.selectByValue(carAppServiceRepairPage.selectCarType,"acura");
        BrowserUtils.selectByValue(carAppServiceRepairPage.modelSelectButton,"cl");
        BrowserUtils.selectByValue(carAppServiceRepairPage.yearSelectButton,"2003");
        carAppServiceRepairPage.searchButton.click();

        String actualResult=driver.getTitle();
        System.out.println(actualResult);
        String expectedResult="2003 Acura CL Recalls | Cars.com";

        Assert.assertEquals(actualResult,expectedResult);
    }
}
