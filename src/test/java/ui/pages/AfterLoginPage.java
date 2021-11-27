package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AfterLoginPage extends BasePage {
  @FindBy(xpath = "//h2[text()='My Account']")
  private WebElement myAccountTitle;
  @FindBy(xpath = "//a[text()='Your Store']")
  private WebElement yourStoreLogo;
}
