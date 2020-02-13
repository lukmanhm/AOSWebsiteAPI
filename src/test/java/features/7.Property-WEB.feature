# new feature
# Tags: optional
@test5 @end2end
Feature: Manipulate Data Property WEB

  Scenario: Add Property WEB
    Given input Property WEB
    Then data Property WEB

  Scenario: Approve data
    Given approve data Property WEB
    Then Success approve add Property WEB

  Scenario: Edit data
    Given Edit data Property WEB
    When Verify Property WEB is from approve data
    Then edit data Property WEB is success

  Scenario: approve edit data
    Given Approve edit data Property WEB
    Then Success approve edit data Property WEB

  Scenario: Edit status Property
    Given Change status Property WEB
    Then Success edit status Property WEB

  Scenario: Approve edit status
    Given Approve edit status Property WEB
    Then Success approve edit status Property WEB

  Scenario: Delete data Property WEB
    Given data Property WEB is exist
    When user delete data Property WEB
    Then success delete data Property WEB

  Scenario: Approve delete data
    Given Approve delete data Property WEB
    Then Success approve delete Property WEB