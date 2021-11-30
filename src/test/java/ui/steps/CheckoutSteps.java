package ui.steps;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import ui.entity.User;
import ui.pages.CheckoutPage;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;
import static ui.utils.ElementUtils.click;
import static ui.utils.UserWaitsForResult.timeout;
public class CheckoutSteps extends BaseSteps {
  @Inject
  private CheckoutPage checkoutPage;

  @And("at Checkout page on Billing Details section user enters data")
  public void atCheckoutPageOnBillingDetailsSectionUserEntersData() {
    timeout(1000);
    userEntersFirstName();
    userEntersLastName();
    userEntersAddress();
    userEntersCity();
    userEntersPostCode();
    userChoosesCountry();
    userChoosesRegion();
  }

  @And("at Checkout page on 'Billing Details' section user clicks 'Continue' button")
  public void atCheckoutPageOnBillingDetailsSectionUserClicksContinueButton() {
    assertTrue(checkoutPage.getBillingDetailsTitle().isDisplayed());
    WebElement billingDetailsButton = checkoutPage.getBillingDetailsButton();
    click(billingDetailsButton);
  }

  @And("at Checkout page on 'Delivery Details' section user clicks 'Continue' button")
  public void atCheckoutPageDeliveryDetailsOnSectionUserClicksContinueButton() {
    assertTrue(checkoutPage.getDeliveryDetailsTitle().isDisplayed());
    WebElement deliveryDetailsButton = checkoutPage.getDeliveryDetailsButton();
    click(deliveryDetailsButton);
  }

  @And("at Checkout page on 'Delivery Method' section user clicks 'Continue' button")
  public void atCheckoutPageOnDeliveryMethodSectionUserClicksContinueButton() {
    assertTrue(checkoutPage.getDeliveryMethodTitle().isDisplayed());
    WebElement deliveryMethodButton = checkoutPage.getDeliveryMethodButton();
    click(deliveryMethodButton);
  }

  @And("at Checkout page on 'Payment Method' section user clicks on 'Terms & Conditions' checkbox")
  public void atCheckoutPageOnPaymentMethodSectionUserClicksOnTermsConditionsCheckbox() {
    checkoutPage.getTermsConditionsCheckbox().click();
  }

  @And("at Checkout page on 'Payment Method' section user clicks 'Continue' button")
  public void atCheckoutPageOnPaymentMethodSectionUserClicksContinueButton() {
    assertTrue(checkoutPage.getPaymentMethodTitle().isDisplayed());
    WebElement paymentMethodButton = checkoutPage.getPaymentMethodButton();
    click(paymentMethodButton);
  }

  @And("at Checkout page on 'Confirm Order' section user clicks 'Confirm Order' button")
  public void atCheckoutPageOnConfirmOrderSectionUserClicksConfirmOrderButton() {
    assertTrue(checkoutPage.getConfirmOrderTitle().isDisplayed());
    WebElement confirmOrderButton = checkoutPage.getConfirmOrderButton();
    click(confirmOrderButton);
  }

  private void userEntersFirstName() {
    enterFirstName(currentUser);
  }

  private void userEntersLastName() {
    enterLastName(currentUser);
  }

  private void userEntersAddress() {
    enterAddress(currentUser);
  }

  private void userEntersCity() {
    enterCity(currentUser);
  }

  private void userEntersPostCode() {
    enterPostCode(currentUser);
  }

  private void enterFirstName(User user) {
    fillInFirstName(user.getFirstName());
  }

  private void enterLastName(User user) {
    fillInLastName(user.getLastName());
  }

  private void enterAddress(User user) {
    fillInAddress(user.getAddress());
  }

  private void enterCity(User user) {
    fillInCity(user.getCity());
  }

  private void enterPostCode(User user) {
    fillInPostCode(user.getPostCode());
  }

  private void userChoosesCountry() {
    click(checkoutPage.getCountryDropDownField());
    click(checkoutPage.getCountry());
  }

  private void userChoosesRegion() {
    checkoutPage.getRegionInputPaymentField().click();
    try {
      checkoutPage.getRegion().click();
    } catch (NoSuchElementException e) {
      userChoosesCountry();
      checkoutPage.getRegionInputPaymentField().click();
      checkoutPage.getRegion().click();
    }
  }

  private void fillInFirstName(final String firstName) {
    click(checkoutPage.getFirstNameInputPaymentField());
    checkoutPage.getFirstNameInputPaymentField().clear();
    checkoutPage.getFirstNameInputPaymentField().sendKeys(firstName);
  }

  private void fillInLastName(final String lastName) {
    click(checkoutPage.getLastNameInputPaymentField());
    checkoutPage.getLastNameInputPaymentField().clear();
    checkoutPage.getLastNameInputPaymentField().sendKeys(lastName);
  }

  private void fillInAddress(final String address) {
    click(checkoutPage.getAddressInputPaymentField());
    checkoutPage.getAddressInputPaymentField().clear();
    checkoutPage.getAddressInputPaymentField().sendKeys(address);
  }

  private void fillInCity(String city) {
    click(checkoutPage.getCityInputPaymentField());
    checkoutPage.getCityInputPaymentField().clear();
    checkoutPage.getCityInputPaymentField().sendKeys(city);
  }

  private void fillInPostCode(String postCode) {
    click(checkoutPage.getPostCodeInputPaymentField());
    checkoutPage.getPostCodeInputPaymentField().clear();
    checkoutPage.getPostCodeInputPaymentField().sendKeys(postCode);
  }
}
