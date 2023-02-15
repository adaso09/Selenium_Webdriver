Feature: Login at MyStore and change address

  @shop
  Scenario : User can create an accounts and changes addresses

    Given I'm on shop main page
    When I go to login shop page
    And  I login using  email "liqyvtakwrueowhjhd@bbitj.com" and password "qwerty123@"
    And I go to my Shop addresses page
    When I enter new address  alias "pro", address "Lipowa2", postal code "43-546", City "Unites Xen", phone "453134123"
    Then I can see new shop address
    And I remove the shop address
    And I can see the address was removed at file
    And I close the shop browser


  Scenario Outline : User can create an accounts and changes addresses
    Given I'm on shop main page
    When I go to login shop page
    And  I login using  email "liqyvtakwrueowhjhd@bbitj.com" and password "qwerty123@"
    And I go to my Shop addresses page
    When I enter new address  alias <alias>, address <address>, postal code <postal code>, City <City>, phone <phone>
    Then the first one should contain <alias><address><postal code><City><phone>
    Then I can see new shop address
    And I remove the shop address
    And I can see the address was removed at file
    And I close the shop browser
    Examples:

      | alias | address   | postal code | City     | phone     |
      | xd    | Lipowa 12 | 56-432      | Sopel    | 768095875 |
      | Pan   | main 02   | 36-732      | Man City | 999000945 |

