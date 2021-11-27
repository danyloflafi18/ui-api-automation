package com.kw.auto.driver;

import org.openqa.selenium.WebDriver;

public interface IDriverFactory {
    boolean supports(DriverConfig config);

    WebDriver create(DriverConfig config);
}
