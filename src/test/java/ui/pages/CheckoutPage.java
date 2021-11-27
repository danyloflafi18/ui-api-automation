package ui.pages;

import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;
@Getter
public class CheckoutPage extends BasePage {
  @FindBy(id = "input-payment-country")
  private WebElement countryDropDownField;
  @FindBy(id = "input-payment-firstname")
  private WebElement firstNameInputPaymentField;
  @FindBy(id = "input-payment-lastname")
  private WebElement lastNameInputPaymentField;
  @FindBy(id = "input-payment-address-1")
  private WebElement addressInputPaymentField;
  @FindBy(id = "input-payment-city")
  private WebElement cityInputPaymentField;
  @FindBy(id = "input-payment-postcode")
  private WebElement postCodeInputPaymentField;
  @FindBy(id = "input-payment-zone")
  private WebElement regionInputPaymentField;
  @FindBy(xpath = "//a[contains(text(),'Billing Details')]")
  private WebElement billingDetailsTitle;
  @FindBy(id = "button-payment-address")
  private WebElement billingDetailsButton;
  @FindBy(xpath = "//a[contains(text(),'Delivery Details')]")
  private WebElement deliveryDetailsTitle;
  @FindBy(id = "button-shipping-address")
  private WebElement deliveryDetailsButton;
  @FindBy(xpath = "//a[contains(text(),'Delivery Method')]")
  private WebElement deliveryMethodTitle;
  @FindBy(id = "button-shipping-method")
  private WebElement deliveryMethodButton;
  @FindBy(xpath = "//a[contains(text(),'Payment Method')]")
  private WebElement paymentMethodTitle;
  @FindBy(id = "button-payment-method")
  private WebElement paymentMethodButton;
  @FindBy(xpath = "//a[contains(text(),'Confirm Order')]")
  private WebElement confirmOrderTitle;
  @FindBy(id = "button-confirm")
  private WebElement confirmOrderButton;
  @FindBy(xpath = "//input[@type='checkbox']")
  private WebElement termsConditionsCheckbox;

  public WebElement getCountry() {
    Random random = new Random();
    List<WebElement> countries = countryDropDownField
            .findElements(xpath("./option[not(@value='')]"));
    return countries.get(random.nextInt(countries.size()));
  }

  public WebElement getRegion() {
    return regionInputPaymentField
            .findElements(xpath("./option[not(@value='') and not(@value='0')]"))
            .stream()
            .findAny()
            .get();
  }
}
