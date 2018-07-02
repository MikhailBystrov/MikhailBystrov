Feature: 'Home' page and 'Different elements' page

  Scenario: Check interface and content of 'Home' and 'Different elements' pages.
    Given I am on the Home Page
    Then Home Page is the browser title
    When I login as user PITER_CHAILOVSKII
    Then PITER_CHAILOVSKII name is displayed on the header
    And Home Page contains 4 pictures
    And Home Page contains 4 texts under them
    And Home Page contains 2 texts above
    When I open Different Elements page through the header menu
    Then Different Elements page contains 4 checkboxes
    And Different Elements page contains 4 radios
    And Different Elements page contains 1 dropdown
    And Different Elements page contains 2 buttons
    Then I can see right section
    And I can see left section
    When I select checkbox: Water
    And I select checkbox: Wind
    Then There is a log row number 1 for checkbox Wind. State true
    And There is a log row number 2 for checkbox Water. State true
    When I select radio: Selen
    Then There is a log row number 1 for radio Selen
    When I select in dropdown: Yellow
    Then There is a log row number 1 for color Yellow
    When I select checkbox: Water
    And I select checkbox: Wind
    Then There is a log row number 1 for checkbox Wind. State false
    And There is a log row number 2 for checkbox Water. State false
