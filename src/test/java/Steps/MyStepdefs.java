package Steps;

import Utils.base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.restassured.response.ResponseBody;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class MyStepdefs extends base {

    @Given("password is encrypted")
    public void passwordIsEncrypted() {
        REQ_SPEC = given().baseUri("http://10.16.1.52:8080/v1/api");
        admin_password = DigestUtils.sha256Hex("masukaja2" + "AOS_4lt0");
    }

    @When("I submit post with name and password")
    public void iSubmitPostWithNameAndPassword() {
        JSONObject body_json = new JSONObject();
        String username = "irvanadmin";
        String password1 = admin_password.toUpperCase();
        body_json.put("username", username);
        body_json.put("password", password1);

        //Headers
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type", "application/json");

        Res = REQ_SPEC.headers(headers).body(body_json).when().post("/auth/login");
        makeSomeLog();
    }

    @Then("response code as {int}")
    public void responseCodeAs(int StatusCode) {

        access_token = Res.getBody().jsonPath().get("token.accessToken");
        ValidationAssert();

    }

    void assertEquals(int statusCode, int i, String correct) {
    }

    @When("get path statuslist")
    public void getPathStatuslist() {
    }

    @Given("give param {string}")
    public void giveParam(String auth) {
        REQ_SPEC = given().baseUri("http://10.16.1.52:8080/v1/api");
        //Headers
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Authorization", "Bearer " + access_token);
        System.out.println(headers.toString());
        Res = REQ_SPEC.headers(headers).when().get("/user/status-list");
        makeSomeLog();
    }

    @Then("Response code status as {int}")
    public void responseCodeStatusAs(int statusCode) {
        ResponseBody test = Res.getBody();
        statusCode = Res.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println(test.asString());
    }

}