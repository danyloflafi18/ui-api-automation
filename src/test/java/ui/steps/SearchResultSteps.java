package ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.pages.SearchResultPage;

import static org.junit.Assert.assertTrue;
public class SearchResultSteps {
  @Inject
  SearchResultPage searchResultPage;
  @Then("at Search Results page user should see {string} name")
  public void atSearchResultsPageUserShouldSeePropertyCard(String productName) {
    assertTrue(searchResultPage.getProductName(productName).isDisplayed());
  }

  @When("at Search Results page on Property Card user clicks 'Add to Cart' button")
  public void atSearchResultsPageOnPropertyCardUserClicksAddToCartButton() {
    searchResultPage.getAddToCartButton().click();
  }
}
