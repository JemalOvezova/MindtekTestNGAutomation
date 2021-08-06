package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarAppFeedbackPage;
import pages.CarAppHomePage;
import pages.CarAppSearchPage;
import pages.CarAppServiceRepairPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.TestBase;

public class CarTest extends TestBase {
    @Test
    public void test1() {
        //Negative test case
        driver.get(ConfigReader.getProperty("CarsAppURL"));
        CarAppHomePage carAppHomePage = new CarAppHomePage();
        CarAppSearchPage carAppSearchPage = new CarAppSearchPage();
        BrowserUtils.selectByValue(carAppHomePage.newUsedButton, "new");
        BrowserUtils.selectByValue(carAppHomePage.carTypeButton, "acura");
        BrowserUtils.selectByValue(carAppHomePage.priceButton, "20000");
        carAppHomePage.zipCodeBox.sendKeys("ab0");
        carAppHomePage.searchButton.click();
        String actualResult = driver.getTitle();
        System.out.println(actualResult);
        String expectedResult = "invalid zip code";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test2() {
        //Verify user can search
        //Positive test case
        driver.get(ConfigReader.getProperty("CarsAppURL"));
        CarAppHomePage carAppHomePage = new CarAppHomePage();
        CarAppSearchPage carAppSearchPage = new CarAppSearchPage();
        BrowserUtils.selectByValue(carAppHomePage.newUsedButton, "new");
        BrowserUtils.selectByValue(carAppHomePage.carTypeButton, "acura");
        BrowserUtils.selectByValue(carAppHomePage.priceButton, "20000");
        carAppHomePage.searchButton.click();
        String actualResult = driver.getTitle();
        System.out.println(actualResult);
        String expectedResult = "New Acura for Sale Near Me | Cars.com";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test3() {
        driver.get(ConfigReader.getProperty("CarsAppURL"));
        CarAppHomePage carAppHomePage = new CarAppHomePage();
        CarAppSearchPage carAppSearchPage = new CarAppSearchPage();
        carAppHomePage.newsAndVideosButton.click();
        carAppSearchPage.searchButton.click();
        //carAppHomePage.searchButton.sendKeys("2014");
    }
    @Test
    public void test4(){
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
    @Test
    public void test5() {
        driver.get(ConfigReader.getProperty("CarsAppURL"));
        CarAppHomePage carAppHomePage = new CarAppHomePage();
        CarAppFeedbackPage carAppFeedbackPage = new CarAppFeedbackPage();
        carAppHomePage.feedbackButton.click();
        driver.switchTo().frame(carAppFeedbackPage.iframeFeedback);
        carAppFeedbackPage.loveButton.click();
        carAppFeedbackPage.nextButton.click();

    }
}