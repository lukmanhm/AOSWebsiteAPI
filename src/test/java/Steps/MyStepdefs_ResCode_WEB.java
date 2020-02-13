package Steps;

import Utils.base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;

import java.sql.SQLException;

public class MyStepdefs_ResCode_WEB extends base {
    JSONObject jobj = new JSONObject();
    String Path = "/responsecode-web/approval/"+approval_request_uuid+"/edit";
    String uuid = "responseCodeWeb.approvalRequestUUID";
    int rc_web = 902;
    @Before
    public void setup () {
        //Test Setup
        BaseURL();
    }

    @Given("input data rescode-WEB")
    public void inputDataRescodeWEB() {
        jobj.put("rc", rc_web);
        jobj.put("description", "test lukman result code web");
        jobj.put("requestedComment", "test buat result code baru");
        header.put("Authorization", "Bearer " + access_token);
        System.out.println(access_token);
        Res = REQ_SPEC.headers(header).body(jobj).when().post("/responsecode-web/add");
        makeSomeLog();
    }

    @Then("data success rescode-WEB")
    public void dataSuccessRescodeWEB() {
        ValidationAssert();
        GetApproval(uuid);

    }

    @Given("approve data rescode-WEB")
    public void approveDataRescodeWEB() {
        Approvedata(Path);
    }

    @Then("Success approve add rescode-WEB")
    public void successApproveAddRescodeWEB() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        SetUpConnection("select * from web_response_code where result_code ='"+rc_web+"';", 6, 5, 1);
        int rc = Integer.parseInt(Data1);
        Assert.assertEquals(rc_web, rc);
        Assert.assertEquals("test lukman result code web", Data2);
    }

    @Given("Edit data rescode-WEB")
    public void editDataRescodeWEB() {
        jobj.put("rc", rc_web);
        jobj.put("description", "edit test");
        jobj.put("requestedComment", "test buat edit respcode web");
    }

    @When("Verify rescode-WEB is from approve data")
    public void verifyRescodeWEBIsFromApproveData() {
        Res = REQ_SPEC.headers(header).body(jobj).when().put("/responsecode-web/"+rc_web+"/edit");
        makeSomeLog();
    }

    @Then("edit data rescode-WEB is success")
    public void editDataRescodeWEBIsSuccess() {
        ValidationAssert();
        GetApproval(uuid);
    }

    @Given("Approve edit data rescode-WEB")
    public void approveEditDataRescodeWEB() {
        Approvedata(Path);
    }

    @Then("Success approve edit data rescode-WEB")
    public void successApproveEditDataRescodeWEB() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        SetUpConnection("select * from web_response_code where result_code ='"+rc_web+"';", 6, 5, 1);
        int rc = Integer.parseInt(Data1);
        Assert.assertEquals(rc_web, rc);
        Assert.assertEquals("edit test", Data2);
    }

    @Given("data rescode-WEB is exist")
    public void dataRescodeWEBIsExist() {

        Res = REQ_SPEC.headers(header).when().get("/responsecode-web/"+rc_web+"/detail");
        makeSomeLog();
        //checking exist
        ValidationAssert();
        makeSomeLogAll();

    }

    @When("user delete data rescode-WEB")
    public void userDeleteDataRescodeWEB() {

        Res = REQ_SPEC.headers(header).when().delete("/responsecode-web/"+rc_web+"/delete");
        makeSomeLogAll();
    }

    @Then("success delete data rescode-WEB")
    public void successDeleteDataRescodeWEB() {
        ValidationAssert();
        GetApproval(uuid);
    }

    @Given("Approve delete data rescode-WEB")
    public void approveDeleteDataRescodeWEB() {
        Approvedata(Path);
    }

    @Then("Success approve delete rescode-WEB")
    public void successApproveDeleteRescodeWEB() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        AssertDBNull("select * from web_response_code where result_code ='"+rc_web+"';", 1);
        Assert.assertEquals(null, Data3);
    }
}
