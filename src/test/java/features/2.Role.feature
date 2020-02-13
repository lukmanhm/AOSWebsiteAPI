# new feature
# Tags: optional
@test @e2e
Feature: Manipulate role/level

  Scenario: Add data role
    Given go to url
    When input json array
    Then sc is 200 and rc is "OK-000"

  Scenario: Approve new role
    Given  go to url
    When approve data
    Then success approve new role

  Scenario: Edit data role
    Given go to url
    When edit json array
    Then success edit data role

  Scenario: Approve edit role
    Given  go to url
    When approve data
    Then success approve new role

  Scenario: Delete role
    Given go to url
    When Delete role
    Then Success delete

  Scenario: Approve Delete role
    Given  go to url
    When approve data
    Then success approve new role