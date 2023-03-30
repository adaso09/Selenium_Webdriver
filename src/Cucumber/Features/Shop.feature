Feature: Login at MyStore and change address

  Scenario: User can create an accounts and changes addresses
    Given I go to login shop page
    When  I login using  email "puber@prestashop.com" and password "1234567"
    And I go to my Shop addresses page
    When I enter new address  alias oa, address luty132, City ojko, postal code 33535, phone 45317
    Then I can see new shop address
    And I verify created address oa,luty132,ojko,33535,45317
    And I remove the shop address
    And I can see the address was removed at file
    And I close the shop browser

  @shop
  Scenario Outline: User can create an accounts and changes addresses

    Given I go to login shop page
    When  I login using  email "puber@prestashop.com" and password "1234567"
    And I go to my Shop addresses page
    When I enter new address  alias <alias>, address <address>, City <City>, postal code <postal code>, phone <phone>,
    Then I can see new shop address
    And I verify created address <alias>,<address>,<City>,<postal code>,<phone>
    And I remove the shop address
    And I can see the address was removed at file
    And I close the shop browser
    Examples:

      | alias  | address    | postal code | City      | phone     |
      | Panicz | Jamier 12  | 11124      | Palestyna | 11007145  |
      | Pani   | LostCityes | 12146      | Opera 13  | 99713452  |
      | Pro    | LostAngels | 14123      | Kelvin    | 107845346 |

