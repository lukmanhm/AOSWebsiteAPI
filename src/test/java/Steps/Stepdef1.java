package Steps;

import Utils.base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ResponseBody;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Stepdef1 extends base {

    @Given("set Header {string} and {string}")
    public void setHeaderAnd(String arg0, String arg1) {

        REQ_SPEC = given().baseUri("http://10.16.1.52:8080/v1/api");
            }

    @When("Input {string}, {string}, {string}, {string}, {string}")
    public void input(String arg0, String arg1, String arg2, String arg3, String arg4) {
        Random rand = new Random(); //instance of random class
        int upperbound=1000;
        //generate random values from 0-24
        int_random = rand.nextInt(upperbound);
        System.out.println(int_random);
        username = "lukman" + int_random;
        Email = "lukman@gmail.com";
        System.out.println(username);
        JSONObject jobj = new JSONObject();
        jobj.put("name", "Lukman");
        jobj.put("email", Email);
        jobj.put("username", username);
        jobj.put("roleTitle", "Super Admin");
        jobj.put("requestedComment", "test user");

        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put("Authorization", "Bearer " + access_token);
        header1.put("Content-Type", "application/json");
        System.out.println(header1.toString());
        Res = REQ_SPEC.headers(header1).body(jobj).when().post("/user/add");
        makeSomeLog();
    }

    @Then("Statuscode as {int}")
    public void statuscodeAs(int statusCode) {
        ResponseBody test = Res.getBody();
        statusCode = Res.getStatusCode();
        Assert.assertEquals(200, statusCode);
    }


    @And("rc as {string}")
    public void rcAs(String arg0) {
        arg0 = Res.getBody().jsonPath().get("rc");
        System.out.println(arg0);
        assertEquals("OK-000", arg0);
    }

    private void assertThat(String s, String arg0) {
    }

    @And("set {string} and {string} to global variable")
    public void setAndToGlobalVariable(String arg0, String arg1) throws SQLException, ClassNotFoundException {
        approval_request_uuid = Res.getBody().jsonPath().get("user.approvalRequestUUID");
        user_uuid = Res.getBody().jsonPath().get("user.userUUID");
        System.out.println(approval_request_uuid);
        System.out.println(user_uuid);
        System.out.println("Success register");
        SetUpConnection("select * from web_users where username='"+username+"';", 14, 6, 1);
        assertEquals("Data is same with db", Data1, username);
        assertEquals("Data is same with db", Email, Data2);
    }

    @Given("go to url with parameter verifycode")
    public void goToUrlWithParameterVerifycode() {
        REQ_SPEC = given().baseUri("http://10.16.1.52:8080/v1/api");
    }

    @When("header set {string}")
    public void headerSet(String arg0) {
        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put("Authorization", "Bearer " + access_token);
        REQ_SPEC.headers(header1);
        REQ_SPEC.when();
        Res = REQ_SPEC.get("/user/"+user_uuid+"/verify-code");
        makeSomeLog();
    }

    @Then("statuscode , rc, and set to global variable")
    public void statuscodeRcAndSetToGlobalVariable() {
        ValidationAssert();
        verify_code = Res.getBody().jsonPath().get("dummy");
        System.out.println(verify_code.toString());
        System.out.println("Success verify");
    }

    @Given("go to url with parameter verifycode and useruuid")
    public void goToUrlWithParameterVerifycodeAndUseruuid() {
        REQ_SPEC = given().baseUri("http://10.16.1.52:8080/v1/api/auth/set-password/");
    }

    @When("header set content type")
    public void headerSetContentType() {
        admin_password = DigestUtils.sha256Hex("masukaja2" + "AOS_4lt0");
        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put("Content-Type", "application/json");
        JSONObject job = new JSONObject();
        job.put("newPassword", admin_password);

        Res = REQ_SPEC.headers(header1).body(job).when().post("/"+user_uuid+"/"+verify_code);
        makeSomeLog();
    }

    @And("Password do encrypted")
    public void passwordDoEncrypted() {

    }

    @Then("status code as, rc")
    public void statusCodeAsRc() {
        ValidationAssert();
        System.out.println("Success set password");
    }

    @Given("go to url with parameter useruuid")
    public void goToUrlWithParameterUseruuid() {
        REQ_SPEC = given().baseUri("http://10.16.1.52:8080/v1/api/user/");
    }

    @When("header set {string} and {string}, and give body {string}")
    public void headerSetAndAndGiveBody(String Authorization, String ct, String comment) {
        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put("Authorization", "Bearer " + access_token);
        header1.put("Content-Type", "application/json");
        JSONObject jobj = new JSONObject();
        jobj.put(comment, "test delete user");
        Res = REQ_SPEC.headers(header1).body(jobj).when().delete(user_uuid+"/delete");
    }

    @Then("sc , rc and set {string} to global variable")
    public void scRcAndSetToGlobalVariable(String arg0) {
        int sc = Res.getStatusCode();
        assertEquals(200, sc);
        String test = Res.getBody().jsonPath().get("rc");
        System.out.println(test);
        Assert.assertTrue(test.equals("OK-000"));
        approveDelete = Res.getBody().jsonPath().get("user.approvalRequestUUID");
        System.out.println(approveDelete);
        System.out.println("Success delete");
    }

    @Given("go to url approval")
    public void goToUrlApproval() {
        REQ_SPEC = given().baseUri("http://10.16.1.52:8080/v1/api/user/approval/");
    }

    @When("Header {string}, {string}, and give json body {string}, {string}")
    public void headerAndGiveJsonBody(String arg0, String arg1, String arg2, String arg3) {

        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put(arg1, "Bearer " + access_token);
        header1.put(arg0, "application/json");
        JSONObject jobj = new JSONObject();
        jobj.put(arg2, "1");
        jobj.put(arg3, "approved");
        Res = REQ_SPEC.headers(header1).body(jobj).when().put(approval_request_uuid+"/edit");
        makeSomeLog();
    }

    @Then("statuscode , rc is success")
    public void statuscodeRcIsSuccess() {
        ValidationAssert();
        approval_request_uuid = Res.getBody().jsonPath().get("user.approvalRequestUUID");
        System.out.println("Success approve");
    }

    @Given("give header content type and auth")
    public void giveHeaderContentTypeAndAuth() {
        REQ_SPEC = given().baseUri("http://10.16.1.52:8080/v1/api/user/approval/");
    }

    @When("approvalstatus data")
    public void approvalstatusData() {
        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put("Authorization", "Bearer " + access_token);
        header1.put("Content-Type", "application/json");
        JSONObject jobj = new JSONObject();
        jobj.put("approvalStatus", "1");
        jobj.put("approvalReason", "approved");
        System.out.println(approveDelete + " approve delete");
        Res = REQ_SPEC.headers(header1).body(jobj).when().put(approveDelete+"/edit");
        makeSomeLog();
    }

    @Then("sc is {int} and rc is ok{int}")
    public void scIsAndRcIsOk(int arg0, int arg1) throws SQLException, ClassNotFoundException {
        int sc = Res.getStatusCode();
        System.out.println(sc);
        assertEquals(200, sc);
        String test = Res.getBody().jsonPath().get("rc");
        System.out.println(test);
        assertEquals("OK-000", test);
        String approve = Res.getBody().jsonPath().get("user.approvalRequestUUID");

        AssertDBNull("select * from web_users where username='"+username+"';", 1);
        Assert.assertEquals(null, Data3);

        System.out.println("Success approve delete");
    }

    @Given("give params auth and content type")
    public void giveParamsAuthAndContentType() {
        REQ_SPEC = given().baseUri("http://10.16.1.52:8080/v1/api/user/");
    }


    @When("user data is edit")
    public void userDataIsEdit() {
        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put("Authorization", "Bearer " + access_token);
        header1.put("Content-Type", "application/json");
        JSONObject jobj = new JSONObject();
        Email="lukman@ggmail.com";
        jobj.put("status", 1);
        jobj.put("email", Email);
        jobj.put("roleTitle","Operator");
        Res = REQ_SPEC.headers(header1).body(jobj).when().put(user_uuid+"/edit");
        makeSomeLog();
    }

    @Then("success edit data")
    public void successEditData() throws SQLException, ClassNotFoundException {
        int sc = Res.getStatusCode();
        System.out.println(sc);
        assertEquals(200, sc);
        String test = Res.getBody().jsonPath().get("rc");
        System.out.println(test);
        assertEquals("OK-000", test);
        approval_request_uuid = Res.getBody().jsonPath().get("user.approvalRequestUUID");
        System.out.println("Success edit");

    }

    @Given("give param header")
    public void giveParamHeader() {
        REQ_SPEC = given().baseUri("http://10.16.1.52:8080/v1/api/user/approval/");
    }

    @When("approve status is ok")
    public void approveStatusIsOk() {
        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put("Authorization", "Bearer " + access_token);
        header1.put("Content-Type", "application/json");
        JSONObject jobj = new JSONObject();
        jobj.put("approvalStatus", "1");
        jobj.put("approvalReason", "approved");
        Res = REQ_SPEC.headers(header1).body(jobj).when().put(approval_request_uuid+"/edit");
        makeSomeLog();
    }

    @Then("edit data is approved")
    public void editDataIsApproved() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        approval_request_uuid = Res.getBody().jsonPath().get("user.approvalRequestUUID");
        System.out.println("Success approve");

        //compare data from edit API to DB
        SetUpConnection("select * from web_users where username='"+username+"';", 14, 6, 1);
        assertEquals("Data is same with db", Data1, username);
        assertEquals("Data is same with db", Email, Data2);
    }

}