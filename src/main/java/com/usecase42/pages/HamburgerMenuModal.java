package com.usecase42.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HamburgerMenuModal extends BingHomePage{
    public HamburgerMenuModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='hb_title_col' and text()='Settings']")
    private WebElement settingsLink;

    @FindBy(xpath = "//div[@class='hb_title_col' and text()='More']")
    private WebElement moreLink;

    public SettingsPage navigateToSettingsPage() {
        waitAndClickElement(settingsLink);
        waitAndClickElement(moreLink);

        return new SettingsPage(driver);
    }
}
