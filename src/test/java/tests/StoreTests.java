package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StoreAppContactUsPage;
import pages.StoreAppHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

public class StoreTests extends TestBase {


    // Positive scenario for contact us
    @Test(groups = {"regression","smoke"})
    public void test1(){
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppContactUsPage storeAppContactUsPage = new StoreAppContactUsPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.contactUsButton.click();
        Select select = new Select(storeAppContactUsPage.subjectHeadingDropdown);
        select.selectByValue("2");
        storeAppContactUsPage.email.sendKeys("123@gmail.com");
        String projectPath = System.getProperty("user.dir"); // /Users/jemalovezdurdyyeva/IdeaProjects/MindtekTestNGAutomation
        System.out.println("Path for our project is: "+projectPath);
        storeAppContactUsPage.fileUpload.sendKeys(projectPath+"/src/test/resources/testdata/MyImage.jpeg");

        storeAppContactUsPage.message.sendKeys("Hello World");
        storeAppContactUsPage.submitButton.click();

        String actualSuccessMessage = storeAppContactUsPage.successMessage.getText();
        String expectedSuccessMessage = "Your message has been successfully sent to our team.";

        Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);
    }

    // Negative scenario for contact us
    @Test(groups = {"regression","smoke"})
    public void test2(){
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppContactUsPage storeAppContactUsPage = new StoreAppContactUsPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.contactUsButton.click();
        Select select = new Select(storeAppContactUsPage.subjectHeadingDropdown);
        select.selectByValue("2");
        storeAppContactUsPage.email.sendKeys("123@gmail.com");
        String projectPath = System.getProperty("user.dir"); // /Users/jemalovezdurdyyeva/IdeaProjects/MindtekTestNGAutomation
        System.out.println("Path for our project is: "+projectPath);
        storeAppContactUsPage.fileUpload.sendKeys(projectPath+"/src/test/resources/testdata/MyImage.jpeg");
        storeAppContactUsPage.submitButton.click();

        String actualErrorMessage = storeAppContactUsPage.errorMessage.getText();
        String expectedErrorMessage = "The message cannot be blank.";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }


}
