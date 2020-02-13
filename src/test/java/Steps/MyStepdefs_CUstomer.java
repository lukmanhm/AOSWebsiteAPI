package Steps;

import Utils.base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;

import java.sql.SQLException;

public class MyStepdefs_CUstomer extends base {

    JSONObject jobj = new JSONObject();
    String Path = "/customer/approval/"+approval_request_uuid+"/edit";
    String uuid = "customer.approvalRequestUUID";
    String cust_id = "customer.id";

    @Before
    public void setup () {
        //Test Setup
        BaseURL();
    }

    @Given("input data Customer")
    public void inputDataCustomer() {
        jobj.put("panProductType", "GOLD");
        jobj.put("accountType", 10);
        jobj.put("issuerStatus", 1);
        jobj.put("expiredDate", "07-08-2021 06:36:58");
        jobj.put("pan","6019111111111119");
        jobj.put("accountNumber","1502720171700836253");
        jobj.put("customerName","Lukman Test");
        jobj.put("phoneNumber","085782777308");
        header.put("Authorization", "Bearer " + access_token);
        Res = REQ_SPEC.headers(header).body(jobj).when().post("/customer/add");
        makeSomeLog();
    }

    @Then("data Customer is success added")
    public void dataCustomerIsSuccessAdded() {
        ValidationAssert();
        GetApproval(uuid);
        GetID(cust_id);
    }

    @Given("approve data Customer")
    public void approveDataCustomer() {
        Approvedata(Path);
    }

    @Then("Success approve add Customer")
    public void successApproveAddCustomer() throws SQLException, ClassNotFoundException {
        ValidationAssert();
    }

    @Given("Edit data Customer")
    public void editDataCustomer() {
        jobj.put("panProductType", "GOLD");
        jobj.put("accountType", 10);
        jobj.put("issuerStatus", 1);
        jobj.put("expiredDate", "07-08-2021 06:36:58");
        jobj.put("pan", "6019111111111119");
        jobj.put("accountNumber", "1502720171700836233");
        jobj.put("customerName", "Lukman Test Edit");
        jobj.put("phoneNumber", "085782777309");
    }

    @When("Verify Customer is from approve data")
    public void verifyCustomerIsFromApproveData() {
        Res = REQ_SPEC.headers(header).body(jobj).when().put("/customer/"+id_cust+"/edit");
        System.out.println(id_cust);
        makeSomeLog();
    }

    @Then("edit Customer WEB is success")
    public void editCustomerWEBIsSuccess() {
        ValidationAssert();
        GetApproval(uuid);
    }

    @Given("Approve edit data Customer")
    public void approveEditDataCustomer() {
        Approvedata(Path);
    }

    @Then("Success approve edit data Customer")
    public void successApproveEditDataCustomer() {
        ValidationAssert();
    }

    @Given("Change status Customer")
    public void changeStatusCustomer() {
        jobj.put("status", 1);
        jobj.put("requestedComment","test edit customer");
        Res = REQ_SPEC.headers(header).body(jobj).when().put("/customer/"+id_cust+"/change-status");
        makeSomeLog();
        System.out.println(id_cust);
        System.out.println(Res);
    }

    @Then("Success edit status Customer")
    public void successEditStatusCustomer() {
        ValidationAssert();
        GetApproval(uuid);
        System.out.println(approval_request_uuid);
    }

    @Given("Approve edit status Customer")
    public void approveEditStatusCustomer() {
        Approvedata(Path);
    }

    @Then("Success approve edit status Customer")
    public void successApproveEditStatusCustomer() {
        ValidationAssert();
    }

    @Given("data Customer is exist")
    public void dataCustomerIsExist() {
        Res = REQ_SPEC.headers(header).when().get("/customer/"+id_cust+"/detail");
        makeSomeLog();
        //checking exist
        ValidationAssert();
    }

    @When("user delete data Customer")
    public void userDeleteDataCustomer() {
        Res = REQ_SPEC.headers(header).when().delete("/customer/"+id_cust+"/delete");
        makeSomeLog();
    }

    @Then("success delete data Customer")
    public void successDeleteDataCustomer() {
        ValidationAssert();
        GetApproval(uuid);
    }

    @Given("Approve delete data Customer")
    public void approveDeleteDataCustomer() {
        Approvedata(Path);
    }

    @Then("Success approve delete Customer")
    public void successApproveDeleteCustomer() {
        ValidationAssert();
    }
}
