package ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import ui.pages.AfterLogoutPage;

import static org.junit.Assert.assertTrue;
public class AfterLogoutSteps extends BaseSteps {
  @Inject
  private AfterLogoutPage afterLogoutPage;

  @Then("at After Logout page user sees 'Account Logout' title")
  public void atAfterLogoutPageUserSeesAccountLogoutTitle() {
    assertTrue(afterLogoutPage.getAccountLogoutText().isDisplayed());
  }
}
