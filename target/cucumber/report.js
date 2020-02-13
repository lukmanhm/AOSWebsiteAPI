$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/1.User.feature");
formatter.feature({
  "name": "User CRUD",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@e2e"
    }
  ]
});
formatter.scenario({
  "name": "Login Scenario",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@e2e"
    },
    {
      "name": "@end2end"
    }
  ]
});
formatter.step({
  "name": "password is encrypted",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.passwordIsEncrypted()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I submit post with name and password",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.iSubmitPostWithNameAndPassword()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "response code as 200",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.responseCodeAs(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Status List",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@e2e"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "give param \"Authorization\"",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.giveParam(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Response code status as 200",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.responseCodeStatusAs(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Register User",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@e2e"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "go to url with parameter verifycode",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef1.goToUrlWithParameterVerifycode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Input \"name\", \"email\", \"username\", \"roleTitle\", \"requestedComment\"",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdef1.input(String,String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Statuscode as 200",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef1.statuscodeAs(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "rc as \"OK-000\"",
  "keyword": "And "
});
formatter.match({
  "location": "Stepdef1.rcAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "set \"approval_request_uuid\" and \"user_uuid\" to global variable",
  "keyword": "And "
});
formatter.match({
  "location": "Stepdef1.setAndToGlobalVariable(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@e2e"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "go to url approval",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef1.goToUrlApproval()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Header \"Content-Type\", \"Authorization\", and give json body \"approvalStatus\", \"approvalReason\"",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdef1.headerAndGiveJsonBody(String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "statuscode , rc is success",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef1.statuscodeRcIsSuccess()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Getting verify code",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@e2e"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "go to url with parameter verifycode",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef1.goToUrlWithParameterVerifycode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "header set \"Authorization\"",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdef1.headerSet(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "statuscode , rc, and set to global variable",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef1.statuscodeRcAndSetToGlobalVariable()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Set password",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@e2e"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "go to url with parameter verifycode and useruuid",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef1.goToUrlWithParameterVerifycodeAndUseruuid()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "header set content type",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdef1.headerSetContentType()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Password do encrypted",
  "keyword": "And "
});
formatter.match({
  "location": "Stepdef1.passwordDoEncrypted()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "status code as, rc",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef1.statusCodeAsRc()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Edit data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@e2e"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "give params auth and content type",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef1.giveParamsAuthAndContentType()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user data is edit",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdef1.userDataIsEdit()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "success edit data",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef1.successEditData()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve edit",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@e2e"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "give param header",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef1.giveParamHeader()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "approve status is ok",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdef1.approveStatusIsOk()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "edit data is approved",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef1.editDataIsApproved()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@e2e"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "go to url with parameter useruuid",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef1.goToUrlWithParameterUseruuid()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "header set \"Authorization\" and \"Content-Type\", and give body \"requestedComment\"",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdef1.headerSetAndAndGiveBody(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "sc , rc and set \"approval_request_uuid\" to global variable",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef1.scRcAndSetToGlobalVariable(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve delete user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@e2e"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "give header content type and auth",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef1.giveHeaderContentTypeAndAuth()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "approvalstatus data",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdef1.approvalstatusData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "sc is 200 and rc is ok-000",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef1.scIsAndRcIsOk(int,int)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/java/features/2.Role.feature");
formatter.feature({
  "name": "Manipulate role/level",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@test"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.scenario({
  "name": "Add data role",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "go to url",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefsRole.goToUrl()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "input json array",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefsRole.inputJsonArray()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "sc is 200 and rc is \"OK-000\"",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefsRole.scIsAndRcIs(int,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve new role",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "go to url",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefsRole.goToUrl()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "approve data",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefsRole.approveData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "success approve new role",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefsRole.successApproveNewRole()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Edit data role",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "go to url",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefsRole.goToUrl()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "edit json array",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefsRole.editJsonArray()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "success edit data role",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefsRole.successEditDataRole()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve edit role",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "go to url",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefsRole.goToUrl()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "approve data",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefsRole.approveData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "success approve new role",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefsRole.successApproveNewRole()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete role",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "go to url",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefsRole.goToUrl()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Delete role",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefsRole.deleteRole()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success delete",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefsRole.successDelete()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve Delete role",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "go to url",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefsRole.goToUrl()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "approve data",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefsRole.approveData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "success approve new role",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefsRole.successApproveNewRole()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/java/features/3.Transaction Code.feature");
formatter.feature({
  "name": "Manipulate data Transaction Code",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@test1"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.scenario({
  "name": "Add Trans Code",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test1"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "input data transcode",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Trans.inputDataTranscode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "data success transcode",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Trans.dataSuccessTranscode()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test1"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "approve data transcode",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Trans.approveDataTranscode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success approve add transcode",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Trans.successApproveAddTranscode()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Edit data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test1"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "Edit data transcode",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Trans.editDataTranscode()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "transaction code is from approve data",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs_Trans.transactionCodeIsFromApproveData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Edit data is success",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Trans.editDataIsSuccess()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "approve edit data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test1"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "Approve edit data",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Trans.approveEditData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success approve edit data",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Trans.successApproveEditData()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Edit status",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test1"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "Change status",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Trans.changeStatus()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success edit status",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Trans.successEditStatus()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve edit status",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test1"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "Approve edit status",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Trans.approveEditStatus()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success approve edit status",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Trans.successApproveEditStatus()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete data transcode",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test1"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "data is exist",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Trans.dataIsExist()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user delete data",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs_Trans.userDeleteData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "success delete data",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Trans.successDeleteData()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve delete data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test1"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "Approve delete data with transaction id \"tc1\"",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Trans.approveDeleteDataWithTransactionId(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success approve delete transaction code",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Trans.successApproveDeleteTransactionCode()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/java/features/4.Response Code - API.feature");
formatter.feature({
  "name": "Manipulate data Response Code",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@test2"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.scenario({
  "name": "Add Response Code - API",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test2"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "input data rescode-API",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.inputDataRescodeAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "data success rescode-API",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.dataSuccessRescodeAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test2"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "approve data rescode-API",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.approveDataRescodeAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success approve add rescode-API",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.successApproveAddRescodeAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Edit data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test2"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "Edit data rescode-API",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.editDataRescodeAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify rescode-API is from approve data",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.verifyRescodeAPIIsFromApproveData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "edit data rescode-API is success",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.editDataRescodeAPIIsSuccess()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "approve edit data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test2"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "Approve edit data rescode-API",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.approveEditDataRescodeAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success approve edit data rescode-API",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.successApproveEditDataRescodeAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete data rescode-API",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test2"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "data rescode-API is exist",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.dataRescodeAPIIsExist()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user delete data rescode-API",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.userDeleteDataRescodeAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "success delete data rescode-API",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.successDeleteDataRescodeAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve delete data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test2"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "Approve delete data rescode-API",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.approveDeleteDataRescodeAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success approve delete rescode-API",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_ResCode_API.successApproveDeleteRescodeAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/java/features/5.Property-API.feature");
formatter.feature({
  "name": "Manipulate data Property API",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@test3"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.scenario({
  "name": "Add Property API",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test3"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "input Property API",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Property_API.inputPropertyAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "data Property API",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Property_API.dataPropertyAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test3"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "approve data Property API",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Property_API.approveDataPropertyAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success approve add Property API",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Property_API.successApproveAddPropertyAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Edit data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test3"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "Edit data Property API",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Property_API.editDataPropertyAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify Property API is from approve data",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs_Property_API.verifyPropertyAPIIsFromApproveData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "edit data Property API is success",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Property_API.editDataPropertyAPIIsSuccess()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "approve edit data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test3"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "Approve edit data Property API",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Property_API.approveEditDataPropertyAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success approve edit data Property API",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Property_API.successApproveEditDataPropertyAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Edit status Property",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test3"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "Change status Property",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Property_API.changeStatusProperty()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success edit status Property",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Property_API.successEditStatusProperty()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve edit status",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test3"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "Approve edit status Property",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Property_API.approveEditStatusProperty()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success approve edit status Property",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Property_API.successApproveEditStatusProperty()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete data Property API",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test3"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "data Property API is exist",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Property_API.dataPropertyAPIIsExist()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user delete data Property API",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs_Property_API.userDeleteDataPropertyAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "success delete data Property API",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Property_API.successDeleteDataPropertyAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Approve delete data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test3"
    },
    {
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "name": "Approve delete data Property API",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs_Property_API.approveDeleteDataPropertyAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Success approve delete Property API",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs_Property_API.successApproveDeletePropertyAPI()"
});
formatter.result({
  "status": "passed"
});
});