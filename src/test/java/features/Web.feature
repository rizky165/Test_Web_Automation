Feature: Test Automation Web

  @Web
  Scenario: Test login web normal
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see icon cart

  Scenario: Test login web wrong password
    Given open web login page
    And user input username "standard_user"
    And user input password "secret"
    And user click button login
    And user will see error message "Username and password do not match any user in this service"

  @Web
  Scenario: Test login web with locked user
    Given open web login page
    And user input username "locked_out_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see error message "Sorry, this user has been locked out."

  @Web
  Scenario: Test login web add item
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see icon cart
    And user add item to cart
    And user add item to cart
    And user add item to cart
    Then verify cart item is match "3"
    And user remove item
    And user remove item
    Then verify cart item is match "1"

  @Web
  Scenario: Test web checkout item
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see icon cart
    And user add item to cart
    Then user click icon cart
    And user click checkout
    And user input FirstName "Rizky"
    And user input LastName "Yalvinsya"
    And user input Zip atau PostalCode 17932
    And user click continue button
    Then verify cart item will shown
    And user click finish button
    Then user will see message "Thank you for your order!"

  Scenario: Test web checkout without an item
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see icon cart
    Then user click icon cart
    And user click checkout
    And user input FirstName "Rizky"
    And user input LastName "Yalvinsya"
    And user input Zip atau PostalCode 17932
    And user click continue button
    Then verify cart item will shown
    And user click finish button
    Then user will see message "Thank you for your order!"

  @Web
  Scenario: Test web checkout item without input information
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see icon cart
    And user add item to cart
    Then user click icon cart
    And user click checkout
    And user click continue button
    Then user will see error message "First Name is required"

  @Web
  Scenario: Test web checkout item only input firstname
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see icon cart
    And user add item to cart
    Then user click icon cart
    And user click checkout
    And user input FirstName "Rizky"
    And user click continue button
    Then user will see error message "Last Name is required"

  Scenario: Test web checkout item only input firstname and last name
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see icon cart
    And user add item to cart
    Then user click icon cart
    And user click checkout
    And user input FirstName "Rizky"
    And user input LastName "Yalvinsya"
    And user click continue button
    Then user will see error message "Postal Code is required"

  Scenario: Test web logout after login
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click button login
    And user will see icon cart
    And user click menu icon on the left
    Then verify the sidebar will shown
    And user click logout menu