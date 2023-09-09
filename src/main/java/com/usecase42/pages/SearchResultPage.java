package com.usecase42.pages;

import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean doesTitleContain(String text) {
        return this.getTitle().contains(text);
    }
}
