package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class PropertyCartPage extends BasePage {
  @FindBy(id = "button-cart")
  private WebElement addToCartButton;
}
