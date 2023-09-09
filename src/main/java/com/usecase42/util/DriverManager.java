package com.usecase42.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            // Example for Chrome, but can be extended for other browsers
            webDriver.set(new ChromeDriver());
        }
        return webDriver.get();
    }

    public static void closeDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}

