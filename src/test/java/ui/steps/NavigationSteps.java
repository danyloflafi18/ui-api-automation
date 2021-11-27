package ui.steps;

import com.kw.auto.driver.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;

import static com.kw.auto.utils.PropertyUtils.*;
import static java.lang.String.format;
import static junit.framework.TestCase.assertTrue;

@Log4j2
public final class NavigationSteps extends BaseSteps {

  private static String getBaseUrl() {
    return getProperties().getProperty(BASE_URL);
  }

  private void open(final String url) {
    WebDriverRunner.getWebDriver().get(url);
  }

  @Given("user navigates to home page")
  public void userNavigatesToHomePage() {
    open(getBaseUrl());
  }

  @Then("user is navigated to Main page and URL contains {string}")
  public void userIsNavigatedToMainPage(String urlPart) {
    String mainPageUrlPart = urlPart;
    String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
    assertTrue(format("\nUrl should contain: [%s] \nbut was: [%s]", mainPageUrlPart, currentUrl),
            currentUrl.contains(mainPageUrlPart));
  }
}
