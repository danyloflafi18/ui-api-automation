package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class SignUpPage extends BasePage {
  @FindBy(id = "input-firstname")
  private WebElement firstNameInputField;
  @FindBy(id = "input-lastname")
  private WebElement lastNameInputField;
  @FindBy(id = "input-email")
  private WebElement emailInputField;
  @FindBy(id = "input-telephone")
  private WebElement telephoneInputField;
  @FindBy(id = "input-password")
  private WebElement passwordInputField;
  @FindBy(id = "input-confirm")
  private WebElement confirmPasswordInputField;
  @FindBy(xpath = "//input[@type='checkbox']")
  private WebElement privacyPolicyCheckbox;
  @FindBy(css = "input.btn")
  private WebElement continueButton;
}
