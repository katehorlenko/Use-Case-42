package com.usecase42.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage {
    public SettingsPage() {
        super();
    }

    @FindBy(xpath = "//h2[text()='Settings']")
    private WebElement settingsPageTitle;


    public boolean isSettingsPageTitleDisplayed() {
        return settingsPageTitle.isDisplayed();
    }
}
