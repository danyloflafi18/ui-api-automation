package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class PropertyCartPage extends BasePage {
  @FindBy(css = "button#button-cart")
  private WebElement addToCartButton;
  @FindBy(xpath = "//div[text()='Success: You have added ']")
  private WebElement successAlert;
}
