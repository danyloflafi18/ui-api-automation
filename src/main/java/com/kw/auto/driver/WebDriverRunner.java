package com.kw.auto.driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public final class WebDriverRunner {
    public static final int DEFAULT_IMPLICIT_TIMEOUT = 15;
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    private WebDriverRunner() {
    }

    public static WebDriver getWebDriver() {
        return DRIVER_THREAD_LOCAL.get();
    }

    public static void setWebDriver(final WebDriver driver) {
        DRIVER_THREAD_LOCAL.set(driver);
    }

    public static void setDefaultImplicitTimeout() {
        getWebDriver().manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }
}
