package com.usecase42.test;

import com.usecase42.pages.BingHomePage;
import com.usecase42.pages.ChatPage;
import com.usecase42.pages.SearchResultPage;
import com.usecase42.pages.SettingsPage;
import com.usecase42.util.DriverManager;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.usecase42.util.ScreenshotUtil.attachScreenshot;

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
        String textForSearch = "weather in Lviv";
        logInfo("Searching for: " + textForSearch);
        SearchResultPage page = bingHomePage.search(textForSearch);

        Assert.assertTrue(page.doesTitleContain(textForSearch));
    }

    @Test
    @Description("Navigate to 'More Settings' and verify redirection.")
    public void testNavigateToSettings() {
        logInfo("Navigating to 'More Settings'...");
        SettingsPage page = bingHomePage
                .openHamburgerMenu()
                .navigateToSettingsPage();

        logInfo("Verifying settings page...");
        Assert.assertTrue(page.isSettingsPageTitleDisplayed(), "Settings page is not opened");
    }

    @Test
    @Description("Click on Chat link and verify pop-up.")
    public void testChatLink() {
        logInfo("Clicking Chat link...");
        ChatPage page = bingHomePage.clickChatLink();

        logInfo("Verifying chat pop-up...");
        Assert.assertTrue(page.isChatPopupDisplayed(), "Chat pop-up should be opened");
    }

    private void logInfo(String message) {
        logger.info(message);
    }

    @AfterMethod
    public void afterEachTest(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            attachScreenshot(driver);
        }
        logInfo("Closing the browser...");
        DriverManager.closeDriver();
    }
}
