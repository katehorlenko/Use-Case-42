package com.usecase42.tests;

import com.usecase42.pages.BingHomePage;
import com.usecase42.pages.ChatPage;
import com.usecase42.pages.SearchResultPage;
import com.usecase42.pages.SettingsPage;
import com.usecase42.runner.BaseTestRunner;
import com.usecase42.util.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Bing Web Tests")
public class BingTest extends BaseTestRunner {
    private static final Logger logger = LogManager.getLogger(BingTest.class);

    @Test
    @Story("Search Functionality")
    @Description("Search for 'weather in Lviv' and verify results.")
    public void testWeatherSearch() {
        BingHomePage bingHomePage = openBingHomePage();
        String textForSearch = "weather in Lviv";
        performSearch(bingHomePage, textForSearch);
        verifySearchResults(textForSearch);
    }

    @Test
    @Story("Settings Navigation")
    @Description("Navigate to 'More Settings' and verify redirection.")
    public void testNavigateToSettings() {
        BingHomePage page = openBingHomePage();
        SettingsPage settingsPage = navigateToMoreSettings(page);
        verifySettingsPage(settingsPage);
    }

    @Test
    @Story("Chat Functionality")
    @Description("Click on Chat link and verify pop-up.")
    public void testChatLink() {
        BingHomePage bingHomePage = openBingHomePage();
        clickChatLink(bingHomePage);
        verifyChatPopup();
    }

    @Step("Open bing home page")
    private BingHomePage openBingHomePage() {
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bing.com");
        BingHomePage bingHomePage = new BingHomePage();

        Assert.assertEquals(bingHomePage.getTitle(), "Bing", "Bing homepage title does not match expected value.");
        Assert.assertTrue(bingHomePage.isSearchBoxPresent(), "Bing search box is not present on the page.");

        return bingHomePage;
    }

    @Step("Perform search for {textForSearch}")
    private void performSearch(BingHomePage page, String textForSearch) {
        logInfo(Thread.currentThread().getName() + ": Searching for: " + textForSearch);
        page.search(textForSearch);
    }

    @Step("Verify search results for {textForSearch}")
    private void verifySearchResults(String textForSearch) {
        SearchResultPage page = new SearchResultPage();
        Assert.assertTrue(page.doesTitleContain(textForSearch));
    }

    @Step("Navigate to More Settings")
    private SettingsPage navigateToMoreSettings(BingHomePage page) {
        logInfo(Thread.currentThread().getName() + ": Navigating to 'More Settings'...");
        return page.openHamburgerMenu().navigateToSettingsPage();
    }

    @Step("Verify Settings Page is displayed")
    private void verifySettingsPage(SettingsPage page) {
        logInfo(Thread.currentThread().getName() + ": Verifying settings page...");
        Assert.assertTrue(page.isSettingsPageTitleDisplayed(), "Settings page is not opened");
    }

    @Step("Click on Chat link")
    private void clickChatLink(BingHomePage page) {
        logInfo(Thread.currentThread().getName() + ": Clicking Chat link...");
        page.clickChatLink();
    }

    @Step("Verify Chat Popup is displayed")
    private void verifyChatPopup() {
        ChatPage page = new ChatPage();
        logInfo(Thread.currentThread().getName() + ": Verifying chat pop-up...");
        Assert.assertTrue(page.isChatPopupDisplayed(), "Chat pop-up should be opened");
    }

    private void logInfo(String message) {
        logger.info(message);
    }
}
