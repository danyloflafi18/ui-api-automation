package com.kw.auto.driver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static java.util.Arrays.asList;

@Log4j2
public final class WebDriverFactory {

    private final List<IDriverFactory> factories = asList(
            new ChromeDriverFactory(),
            new FirefoxDriverFactory()
    );


    public WebDriver createDriver(final DriverConfig config) {
        return factories.stream()
                .filter(factory -> factory.supports(config))
                .findAny()
                .map(f -> f.create(config))
                .orElseGet(() -> new ChromeDriverFactory().create(config));
    }
}
