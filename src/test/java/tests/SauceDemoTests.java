package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SauceDemoHomePage;
import pages.SauceDemoLoginPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class SauceDemoTests extends TestBase {

    @Test(groups = {"regression","smoke"})
    @Parameters({"username","password"})
    public void logInTest(String username, String password){
        SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
        SauceDemoHomePage sauceDemoHomePage = new SauceDemoHomePage();
        driver.get(ConfigReader.getProperty("SauceDemoURL"));
        sauceDemoLoginPage.username.sendKeys(username);
        sauceDemoLoginPage.password.sendKeys(password);
        sauceDemoLoginPage.loginButton.click();
        String actualPageTitle = sauceDemoHomePage.pageTitle.getText();
        String expectedPageTitle = "PRODUCTS";
        Assert.assertEquals(actualPageTitle,expectedPageTitle);

    }
}
