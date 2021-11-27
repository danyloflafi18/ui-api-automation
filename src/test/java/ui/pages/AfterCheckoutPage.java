package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class AfterCheckoutPage extends BasePage {
  @FindBy(id = "content")
  private WebElement yourOrderHasBeenPlacedText;
}
