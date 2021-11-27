package ui.om.run;

import com.google.inject.Inject;
import com.kw.auto.driver.DriverConfig;
import com.kw.auto.driver.WebDriverFactory;
import com.kw.auto.driver.WebDriverRunner;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriverException;
import ui.steps.BaseSteps;
import ui.utils.DataGenerator;
import ui.utils.DataHolder;

import java.util.concurrent.TimeUnit;


@Log4j2
@ScenarioScoped
public final class Hooks {
  @Inject
  private DriverConfig config;

  @Before(order = 1)
  public void seUpDriver(final Scenario scenario) {
    try {
      WebDriverRunner.setWebDriver(new WebDriverFactory().createDriver(config));
    } catch (WebDriverException e) {
      log.error(e.getMessage());
      WebDriverRunner.setWebDriver(new WebDriverFactory().createDriver(config));
    }
    WebDriverRunner.getWebDriver().manage().window().maximize();
  }

  @Before(order = 2)
  public void setDataHolder() {
    BaseSteps.setDataHolder(new DataHolder());
    BaseSteps.getDataHolder().setCurrentUser(DataGenerator.getUser());
  }

  @Before(order = 3)
  public void declareDriverWaits() {
    WebDriverRunner.getWebDriver().manage().timeouts()
            .pageLoadTimeout(30, TimeUnit.SECONDS)
            .implicitlyWait(WebDriverRunner.DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
  }

  @After(order = 1)
  public void ensureDriverQuit() {
    if (WebDriverRunner.getWebDriver() != null) {
      WebDriverRunner.getWebDriver().quit();
    }
  }

}
