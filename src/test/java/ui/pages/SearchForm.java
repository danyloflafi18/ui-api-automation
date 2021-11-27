package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class SearchForm extends BasePage {
  @FindBy(css = "input.form-control")
  private WebElement inputField;
  @FindBy(xpath = "//div[@id='search']//button")
  private WebElement searchButton;
}
