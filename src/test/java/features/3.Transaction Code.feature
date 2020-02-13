# new feature
# Tags: optional
@test1 @e2e
Feature: Manipulate data Transaction Code

  Scenario: Add Trans Code
    Given input data transcode
    Then data success transcode

  Scenario: Approve data
    Given approve data transcode
    Then Success approve add transcode

  Scenario: Edit data
    Given Edit data transcode
    When transaction code is from approve data
    Then Edit data is success

  Scenario: approve edit data
    Given Approve edit data
    Then Success approve edit data

  Scenario: Edit status
    Given Change status
    Then Success edit status

  Scenario: Approve edit status
    Given Approve edit status
    Then Success approve edit status

  Scenario: Delete data transcode
    Given data is exist
    When user delete data
    Then success delete data

  Scenario: Approve delete data
    Given Approve delete data with transaction id "tc1"
    Then Success approve delete transaction code