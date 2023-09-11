package com.usecase42.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingHomePage extends BasePage {
    // Constructor
    public BingHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='icon']/img")
    private WebElement chatLink;

    private By hamburgerMenu = By.id("id_sc");

    public SearchResultPage search(String searchTerm) {
        searchBox.sendKeys(searchTerm, Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public ChatPage clickChatLink() {
        chatLink.click();
        return new ChatPage(driver);
    }

    public HamburgerMenuModal openHamburgerMenu() {
        waitAndClickElement(hamburgerMenu);
        return new HamburgerMenuModal(driver);
    }
}
