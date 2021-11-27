package ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import ui.entity.User;
import ui.pages.AfterLoginPage;
import ui.pages.LoginPage;
import ui.pages.header.HeaderPanel;

import static org.junit.Assert.assertTrue;

public final class LoginSteps extends BaseSteps{

  @Inject
  private LoginPage loginPage;

  @And("at Login Page user logs in as known user")
  public void userLogsInAsKnownUser() {
    enterLoginCredentials(getDataHolder().getCurrentUser());
    clickLoginButton();
  }

  private void enterLoginCredentials(User user) {
    enterEmail(user.getEmail());
    enterPassword(user.getPassword());
  }

  private void enterPassword(final String password) {
    loginPage.getPasswordInputField().clear();
    loginPage.getPasswordInputField().sendKeys(password);
  }

  private void clickLoginButton() {
    loginPage.getLogInButton().click();
  }

  private void enterEmail(String email) {
    loginPage.getEmailAddressInputField().clear();
    loginPage.getEmailAddressInputField().sendKeys(email);
  }
}
