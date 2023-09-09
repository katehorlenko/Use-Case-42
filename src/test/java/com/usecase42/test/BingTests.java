package com.usecase42.test;

import com.usecase42.pages.BingHomePage;
import com.usecase42.util.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BingTests {

    private WebDriver driver;
    private BingHomePage bingHomePage;
    private static final Logger logger = LogManager.getLogger(BingTests.class);

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bing.com/");
        bingHomePage = new BingHomePage(driver);
    }

    @Test
    @Description("Search for 'weather in Lviv' and verify results.")
    public void testWeatherSearch() {
        logInfo("Searching for 'weather in Lviv'...");
        bingHomePage.search("weather in Lviv");
        verifyWeatherSearchResults();
    }

    @Step("Verify weather search results.")
    private void verifyWeatherSearchResults() {
        logInfo("Verifying search results...");
        Assert.assertTrue(driver.getPageSource().contains("weather in Lviv"));
    }

    @Test
    @Description("Click on Chat link and verify pop-up.")
    public void testChatLink() {
        logInfo("Clicking Chat link...");
        bingHomePage.clickChatLink();
        verifyChatPopup();
    }

    @Step("Verify chat pop-up.")
    private void verifyChatPopup() {
        logInfo("Verifying chat pop-up...");
        Assert.assertTrue(bingHomePage.isChatPopupDisplayed());
    }

    @Test
    @Description("Navigate to 'More Settings' and verify redirection.")
    public void testNavigateToSettings() {
        logInfo("Navigating to 'More Settings'...");
        bingHomePage.navigateToMoreSettings();
        verifySettingsPage();
    }

    @Step("Verify settings page.")
    private void verifySettingsPage() {
        logInfo("Verifying settings page...");
        Assert.assertTrue(bingHomePage.isSettingsPageTitleDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        logInfo("Closing the browser...");
        DriverManager.closeDriver();
    }

    private void logInfo(String message) {
        logger.info(message);
    }
}
