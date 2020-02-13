# new feature
# Tags: optional
@test2 @e2e
Feature: Manipulate data Response Code

  Scenario: Add Response Code - API
    Given input data rescode-API
    Then data success rescode-API

  Scenario: Approve data
    Given approve data rescode-API
    Then Success approve add rescode-API

  Scenario: Edit data
    Given Edit data rescode-API
    When Verify rescode-API is from approve data
    Then edit data rescode-API is success

  Scenario: approve edit data
    Given Approve edit data rescode-API
    Then Success approve edit data rescode-API

  Scenario: Delete data rescode-API
    Given data rescode-API is exist
    When user delete data rescode-API
    Then success delete data rescode-API

  Scenario: Approve delete data
    Given Approve delete data rescode-API
    Then Success approve delete rescode-API