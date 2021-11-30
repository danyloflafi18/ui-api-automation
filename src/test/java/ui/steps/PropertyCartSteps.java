package ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import ui.pages.BasePage;
import ui.pages.PropertyCartPage;

import static org.junit.Assert.assertTrue;
import static ui.utils.ElementUtils.click;
import static ui.utils.UserWaitsForResult.timeout;
public class PropertyCartSteps extends BasePage {
  @Inject
  PropertyCartPage propertyCartSteps;
  @And("at Property Cart page user confirms purchase")
  public void atPropertyCartPageUserConfirmsPurchase() {
    timeout(2000);
    click(propertyCartSteps.getAddToCartButton());
    assertTrue(propertyCartSteps.getSuccessAlert().isDisplayed());
  }
}
