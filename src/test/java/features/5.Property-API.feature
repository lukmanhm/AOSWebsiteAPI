# new feature
# Tags: optional
@test3 @e2e
Feature: Manipulate data Property API

  Scenario: Add Property API
    Given input Property API
    Then data Property API

  Scenario: Approve data
    Given approve data Property API
    Then Success approve add Property API

  Scenario: Edit data
    Given Edit data Property API
    When Verify Property API is from approve data
    Then edit data Property API is success

  Scenario: approve edit data
    Given Approve edit data Property API
    Then Success approve edit data Property API

  Scenario: Edit status Property
    Given Change status Property
    Then Success edit status Property

  Scenario: Approve edit status
    Given Approve edit status Property
    Then Success approve edit status Property

  Scenario: Delete data Property API
    Given data Property API is exist
    When user delete data Property API
    Then success delete data Property API

  Scenario: Approve delete data
    Given Approve delete data Property API
    Then Success approve delete Property API