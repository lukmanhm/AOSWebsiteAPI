package Steps;

import Utils.base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;

import java.sql.SQLException;

public class MyStepdefs_Property_WEB extends base {
    JSONObject jobj = new JSONObject();
    String Path = "/property-web/approval/"+approval_request_uuid+"/edit";
    String uuid = "propertyWeb.approvalRequestUUID";
    String name = "propertyWeb.name";
    String module = "propertyWeb.module";

    @Before
    public void setup () {
        //Test Setup
        BaseURL();
    }
    @Given("input Property WEB")
    public void inputPropertyWEB() {
        jobj.put("name", "Lukman-Test");
        jobj.put("module", "Test");
        jobj.put("value", "Testing ABC");
        jobj.put("requestedComment", "test buat property web baru");
        header.put("Authorization", "Bearer " + access_token);
        Res = REQ_SPEC.headers(header).body(jobj).when().post("/property-web/add");
        makeSomeLog();
    }

    @Then("data Property WEB")
    public void dataPropertyWEB() {
        ValidationAssert();
        GetApproval(uuid);
        GetModule(module, name);
    }

    @Given("approve data Property WEB")
    public void approveDataPropertyWEB() {
        Approvedata(Path);
    }

    @Then("Success approve add Property WEB")
    public void successApproveAddPropertyWEB() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        SetUpConnection("select * from web_property where module='Test';", 2, 1, 1);
        Assert.assertEquals("Lukman-Test", Data1);
        Assert.assertEquals("Test", Data2);
    }

    @Given("Edit data Property WEB")
    public void editDataPropertyWEB() {
        jobj.put("module", "Test");
        jobj.put("value", "Testing ABC-edited");
        jobj.put("requestedComment", "test buat property web baru");
    }

    @When("Verify Property WEB is from approve data")
    public void verifyPropertyWEBIsFromApproveData() {
        Res = REQ_SPEC.headers(header).body(jobj).
                when().put("/property-web/"+property_module+"/"+property_name+"/edit");
        makeSomeLogAll();
    }

    @Then("edit data Property WEB is success")
    public void editDataPropertyWEBIsSuccess() {
        ValidationAssert();
        GetApproval(uuid);
    }

    @Given("Approve edit data Property WEB")
    public void approveEditDataPropertyWEB() {
        Approvedata(Path);
    }

    @Then("Success approve edit data Property WEB")
    public void successApproveEditDataPropertyWEB() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        SetUpConnection("select * from web_property where module='Test';", 7, 1, 1);
        Assert.assertEquals("Testing ABC-edited", Data1);
        Assert.assertEquals("Test", Data2);
    }

    @Given("Change status Property WEB")
    public void changeStatusPropertyWEB() {
        jobj.put("status", 1);
        jobj.put("requestedComment","test edit customer");
        Res = REQ_SPEC.headers(header).body(jobj).when().put("/property-web/"+property_module+"/"+property_name+"/change-status");
        makeSomeLog();
    }

    @Then("Success edit status Property WEB")
    public void successEditStatusPropertyWEB() {
        ValidationAssert();
        GetApproval(uuid);
    }

    @Given("Approve edit status Property WEB")
    public void approveEditStatusPropertyWEB() {
        Approvedata(Path);
    }

    @Then("Success approve edit status Property WEB")
    public void successApproveEditStatusPropertyWEB() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        SetUpConnection("select * from web_property where module='Test';", 6, 1, 1);
        int sc = Integer.parseInt(Data1);
        Assert.assertEquals(1, sc);
    }

    @Given("data Property WEB is exist")
    public void dataPropertyWEBIsExist() {
        Res = REQ_SPEC.headers(header).when().get("/property-web/"+property_module+"/"+property_name+"/detail");
        makeSomeLog();
        //checking exist
        ValidationAssert();
    }

    @When("user delete data Property WEB")
    public void userDeleteDataPropertyWEB() {
        Res = REQ_SPEC.headers(header).when().delete("/property-web/"+property_module+"/"+property_name+"/delete");
        makeSomeLog();
    }

    @Then("success delete data Property WEB")
    public void successDeleteDataPropertyWEB() {
        ValidationAssert();
        GetApproval(uuid);
    }

    @Given("Approve delete data Property WEB")
    public void approveDeleteDataPropertyWEB() {
        Approvedata(Path);
    }

    @Then("Success approve delete Property WEB")
    public void successApproveDeletePropertyWEB() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        AssertDBNull("select * from web_property where module='Test';", 1);
        Assert.assertEquals(null, Data3);
    }
}
