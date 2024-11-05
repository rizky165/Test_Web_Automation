Feature: Test API Automation on gorest

  @api
  Scenario: Test Get list user
    Given Url valid for "GET_LIST_USER"
    And Hit api get list user
    Then Status code should be 200
    Then Validation response body get list data
    Then Validation response json with JSONSchema "get_list_user_data.json"

  @api
  Scenario: Test Post Create new user
    Given Url valid for "CREATE_NEW_USER"
    Then Hit api post create user
    Then Status code should be 201
    Then Validation response body create new user
    Then Validation response json with JSONSchema "post_read_create_new_user.json"

  @api
  Scenario: Test Delete user normal
    Given Url valid for "CREATE_NEW_USER"
    Then Hit api post create user
    Then Status code should be 201
    Then Validation response body create new user
    And Hit api delete new
    Then Status code should be 204

  @api
  Scenario: Test get list user with invalid endpoint (negative)
    Given Url invalid for "INVALID_ENDPOINT"
    Then Hit api get list user with invalid endpoint
    Then Status code should be 404
    And Response body containt "no message"

  @api
  Scenario: Test post create user with invalid email (positive)
    Given Url valid for "CREATE_NEW_USER"
    Then Hit api post create invalid user
    Then Status code should be 422
    And Response body containt "no message"

  @api
  Scenario: Test update user normal
    Given Url valid for "CREATE_NEW_USER"
    Then Hit api post create user
    Then Status code should be 201
    Then Validation response body create new user
    And  Hit api update data
    Then Status code should be 200
    Then Validation response body update user