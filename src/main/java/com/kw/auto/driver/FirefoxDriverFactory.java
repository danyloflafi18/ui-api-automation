package com.kw.auto.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory implements IDriverFactory {

    @Override
    public boolean supports(final DriverConfig config) {
        return config.browser.equals("firefox");
    }

    @Override
    public WebDriver create(final DriverConfig config) {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
