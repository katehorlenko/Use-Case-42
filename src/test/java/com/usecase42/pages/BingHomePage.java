package com.usecase42.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class BingHomePage extends BasePage {
    // Constructor
    public BingHomePage() {
        super();
    }

    private final By searchBox = By.name("q");
    private final By chatLink = By.xpath("//div[@class='icon']/img");
    private final By hamburgerMenu = By.id("id_sc");

    public SearchResultPage search(String searchTerm) {
        driver.findElement(searchBox).sendKeys(searchTerm, Keys.ENTER);
        return new SearchResultPage();
    }

    public ChatPage clickChatLink() {
        waitAndClickElement(chatLink);
        return new ChatPage();
    }

    public HamburgerMenuModal openHamburgerMenu() {
        waitAndClickElement(hamburgerMenu);
        driver.findElement(hamburgerMenu).getAttribute("aria-expanded").equals(true);
        return new HamburgerMenuModal();
    }

    public boolean isSearchBoxPresent() {
        return driver.findElement(searchBox).isDisplayed();
    }
}
