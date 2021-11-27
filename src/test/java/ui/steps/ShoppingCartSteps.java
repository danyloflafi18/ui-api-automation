package ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import ui.pages.ShoppingCartPage;
public class ShoppingCartSteps extends BaseSteps {
  @Inject
  private ShoppingCartPage shoppingCartPage;

  @And("at Shopping Cart page user clicks on 'Checkout' button")
  public void atShoppingCartPageUserClicksOnCheckoutButton() {
    shoppingCartPage.getCheckoutButton().click();
  }
}
