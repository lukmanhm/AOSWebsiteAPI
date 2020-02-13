# new feature
# Tags: optional
@test4 @end2end
Feature: Manipulate data Response Code Web

  Scenario: Add Response Code - WEB
    Given input data rescode-WEB
    Then data success rescode-WEB

  Scenario: Approve data
    Given approve data rescode-WEB
    Then Success approve add rescode-WEB

  Scenario: Edit data
    Given Edit data rescode-WEB
    When Verify rescode-WEB is from approve data
    Then edit data rescode-WEB is success

  Scenario: approve edit data
    Given Approve edit data rescode-WEB
    Then Success approve edit data rescode-WEB

  Scenario: Delete data rescode-WEB
    Given data rescode-WEB is exist
    When user delete data rescode-WEB
    Then success delete data rescode-WEB

  Scenario: Approve delete data
    Given Approve delete data rescode-WEB
    Then Success approve delete rescode-WEB