package com.usecase42.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatPage extends BasePage {
    public ChatPage() {
        super();
    }

    @FindBy(xpath = "//a[text()='Chat']")
    private WebElement chatPopup;

    public boolean isChatPopupDisplayed() {
        return chatPopup.isDisplayed();
    }
}
