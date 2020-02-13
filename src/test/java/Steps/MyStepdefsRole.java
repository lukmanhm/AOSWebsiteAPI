package Steps;

import Utils.Module;
import Utils.Role;
import Utils.RolePojo;
import Utils.base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;


public class MyStepdefsRole extends base {


    @Given("go to url")
    public void goToUrl() {
        REQ_SPEC = given().baseUri("http://10.16.1.52:8080/v1/api");
    }

    @When("input json array")
    public void inputJsonArray() throws Exception{
        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put("Content-Type", "application/json");
        header1.put("Authorization", "Bearer " + access_token);
        String path = "target/classes/JsonText.json";
        File file = new File(path);
//        List<String> content = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
//        System.out.println(content);
        REQ_SPEC.headers(header1);
        REQ_SPEC.body(file);
        REQ_SPEC.when();
        Res = REQ_SPEC.post("/role/add");
        makeSomeLog();

    }

    @Then("sc is {int} and rc is {string}")
    public void scIsAndRcIs(int arg0, String arg1) {
        ValidationAssert();
        objectsjon();
        approval_request_uuid_role = Res.getBody().jsonPath().get("role.approvalRequestUUID");
        System.out.println(approval_request_uuid_role);
        id_role = Res.getBody().jsonPath().get("role.id");
        System.out.println(id_role);
        System.out.println("Success add");

        makeSomeLogAll();
    }

    @When("approve data")
    public void approveData() {
        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put("Authorization", "Bearer " + access_token);
        header1.put("Content-Type", "application/json");
        JSONObject jobj = new JSONObject();
        jobj.put("approvalStatus", "1");
        jobj.put("approvalReason", "approved");
        System.out.println(approval_request_uuid_role);
        Res = REQ_SPEC.headers(header1).body(jobj).when().put("/role/approval/"+ approval_request_uuid_role+"/edit");
        makeSomeLog();
    }

    @Then("success approve new role")
    public void successApproveNewRole() {
        ValidationAssert();

        System.out.println("Success approve action");
    }


    @When("edit json array")
    public void editJsonArray() {
        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put("Content-Type", "application/json");
        header1.put("Authorization", "Bearer " + access_token);
        File file1 = new File("target/classes/JsonText.json");
        System.out.println(file1.getAbsolutePath());
        REQ_SPEC.headers(header1);
        REQ_SPEC.body(file1);
        REQ_SPEC.when();
        Res = REQ_SPEC.put("/role/"+id_role+"/edit");
        makeSomeLog();
    }

    @Then("success edit data role")
    public void successEditDataRole() {
        ValidationAssert();
        objectsjon();
        approval_request_uuid_role = Res.getBody().jsonPath().get("role.approvalRequestUUID");
        System.out.println(approval_request_uuid_role);
        System.out.println("Success edit");
    }

    @Then("success approve edit role")
    public void successApproveEditRole() {
        ValidationAssert();
        System.out.println("Success approve edit data role");
    }

    @When("Delete role")
    public void deleteRole() {
        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put("Authorization", "Bearer " + access_token);
        header1.put("Content-Type", "application/json");
        JSONObject obj = new JSONObject();
        obj.put("requestedComment", "Delete");
        Res = REQ_SPEC.headers(header1).body(obj).when().delete("/role/"+id_role+"/delete");
        makeSomeLog();
    }

    @Then("Success delete")
    public void successDelete() {
        ValidationAssert();
        approval_request_uuid_role = Res.getBody().jsonPath().get("role.approvalRequestUUID");
        System.out.println(approval_request_uuid_role);
        System.out.println("Success Delete");
    }

}
