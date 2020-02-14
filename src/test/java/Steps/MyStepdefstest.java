package Steps;

import Utils.base;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MyStepdefstest extends base {

    JSONObject jobj = new JSONObject();
    String Path = "/property-api/approval/"+approval_request_uuid+"/edit";
    @Before
    public void setup () {
        //Test Setup
        BaseURL();
    }

    @Given("Input param log api detail{int}")
    public void inputParamLogApiDetail(int arg0) {
        Map<String,Object> header1 = new HashMap<String,Object>();
        header1.put("Content-Type", "application/json");
        header1.put("Authorization", "Bearer " + access_token);
        Res = REQ_SPEC.headers(header1).when().get("/menu/");
        objectMenuJson();
    }
}
