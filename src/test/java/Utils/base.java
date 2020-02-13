package Utils;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class base extends dbConnection {
    protected static RequestSpecification REQ_SPEC;
    protected static Response Res;
    protected static String admin_password;
    public static String access_token;
    protected static String approval_request_uuid;
    protected static String approval_request_uuid_status;
    protected static String approval_request_uuid_role;
    protected static String user_uuid;
    protected static String verify_code;
    protected static String approveDelete;
    protected static String username, Email;
    protected static int id_role, limitMaxTrxAmount, resultmap;
    protected static int id_cust;
    public static int int_random;
    protected static String trx_code, transactionCode;
    protected static String Result_code;
    protected static String property_module;
    protected static String property_name;
    protected static Map<String, Object> header = new HashMap<String, Object>();
    protected static Map<String, String> parameterquery = new HashMap<String, String>();
    protected static Object ValidatableResponse;


    JSONObject jobj = new JSONObject();
    protected static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void makeSomeLog() {
        try {
            ValidatableResponse = Res.then().log().ifError();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void makeSomeLogAll() {
        try {
            ValidatableResponse = Res.then().log().body();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void ValidationAssert() {
        int sc;
        String rc;
        try {
            sc = Res.getStatusCode();
            assertEquals("value is 200", 200, sc);
            rc = Res.getBody().jsonPath().get("rc");
            Assert.assertEquals("OK-000", rc);
            System.out.println(sc);
            System.out.println(rc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Approvedata(String Path) {
        try {
            jobj.put("approvalStatus", 1);
            Res = REQ_SPEC.headers(header).body(jobj).when().put(Path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void GetModule(String module, String name) {
        try {
            property_module = Res.getBody().jsonPath().get(module);
            property_name = Res.getBody().jsonPath().get(name);
            System.out.println(property_module);
            System.out.println(property_name);
        } catch (Exception e) {
            e.toString();
            System.out.println(e);
        }
    }

    public void BaseURL() {
        try {
            REQ_SPEC.given().baseUri("http://10.16.1.52:8080/v1/api"); //Setup Base URI
            header.put("Content-Type", "application/json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void params() {
        try {
            parameterquery.put("page", "0");
            parameterquery.put("size", "5");
            parameterquery.put("orderby", "requestTime");
            parameterquery.put("sort", "ASC");
            parameterquery.put("requestTime", "");
            parameterquery.put("referenceId", "");
            parameterquery.put("transactionId", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void GetApproval(String uuid) {
        try {
            approval_request_uuid = Res.getBody().jsonPath().get(uuid);
            System.out.println(approval_request_uuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void GetID(String ID) {
        try {
            id_cust = Res.getBody().jsonPath().get(ID);
            System.out.println(id_cust);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void objectsjon() {
        RolePojo rolePojo = Res.as(RolePojo.class, ObjectMapperType.GSON);
        Role role = rolePojo.getRole();
        List<Module> module = role.getModule();
        for (Module module1 : module) {
            System.out.println(module1.toString());
            Assert.assertTrue("Name is Blank", !module1.getName().equalsIgnoreCase(""));
            List<String> access = module1.getAccess();
            Assert.assertTrue("Blank", !module1.getAccess().equals(""));
        }

    }
}