package com.usecase42.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HamburgerMenuModal extends BingHomePage{
    public HamburgerMenuModal(WebDriver driver) {
        super(driver);
    }
    private By settingsLink = By.xpath("//div[@class='hb_title_col' and text()='Settings']");
    private By moreLink = By.xpath("//div[@class='hb_title_col' and text()='More']");

    public SettingsPage navigateToSettingsPage() {
        waitAndClickElement(settingsLink);
        waitAndClickElement(moreLink);

        return new SettingsPage(driver);
    }
}
