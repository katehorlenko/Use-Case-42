package com.usecase42.pages;

public class SearchResultPage extends BasePage {
    public SearchResultPage() {
        super();
    }

    public boolean doesTitleContain(String text) {
        return this.getTitle().contains(text);
    }
}
