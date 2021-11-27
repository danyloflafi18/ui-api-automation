package ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import ui.pages.AfterSignUpPage;

import static org.junit.Assert.assertTrue;
public class AfterSignUpSteps extends BaseSteps {
  @Inject
  private AfterSignUpPage afterSignUpPage;

  @Then("at After Sign Up page user sees 'Your Account Has Been Created!' title")
  public void atAfterSignUpPageUserSeesYourAccountHasBeenCreatedTitle() {
    assertTrue(afterSignUpPage.getYourAccountHasBeenCreatedText().isDisplayed());
  }
}
