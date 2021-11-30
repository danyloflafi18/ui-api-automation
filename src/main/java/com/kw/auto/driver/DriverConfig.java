package com.kw.auto.driver;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class DriverConfig {
    public String browser = System.getProperty("browser", "chrome");
}
