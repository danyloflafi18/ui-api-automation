Feature: Open Cart

  Background:
    Given user navigates to home page

  Scenario Outline: User buys on Open Cart site some product
    When at Header Panel in "My Account" section user clicks "Register"
    And at Sign Up page user signs up
    Then at After Sign Up page user sees 'Your Account Has Been Created!' title
    When at Header Panel in "My Account" section user clicks "Logout"
    Then at After Logout page user sees 'Account Logout' title
    When at Header Panel in "My Account" section user clicks "Login"
    And at Login Page user logs in as known user
    Then at After Login page user sees 'My Account' title
    When at After Login page user click 'Your Store' title
    Then user is navigated to Main page and URL contains "/index.php?route=common/home"
    When at Main page user executes search by "<product>"
    Then at Search Results page user should see "<product>" name
    When at Search Results page on Property Card user clicks 'Add to Cart' button
    And at Property Cart page user confirms purchase
    And at Header Panel user clicks on "Shopping Cart" section
    And at Shopping Cart page user clicks on 'Checkout' button
    And at Checkout page on Billing Details section user enters data
    And at Checkout page on 'Billing Details' section user clicks 'Continue' button
    And at Checkout page on 'Delivery Details' section user clicks 'Continue' button
    And at Checkout page on 'Delivery Method' section user clicks 'Continue' button
    And at Checkout page on 'Payment Method' section user clicks on 'Terms & Conditions' checkbox
    And at Checkout page on 'Payment Method' section user clicks 'Continue' button
    And at Checkout page on 'Confirm Order' section user clicks 'Confirm Order' button
    Then at After Checkout page user sees 'Your order has been placed' title


    Examples:
      | product  |
      | HP LP3065 |

