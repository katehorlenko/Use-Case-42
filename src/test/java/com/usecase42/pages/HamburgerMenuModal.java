package com.usecase42.pages;

import org.openqa.selenium.By;

public class HamburgerMenuModal extends BingHomePage {
    public HamburgerMenuModal() {
        super();
    }

    private final By settingsLink = By.xpath("//div[@class='hb_title_col' and text()='Settings']");
    private final By moreLink = By.xpath("//div[@class='hb_title_col' and text()='More']");

    public SettingsPage navigateToSettingsPage() {
        waitAndClickElement(settingsLink);
        waitAndClickElement(moreLink);

        return new SettingsPage();
    }


}
