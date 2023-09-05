package com.Adidas.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType) {

        WebDriver driver=null;

        switch (browserType.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                firefoxdriver().setup();
                break;
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");

                driver = new ChromeDriver(options);
               chromedriver().setup();
                break;
            case "edge":
                driver = new EdgeDriver();
                edgedriver().setup();
                break;
            case "safari":
                driver = new SafariDriver();
                safaridriver().setup();
                break;
        }
        return driver;
    }
}
