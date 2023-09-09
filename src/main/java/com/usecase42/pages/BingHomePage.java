package com.usecase42.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingHomePage {

    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(id = "sb_form_go")
    private WebElement searchButton;

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
        searchBox.sendKeys(searchTerm);
        searchButton.click();
    }

    public void clickChatLink() {
        chatLink.click();
    }

    public void navigateToMoreSettings() {
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
