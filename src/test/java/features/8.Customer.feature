# new feature
# Tags: optional
@test6 @end2end
Feature: Manipulated Data Customer

  Scenario: Add Customer
    Given input data Customer
    Then data Customer is success added

  Scenario: Approve data
    Given approve data Customer
    Then Success approve add Customer

  Scenario: Edit data
    Given Edit data Customer
    When Verify Customer is from approve data
    Then edit Customer WEB is success

  Scenario: approve edit data
    Given Approve edit data Customer
    Then Success approve edit data Customer

  Scenario: Edit status Customer
    Given Change status Customer
    Then Success edit status Customer

  Scenario: Approve edit status
    Given Approve edit status Customer
    Then Success approve edit status Customer

  Scenario: Delete data Customer
    Given data Customer is exist
    When user delete data Customer
    Then success delete data Customer

  Scenario: Approve delete data
    Given Approve delete data Customer
    Then Success approve delete Customer