@Shop
Feature: Login at Mystore and change address


  Scenario : User can create an account
    Given I'm on shop main page
    When I go to login page
    And  I login using  email "email" and password "password"
    And I go to my addresses page
    When I enter new address  alias "pro", address "Lipowa2", postal code "43-546", City "Unites Xen", phone "453134123", country
    Then I can see new address
    And I remove the address
    And I can see the address was removed
    And I close the browser


  Scenario Outline : User can create an account
    Given I'm on shop main page
    When I go to login page
    And  I login using  email "email" and password "password"
    And I go to my addresses page
    When I enter new address  alias <alias>, address <address>, postal code <postal code>, City <City>, phone <phone>, country
    Then  Then the first one should contain <alias>,<address>,<postal code> ,<City>,<phone>
    Then I can see new address
    And I remove the address
    And I can see the address was removed
    And I close the browser
    Examples:
      | alias | address   | postal code | City     | phone     |
      | xd    | Lipowa 12 | 56-432      | Sopel    | 768095875 |
      | Pan   | main 02   | 36-732      | Man City | 999000945 |

