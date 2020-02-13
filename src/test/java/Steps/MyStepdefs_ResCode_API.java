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

import static org.junit.Assert.assertEquals;

public class MyStepdefs_ResCode_API extends base {

    JSONObject jobj = new JSONObject();
    private static String dd;
    @Before
    public void setup () {
        //Test Setup
        REQ_SPEC.given().baseUri("http://10.16.1.52:8080/v1/api"); //Setup Base URI
        header.put("Content-Type", "application/json");
    }
    @Given("input data rescode-API")
    public void inputDataRescodeAPI() {
        resultmap = 999;
        jobj.put("resultCode", resultmap);
        jobj.put("description", "test lukman result code");
        jobj.put("requestedComment", "test buat result code baru");
        header.put("Authorization", "Bearer " + access_token);
        System.out.println(access_token);
        Res = REQ_SPEC.headers(header).body(jobj).when().post("/responsecode-api/add");
        makeSomeLog();
    }

    @Then("data success rescode-API")
    public void dataSuccessRescodeAPI() {
        ValidationAssert();
        approval_request_uuid = Res.getBody().jsonPath().get("responseCode.approvalRequestUUID");
        Result_code = Res.getBody().jsonPath().get("responseCode.resultCode");
    }

    @Given("approve data rescode-API")
    public void approveDataRescodeAPI() {
        jobj.put("approvalStatus", 1);
        Res = REQ_SPEC.headers(header).body(jobj).when().put("/responsecode-api/approval/"+approval_request_uuid+"/edit");
        makeSomeLog();
    }

    @Then("Success approve add rescode-API")
    public void successApproveAddRescodeAPI() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        SetUpConnection("Select * from result_map where result_code ='"+resultmap+"';", 1, 2, 0);
        int rm = Integer.parseInt(Data1);
        Assert.assertEquals(resultmap, rm);
        Assert.assertEquals("test lukman result code", Data2);
    }

    String desc = "test edit lukman result code";

    @Given("Edit data rescode-API")
    public void editDataRescodeAPI() {
        jobj.put("resultCode", "999");
        jobj.put("description", "test edit lukman result code");
        jobj.put("requestedComment", "test buat result code baru");
    }

    @When("Verify rescode-API is from approve data")
    public void verifyRescodeAPIIsFromApproveData() {
        Res = REQ_SPEC.headers(header).body(jobj).when().put("/responsecode-api/"+Result_code+"/edit");
        makeSomeLog();
    }

    @Then("edit data rescode-API is success")
    public void editDataRescodeAPIIsSuccess() {
        int arg0 = Res.getStatusCode();
        System.out.println(arg0);
        assertEquals("value is 200", arg0, 200);
        String arg1 = Res.getBody().jsonPath().get("rc");
        System.out.println(arg1);
        Assert.assertEquals("OK-000", arg1);
        dd = Res.getBody().jsonPath().get("responseCode.description");
        approval_request_uuid = Res.getBody().jsonPath().get("responseCode.approvalRequestUUID");
    }

    @Given("Approve edit data rescode-API")
    public void approveEditDataRescodeAPI() {
        String Path="/responsecode-api/approval/"+approval_request_uuid+"/edit";
        Approvedata(Path);
         }

    @Then("Success approve edit data rescode-API")
    public void successApproveEditDataRescodeAPI() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        SetUpConnection("Select * from result_map where result_code ='"+resultmap+"';", 1, 2, 0);
        int rm = Integer.parseInt(Data1);
        Assert.assertEquals(resultmap, rm);
        Assert.assertEquals("test edit lukman result code", Data2);
    }


    @Given("data rescode-API is exist")
    public void dataRescodeAPIIsExist() {
        Res = REQ_SPEC.headers(header).when().get("/responsecode-api/"+Result_code+"/detail");
        makeSomeLog();
        //checking exist
        ValidationAssert();
    }

    @When("user delete data rescode-API")
    public void userDeleteDataRescodeAPI() {
        Res = REQ_SPEC.headers(header).when().delete("/responsecode-api/"+Result_code+"/delete");
        makeSomeLog();
    }

    @Then("success delete data rescode-API")
    public void successDeleteDataRescodeAPI() {
        ValidationAssert();
        approval_request_uuid = Res.getBody().jsonPath().get("responseCode.approvalRequestUUID");
        System.out.println(approval_request_uuid);
    }

    @Given("Approve delete data rescode-API")
    public void approveDeleteDataRescodeAPI() {
        String Path = "/responsecode-api/approval/"+approval_request_uuid+"/edit";
        Approvedata(Path);
    }

    @Then("Success approve delete rescode-API")
    public void successApproveDeleteRescodeAPI() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        AssertDBNull("Select * from result_map where result_code ='"+resultmap+"';", 0);
        Assert.assertEquals(null, Data3);
    }

    @After
    public void afterTest (){
        //Reset Values
        REQ_SPEC.baseUri(null);
    }
}
