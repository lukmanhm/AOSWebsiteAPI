package Steps;

import Utils.base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class MyStepdefs_Property_API extends base {

    JSONObject jobj = new JSONObject();
    String Path = "/property-api/approval/"+approval_request_uuid+"/edit";
    @Before
    public void setup () {
        //Test Setup
        BaseURL();
    }

    @Given("input Property API")
    public void inputPropertyAPI() {
        jobj.put("name", "Lukman-Testing");
        jobj.put("module", "aos.settings");
        jobj.put("value", "tf");
        jobj.put("requestedComment", "test buat property baru");
        header.put("Authorization", "Bearer " + access_token);
        Res = REQ_SPEC.headers(header).body(jobj).when().post("/property-api/add");
        makeSomeLogAll();
    }

    @Then("data Property API")
    public void dataPropertyAPI() {
        ValidationAssert();
        approval_request_uuid = Res.getBody().jsonPath().get("property.approvalRequestUUID");
        property_module = Res.getBody().jsonPath().get("property.module");
        property_name = Res.getBody().jsonPath().get("property.name");
    }

    @Given("approve data Property API")
    public void approveDataPropertyAPI() {
      Approvedata(Path);
    }

    @Then("Success approve add Property API")
    public void successApproveAddPropertyAPI() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        SetUpConnection("Select * from property where name ='Lukman-Testing';", 1, 3, 0);
        Assert.assertEquals("Lukman-Testing", Data1);
        Assert.assertEquals("tf", Data2);
    }

    @Given("Edit data Property API")
    public void editDataPropertyAPI() {
        jobj.put("value", "tf-edit");
        jobj.put("status", 1);
        jobj.put("requestedComment", "test buat edit property");
    }

    @When("Verify Property API is from approve data")
    public void verifyPropertyAPIIsFromApproveData() {
        Res = REQ_SPEC.headers(header).body(jobj).when().put("/property-api/"+property_module+"/"+property_name+"/edit");
        makeSomeLogAll();
    }

    @Then("edit data Property API is success")
    public void editDataPropertyAPIIsSuccess() {
        ValidationAssert();
        System.out.println(approval_request_uuid);
        approval_request_uuid = Res.getBody().jsonPath().get("property.approvalRequestUUID");

    }

    @Given("Approve edit data Property API")
    public void approveEditDataPropertyAPI() {

        Approvedata(Path);
    }

    @Then("Success approve edit data Property API")
    public void successApproveEditDataPropertyAPI() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        SetUpConnection("Select * from property where name ='Lukman-Testing';", 1, 3, 0);
        Assert.assertEquals("Lukman-Testing", Data1);
        Assert.assertEquals("tf-edit", Data2);
    }

    @Given("data Property API is exist")
    public void dataPropertyAPIIsExist() {
        Res = REQ_SPEC.headers(header).when().get("/property-api/"+property_module+"/"+property_name+"/detail");

        //checking exist
        ValidationAssert();
    }

    @When("user delete data Property API")
    public void userDeleteDataPropertyAPI() {
        Res = REQ_SPEC.headers(header).when().delete("/property-api/"+property_module+"/"+property_name+"/delete");
        makeSomeLog();
    }

    @Then("success delete data Property API")
    public void successDeleteDataPropertyAPI() {
        ValidationAssert();
        approval_request_uuid = Res.getBody().jsonPath().get("property.approvalRequestUUID");
    }

    @Given("Approve delete data Property API")
    public void approveDeleteDataPropertyAPI() {
        Approvedata(Path);
    }

    @Then("Success approve delete Property API")
    public void successApproveDeletePropertyAPI() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        AssertDBNull("Select * from property where name ='Lukman-Testing';", 0);
        Assert.assertEquals(null, Data3);
    }

    @Then("Success edit status Property")
    public void successEditStatusProperty() {
        ValidationAssert();
        approval_request_uuid = Res.getBody().jsonPath().get("property.approvalRequestUUID");
        System.out.println(approval_request_uuid);
    }

    @Given("Approve edit status Property")
    public void approveEditStatusProperty() {
        Approvedata(Path);
    }

    @Then("Success approve edit status Property")
    public void successApproveEditStatusProperty() throws SQLException, ClassNotFoundException {
        ValidationAssert();
        SetUpConnection("Select * from property where name ='Lukman-Testing';", 1, 4, 0);
        int st = Integer.parseInt(Data2);
        Assert.assertEquals(0, st);
    }

    @Given("Change status Property")
    public void changeStatusProperty() {
        header.put("Authorization", "Bearer " + access_token);
        jobj.put("status", 0);
        jobj.put("requestedComment", "Edit status");
        Res = REQ_SPEC.
                headers(header).body(jobj).when().
                put("/property-api/"+property_module+"/"+property_name+"/change-status");
        makeSomeLogAll();
    }
}
