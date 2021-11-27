package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class ShoppingCartPage extends BasePage {
  @FindBy(xpath = "//a[text()= 'Checkout']")
  private WebElement checkoutButton;
}
