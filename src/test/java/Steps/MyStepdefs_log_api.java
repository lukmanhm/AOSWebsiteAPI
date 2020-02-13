package Steps;

import Utils.base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;

import java.sql.SQLException;
import java.util.logging.Logger;

public class MyStepdefs_log_api extends base {



    @Before
    public void setup () {
        //Test Setup
        BaseURL();
    }

    @Given("Input param log api")
    public void inputParamLogApi() {
        params();
        header.put("Authorization", "Bearer " + access_token);
        Res = REQ_SPEC.queryParams(parameterquery).headers(header).when().get("/log-api");
        makeSomeLog();
        String abc = Res.asString();
        System.out.println(abc);
    }

    @Then("Success display data")
    public void successDisplayData() {
        ValidationAssert();
    }

    @Given("Input param log api detail")
    public void inputParamLogApiDetail() {
        header.put("Authorization", "Bearer " + access_token);
        REQ_SPEC.headers(header);
        REQ_SPEC.when();
        Res = REQ_SPEC.get("/log-api/1/detail");
        makeSomeLog();
    }

    @Then("Success display data detail")
    public void successDisplayDataDetail() throws SQLException, ClassNotFoundException {
        ValidationAssert();

    }
}
