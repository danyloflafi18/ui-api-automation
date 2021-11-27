package ui.pages.header;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

import java.util.List;

import static java.lang.String.format;
public class HeaderPanel extends BasePage {

  @FindBy(css = "ul.list-inline > li")
  List<WebElement> headerPanelItems;
  @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a")
  List<WebElement> myAccountDropDownItems;

  public WebElement getHeaderPanelItem(final String headerPanelItem) {
    return headerPanelItems
            .stream()
            .filter(element -> element.getText().equals(headerPanelItem))
            .findAny().orElseThrow(()
                    -> new NoSuchElementException(format("There is not [%s] item", headerPanelItem)));
  }

  public WebElement getMyAccountDropDownItem(final String myAccountItem) {
    return myAccountDropDownItems
            .stream()
            .filter(element -> element.getText().equals(myAccountItem))
            .findAny().orElseThrow(()
                    -> new NoSuchElementException(format("There is not [%s] item", myAccountItem)));
  }
}
