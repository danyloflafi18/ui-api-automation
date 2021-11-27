package ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import ui.pages.AfterCheckoutPage;

import static org.junit.Assert.assertTrue;
public class AfterCheckoutSteps {
  @Inject
  private AfterCheckoutPage afterCheckoutPage;

  @Then("at After Checkout page user sees 'Your order has been placed' title")
  public void atAfterCheckoutPageUserSeesYourOrderHasBeenPlacedTitle() {
    assertTrue(afterCheckoutPage.getYourOrderHasBeenPlacedText().isDisplayed());
  }
}
