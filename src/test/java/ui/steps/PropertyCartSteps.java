package ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import ui.pages.PropertyCartPage;
public class PropertyCartSteps extends BasePage {
  @Inject
  PropertyCartPage propertyCartSteps;
  @And("at Property Cart page user confirms purchase")
  public void atPropertyCartPageUserConfirmsPurchase() {
    WebElement addToCartButton = propertyCartSteps.getAddToCartButton();
    getJavaScriptProvider().scrollTo(addToCartButton);
    addToCartButton.click();
  }
}
