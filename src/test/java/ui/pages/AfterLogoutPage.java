package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class AfterLogoutPage extends BasePage{
  @FindBy(xpath = "//h1[text()='Account Logout']")
  private WebElement accountLogoutText;
}
