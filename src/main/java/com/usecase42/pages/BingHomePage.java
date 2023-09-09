package com.usecase42.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BingHomePage {

    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='icon']/img")
    private WebElement chatLink;

    @FindBy(id = "id_sc")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//div[@class='hb_title_col' and text()='Settings']")
    private WebElement settingsLink;

    @FindBy(xpath = "//div[@class='hb_title_col' and text()='More']")
    private WebElement moreLink;

    @FindBy(xpath = "//a[text()='Chat']")
    private WebElement chatPopup;

    @FindBy(xpath = "//h2[text()='Settings']")
    private WebElement settingsPageTitle;

    // Constructor
    public BingHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search(String searchTerm) {
        searchBox.sendKeys(searchTerm, Keys.ENTER);
    }

    public void clickChatLink() {
        chatLink.click();
    }

    public void navigateToMoreSettings() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu));
        hamburgerMenu.click();
        settingsLink.click();
        moreLink.click();
    }

    public boolean isSettingsPageTitleDisplayed() {
        return settingsPageTitle.isDisplayed();
    }

    public boolean isChatPopupDisplayed() {
        return chatPopup.isDisplayed();
    }
}
