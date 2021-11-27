package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class AfterSignUpPage extends BasePage{
  @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
  private WebElement yourAccountHasBeenCreatedText;
}
