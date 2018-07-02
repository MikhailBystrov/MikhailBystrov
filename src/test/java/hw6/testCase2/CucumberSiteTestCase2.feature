Feature: 'Home' page and 'User table' page

  Scenario: Check interface and content of 'Home' and 'User table' pages.
    Given I am on the Home Page
    When I login as user PITER_CHAILOVSKII
    And I open User table page through the header menu
    Then I am on Users Table Page
    And User Table Page's interface contains correct elements

    When I check Number and User columns of Users table
    Then User table contain correct values for numbers and users
      | Number  | User              |
      | 1       | Roman             |
      | 2       | Sergey Ivan        |
      | 3       | Vladzimir         |
      | 4       | Helen Bennett      |
      | 5       | Yoshi Tannamuri   |
      | 6       | Giovanni Rovelli  |

    When I check Description column of Users table
    Then All cells of 'Description' column contains text
      | Number | Description                  |
      | 1      | Lorem ipsum                  |
      | 2      | Lorem ipsum                  |
      | 3      | Lorem ipsum                  |
      | 4      | Lorem ipsum\nsome description |
      | 5      | Lorem ipsum\nsome description |
      | 6      | Lorem ipsum\nsome description |

    When I set 'vip' status to Sergey Ivan
    Then 'Log' section shows a log row in format: FIELDNAME: condition changed to true


    When I click on dropdown in column Type for user Roman
    Then droplist contains values
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |
