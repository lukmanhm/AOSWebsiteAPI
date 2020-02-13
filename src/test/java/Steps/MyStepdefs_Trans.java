package Steps;

import Utils.base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MyStepdefs_Trans extends base {

    JSONObject jobj = new JSONObject();

    @Before
    public void setup (){
        //Test Setup
        REQ_SPEC.given().baseUri("http://10.16.1.52:8080/v1/api"); //Setup Base URI
        header.put("Content-Type", "application/json");
    }

    @Given("input data transcode")
    public void inputDataTranscode() {
        transactionCode = "tc1";
        jobj.put("transactionCode", transactionCode);
        jobj.put("transactionName", "test lukman");
        jobj.put("status", "1");
        jobj.put("limitMinTrxAmount", 0.0);
        jobj.put("limitMaxTrxAmount", 500000.0);
        jobj.put("limitMaxAmountTrxPerDay", 2000000.0);
        jobj.put("requestedComment", "test buat transcode baru");
        header.put("Authorization", "Bearer " + access_token);
        System.out.println(header);
        Res = REQ_SPEC.headers(header).body(jobj).when().post("/transcode/add");
        makeSomeLog();
    }

    @Then("data success transcode")
    public void dataSuccessTranscode() {
        int arg0 = Res.getStatusCode();
        System.out.println(arg0);
        assertEquals("value is 200", 200, arg0);
        String arg1 = Res.getBody().jsonPath().get("rc");
        System.out.println(arg1);
        Assert.assertEquals("OK-000", arg1);
        approval_request_uuid = Res.getBody().jsonPath().get("transCode.approvalRequestUUID");
        trx_code = Res.getBody().jsonPath().get("transCode.transactionCode");

    }

    private void assertEquals(String arg0, int i, int correct) {
    }



    @Given("approve data transcode")
    public void approveDataTranscode() {
        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put("Authorization", "Bearer " + access_token);
        jobj.put("approvalStatus", 1);
        Res = REQ_SPEC.headers(header1).body(jobj).when().put("/transcode/approval/"+approval_request_uuid+"/edit");
        makeSomeLog();
    }

    @Then("Success approve add transcode")
    public void successApproveAddTranscode() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        SetUpConnection("select * from transaction_type where transaction_code = '"+transactionCode+"';", 1, 2, 0);
        Assert.assertEquals(transactionCode, Data1);
        Assert.assertEquals("test lukman", Data2);
    }

    @Given("Edit data transcode")
    public void editDataTranscode() {
        limitMaxTrxAmount = 1900000;
        jobj.put("transactionName", "test lukman edit");
        jobj.put("status", "1");
        jobj.put("limitMinTrxAmount", 0.0);
        jobj.put("limitMaxTrxAmount", limitMaxTrxAmount);
        jobj.put("limitMaxAmountTrxPerDay", 2000000);
        jobj.put("requestedComment", "test edit transcode baru");
    }

    @When("transaction code is from approve data")
    public void transactionCodeIsFromApproveData() {
        Res = REQ_SPEC.headers(header).body(jobj).when().put("/transcode/"+trx_code+"/edit");
        makeSomeLog();
    }

    @Then("Edit data is success")
    public void editDataIsSuccess() {
        ValidationAssert();
        approval_request_uuid = Res.getBody().jsonPath().get("transCode.approvalRequestUUID");
    }

    @Given("Change status")
    public void changeStatus() {
        jobj.put("status", 0);
        jobj.put("requestedComment", "test edit status transcode");

        Res = REQ_SPEC.headers(header).body(jobj).when().put("/transcode/"+trx_code+"/change-status");
        makeSomeLog();
    }

    @Then("Success edit status")
    public void successEditStatus() {
        ValidationAssert();
        approval_request_uuid_status = Res.getBody().jsonPath().get("transCode.approvalRequestUUID");
    }

    @Given("Approve edit data")
    public void approveEditData() {
        jobj.put("approvalStatus", 1);
        Res = REQ_SPEC.headers(header).body(jobj).when().put("/transcode/approval/"+approval_request_uuid+"/edit");
    }

    @Then("Success approve edit data")
    public void successApproveEditData() throws SQLException, ClassNotFoundException {
        //assertion
        ValidationAssert();
        SetUpConnection("select * from transaction_type where transaction_code = '"+transactionCode+"';", 2, 5, 0);
        Assert.assertEquals("test lukman edit", Data1);
    }

    @Given("Approve edit status")
    public void approveEditStatus() {
        jobj.put("approvalStatus", 1);
        Res = REQ_SPEC.headers(header).body(jobj).when().put("/transcode/approval/"+approval_request_uuid_status+"/edit");
        makeSomeLog();
    }

    @Then("Success approve edit status")
    public void successApproveEditStatus() {
        //assertion
        String arg1 = Res.getBody().jsonPath().get("rc");
        System.out.println(arg1);
        Assert.assertEquals("OK-000", arg1);
        Assert.assertEquals("value is 200", 200, Res.getStatusCode());
    }

    @Given("data is exist")
    public void dataIsExist() {
        Res = REQ_SPEC.headers(header).when().get("/transcode/"+trx_code+"/detail");

        //checking exist
        String arg1 = Res.getBody().jsonPath().get("rc");
        System.out.println(arg1);
        Assert.assertEquals("OK-000", arg1);
    }

    @When("user delete data")
    public void userDeleteData() {
        Res = REQ_SPEC.headers(header).when().delete("/transcode/"+trx_code+"/delete");
        makeSomeLog();
    }

    @Then("success delete data")
    public void successDeleteData() {
        int arg0 = Res.getStatusCode();
        System.out.println(arg0);
        assertEquals("value is 200", arg0, 200);
        String arg1 = Res.getBody().jsonPath().get("rc");
        System.out.println(arg1);
        Assert.assertEquals("OK-000", arg1);
        approval_request_uuid = Res.getBody().jsonPath().get("transCode.approvalRequestUUID");
    }

    @Given("Approve delete data with transaction id {string}")
    public void approveDeleteDataWithTransactionId(String arg0) {
        jobj.put("approvalStatus", 1);
        Res = REQ_SPEC.headers(header).body(jobj).when().put("/transcode/approval/"+approval_request_uuid+"/edit");
        makeSomeLog();
    }

    @Then("Success approve delete transaction code")
    public void successApproveDeleteTransactionCode() throws SQLException, ClassNotFoundException {
        //assertion
        ValidationAssert();
        AssertDBNull("Select * from transaction_type where transaction_code = '"+transactionCode+"';", 0);
        Assert.assertEquals(null, Data3);
    }
}
