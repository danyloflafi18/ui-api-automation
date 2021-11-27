package ui.pages;

import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.String.format;
@Getter
public class SearchResultPage extends BasePage{
  @FindBy(xpath = "//button/span[text()='Add to Cart']")
  private WebElement addToCartButton;
  @FindBy(xpath = "//div[@class='product-thumb']//h4/a")
  private List<WebElement> productNameList;

  public WebElement getProductName(final String productName) {
    return productNameList
            .stream()
            .filter(element -> element.getText().equals(productName))
            .findAny().orElseThrow(()
                    -> new NoSuchElementException(format("There is not [%s] item", productName)));
  }
}
