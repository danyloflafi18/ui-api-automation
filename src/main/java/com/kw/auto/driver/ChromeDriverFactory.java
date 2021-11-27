package com.kw.auto.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeDriverFactory implements IDriverFactory {
    @Override
    public boolean supports(final DriverConfig config) {
        return (config.remote == null || config.remote.isEmpty()) && config.browser.equals("chrome");
    }

    @Override
    public WebDriver create(final DriverConfig config) {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation", 1);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }
}
