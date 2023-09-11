package com.usecase42.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    /**
     * Waits for an element (located by the given locator) to be clickable and then clicks it.
     * Retries up to 3 times in the event of a StaleElementReferenceException.
     *
     * @param byLocator Locator of the WebElement to be clicked.
     */
    protected void waitAndClickElement(By byLocator) {
        final int MAX_ATTEMPTS = 3;
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
                wait.until(ExpectedConditions.elementToBeClickable(byLocator)).click();
                return; // Exit the method if the click is successful.
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }

        // If the code reaches here, it means all attempts have failed.
        throw new StaleElementReferenceException("Element not found after " + MAX_ATTEMPTS + " retries");
    }

    /**
     * Returns the title of the current page.
     *
     * @return String title of the current page.
     */
    public String getTitle() {
        return driver.getTitle();
    }
}
