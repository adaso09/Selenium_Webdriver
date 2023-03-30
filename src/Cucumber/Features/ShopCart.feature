Feature: Login at MyStore and payment
  @cart
  Scenario: Logged user select product and added to cart
    Given I go to login shop
    When  I login to using  email "opera@test.com" and password "1234567"
    And I'm on shop main page
    And  I selected item "Hummingbird Printed Sweater" to cart
    And I select Size M and Quantity
    Then I add items to cart
    And I proceed to checkout to pay
    And I select Address,Shipping method and payment
    And I take ScreenShot to confirm my order
    And I check my Order history and check status of order
    And I close the shop browsers