package ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import ui.entity.User;
import ui.pages.SignUpPage;

public class SignUpSteps extends BaseSteps {
  @Inject
  private SignUpPage signUpPage;

  private void atSignUpPageUserEntersFirstName() {
    enterFirstName(getDataHolder().getCurrentUser());
  }

  private void atSignUpPageUserEntersLastName() {
    enterLastName(getDataHolder().getCurrentUser());
  }

  private void atSignUpPageUserEntersEmail() {
    enterEmail(getDataHolder().getCurrentUser());
  }

  private void atSignUpPageUserEntersTelephone() {
    enterTelephone(getDataHolder().getCurrentUser());
  }

  private void atSignUpPageUserEntersPassword() {
    enterPassword(getDataHolder().getCurrentUser());
  }

  private void atSignUpPageUserConfirmsPassword() {
    confirmPassword(getDataHolder().getCurrentUser());
  }

  private void atSignUpPageUserClicksOnPrivacyPolicyCheckbox() {
    signUpPage.getPrivacyPolicyCheckbox().click();
  }

  private void clickSignUpBtn() {
    signUpPage.getContinueButton().click();
  }

  private void enterFirstName(User user) {
    fillInFirstName(user.getFirstName());
  }

  private void enterLastName(User user) {
    fillInLastName(user.getLastName());
  }

  private void enterEmail(User user) {
    fillInEmail(user.getEmail());
  }

  private void enterTelephone(User user) {
    fillInTelephone(user.getPhoneNumber());
  }

  private void enterPassword(User user) {
    fillInPassword(user.getPassword());
  }

  private void confirmPassword(User user) {
    fillInConfirmPassword(user.getPassword());
  }

  private void fillInFirstName(final String firstName) {
    signUpPage.getFirstNameInputField().clear();
    signUpPage.getFirstNameInputField().sendKeys(firstName);
  }

  private void fillInLastName(final String lastName) {
    signUpPage.getLastNameInputField().clear();
    signUpPage.getLastNameInputField().sendKeys(lastName);
  }

  private void fillInEmail(final String email) {
    signUpPage.getEmailInputField().clear();
    signUpPage.getEmailInputField().sendKeys(email);
  }

  private void fillInTelephone(String telephone) {
    signUpPage.getTelephoneInputField().clear();
    signUpPage.getTelephoneInputField().sendKeys(telephone);
  }

  private void fillInPassword(final String password) {
    signUpPage.getPasswordInputField().clear();
    signUpPage.getPasswordInputField().sendKeys(password);
  }

  private void fillInConfirmPassword(final String password) {
    signUpPage.getConfirmPasswordInputField().clear();
    signUpPage.getConfirmPasswordInputField().sendKeys(password);
  }

  @And("at Sign Up page user signs up")
  public void atSignUpPageUserSignsUp() {
    atSignUpPageUserEntersFirstName();
    atSignUpPageUserEntersLastName();
    atSignUpPageUserEntersEmail();
    atSignUpPageUserEntersTelephone();
    atSignUpPageUserEntersPassword();
    atSignUpPageUserConfirmsPassword();
    atSignUpPageUserClicksOnPrivacyPolicyCheckbox();
    clickSignUpBtn();
  }
}
