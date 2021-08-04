package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StoreAppCreateAccountPage;
import pages.StoreAppHomePage;
import pages.StoreAppLoginPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.DataUtils;
import utilities.TestBase;

import java.util.Random;

public class StoreRegisterFunctionalityTests extends TestBase {

    // Data Driven Testing -> testing functionality with different sets of data.

    @DataProvider(name = "signUpDataProvider")
    public static Object[][] testData() {
        Object[][] data = new Object[][]{// two dimentional array
                {"John", "Doe", "123456789", DataUtils.generateRandomNumber(30)+"", "1", "2021", "123 Clark street", "Chicago", "13", "12345", "21", "123456789"},
                {"Kim", "Mi", "bchfjsk", "1", "12", "1980", "234 clark str", "New York", "32", "54321", "21", "987654321"}// we can add as much as we want
        };
        return data;
    }
    @Test(dataProvider = "signUpDataProvider", groups = {"regression", "smoke"})
    public void test1(String firstName, String lastName, String password, String day, String month, String year,
                      String address, String city, String state, String zipCode, String country, String phoneNumber) {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppLoginPage storeAppLoginPage = new StoreAppLoginPage();
        StoreAppCreateAccountPage storeAppCreateAccountPage = new StoreAppCreateAccountPage();

        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.loginButton.click();
        storeAppLoginPage.emailBox.sendKeys(DataUtils.generateEmail());
        storeAppLoginPage.submitButton.click();
        storeAppCreateAccountPage.gender.click();
        storeAppCreateAccountPage.firstNameBox.sendKeys(firstName);
        storeAppCreateAccountPage.lastNameBox.sendKeys(lastName);
        storeAppCreateAccountPage.passwordBox.sendKeys(password);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.daysBox, day);//see BrowserUtils class in Utilities package
        BrowserUtils.selectByValue(storeAppCreateAccountPage.monthsBox, month);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.yearsBox, year);
        storeAppCreateAccountPage.address1Box.sendKeys(address);
        storeAppCreateAccountPage.cityBox.sendKeys(city);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.stateBox, state);
        storeAppCreateAccountPage.postcodeBox.sendKeys(zipCode);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.countryBox, country);
        storeAppCreateAccountPage.phonemobileBox.sendKeys(phoneNumber);
        storeAppCreateAccountPage.registerButton.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "My account - My Store";
        // If it does not match actual and expected we can add 3rd parameter for reading purpose
        Assert.assertEquals(actualTitle, expectedTitle,"Actual title "+actualTitle+"did not match with expected title "+expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}