package ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.When;
import ui.pages.SearchForm;
public class MainSteps extends BaseSteps {

  @Inject
  SearchForm searchForm;

  @When("at Header panel user enters {string} search criteria")
  public void enterSearchCriteria(final String searchQuery) {
    getJavaScriptProvider().scrollTop();
    searchForm.getInputField().click();
    searchForm.getInputField().sendKeys(searchQuery);
  }

  @When("at Main page user executes search by {string}")
  public void atMainPageUserExecutesSearchBy(String product) {
    enterSearchCriteria(product);
    searchForm.getSearchButton().click();
  }
}
