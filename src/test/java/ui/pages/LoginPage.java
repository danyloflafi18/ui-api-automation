package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class LoginPage extends BasePage{
  @FindBy(id = "input-email")
  private WebElement emailAddressInputField;
  @FindBy(id = "input-password")
  private WebElement passwordInputField;
  @FindBy(css = "input.btn")
  private WebElement logInButton;
  @FindBy(xpath = "//h2[text()='Returning Customer']")
  private WebElement returningCustomerText;
}
