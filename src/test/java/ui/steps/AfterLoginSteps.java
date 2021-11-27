package ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import ui.pages.AfterLoginPage;

import static org.junit.Assert.assertTrue;
import static ui.utils.ElementUtils.click;
public class AfterLoginSteps extends BaseSteps {
  @Inject
  private AfterLoginPage afterLoginPage;

  @Then("at After Login page user sees 'My Account' title")
  public void atAfterLoginPageUserSeesMyAccountTitle() {
    assertTrue(afterLoginPage.getMyAccountTitle().isDisplayed());
  }

  @When("at After Login page user click 'Your Store' title")
  public void atAfterLoginPageUserClickYourStoreTitle() {
    WebElement yourStoreLogo = afterLoginPage.getYourStoreLogo();
    click(yourStoreLogo);
  }
}
