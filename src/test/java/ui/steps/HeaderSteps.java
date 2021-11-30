package ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import ui.pages.header.HeaderPanel;

import static ui.utils.ElementUtils.click;

public class HeaderSteps extends BaseSteps {
  @Inject
  HeaderPanel headerPanel;

  @When("at Header Panel in {string} section user clicks {string}")
  public void atHeaderPanelInSectionUserClick(String section, String operation) {
    clickOnItemFromHeaderPanelSection(section);
    clickOnItemFromMyAccountDropDown(operation);
  }

  private void clickOnItemFromMyAccountDropDown(String item) {
    headerPanel.getMyAccountDropDownItem(item).click();
  }

  private void clickOnItemFromHeaderPanelSection(String itemFromHeaderPanel) {
    click(headerPanel.getHeaderPanelItem(itemFromHeaderPanel));
  }

  @And("at Header Panel user clicks on {string} section")
  public void atHeaderPanelUserClicksOnSection(String section) {
    clickOnItemFromHeaderPanelSection(section);
  }
}
