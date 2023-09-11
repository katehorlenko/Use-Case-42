package com.usecase42.runner;

import com.usecase42.util.DriverManager;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

public class BaseTestRunner {

    @BeforeMethod
    public void setup() {
        ThreadContext.put("threadName", Thread.currentThread().getName());
        ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless"); // This runs Chrome in headless mode, remove if not needed
        options.addArguments("--disable-gpu"); // Applicable to Windows OS only
        options.addArguments("--disable-extensions"); // Disabling extensions
        options.addArguments("--no-sandbox"); // Bypass OS security model
        WebDriver driver = new ChromeDriver(options);

        DriverManager.setDriver(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        ThreadContext.clearAll();

        if (ITestResult.SUCCESS != result.getStatus()) {
            attachScreenshot();
        }
        DriverManager.closeDriver();
    }

    private void attachScreenshot() {
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot on failure", "image/png", new ByteArrayInputStream(screenshot), ".png");
    }
}
