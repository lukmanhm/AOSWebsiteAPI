# new feature
# Tags: optional
@e2e
Feature: User CRUD
  @end2end @test8
  Scenario: Login Scenario
    Given password is encrypted
    When I submit post with name and password
    Then response code as 200

  @smoke
   Scenario: Status List
     Given give param "Authorization"
     Then Response code status as 200

  @smoke
   Scenario: Register User
    Given go to url with parameter verifycode
    # Given set Header "Content-Type" and "Authorization"
     When Input "name", "email", "username", "roleTitle", "requestedComment"
     Then Statuscode as 200
     And rc as "OK-000"
     And set "approval_request_uuid" and "user_uuid" to global variable

  @smoke
  Scenario:  Approve user
    Given go to url approval
    When Header "Content-Type", "Authorization", and give json body "approvalStatus", "approvalReason"
    Then statuscode , rc is success

  @smoke
  Scenario: Getting verify code
    Given go to url with parameter verifycode
    When header set "Authorization"
    Then statuscode , rc, and set to global variable

  @smoke
  Scenario: Set password
    Given go to url with parameter verifycode and useruuid
    When header set content type
    And Password do encrypted
    Then status code as, rc

  @smoke
  Scenario: Edit data
    Given give params auth and content type
    When user data is edit
    Then success edit data

  @smoke
  Scenario: Approve edit
    Given give param header
    When approve status is ok
    Then edit data is approved

  @smoke
  Scenario: Delete user
    Given go to url with parameter useruuid
    When header set "Authorization" and "Content-Type", and give body "requestedComment"
    Then sc , rc and set "approval_request_uuid" to global variable

  @smoke
  Scenario: Approve delete user
    Given give header content type and auth
    When approvalstatus data
    Then sc is 200 and rc is ok-000
