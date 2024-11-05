package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.io.File;

public class ApiPages {

    String setURL, global_id;
    Response response;

    //setURL = https://gorest.co.in/public/v2/users
    public void prepareurlfor(String url) {
        switch (url) {
            case "GET_LIST_USER":
                setURL = Endpoint.GET_LIST_USER;
                break;
            case "CREATE_NEW_USER":
                setURL = Endpoint.CREATE_NEW_USER;
                break;
            case "DELETE_USER":
                setURL = Endpoint.DELETE_USER;
            case "INVALID_ENDPOINT":
                setURL = Endpoint.INVALID_ENDPOINT;
            default:
                System.out.println("input right url");
        }

        System.out.println("Valid url : " + setURL);
    }

    public void Hitapigetlistuser() {
        response = getListUsers(setURL);
        System.out.println(response.body().asString());

    }

    public void theStatus_code_should_be(Integer statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);
        System.out.println("Status code should be : " + statusCode);

    }

    public void Validationresponsebodygetlistdata() {
        List<Object> id = response.jsonPath().getList("id");
        List<Object> name = response.jsonPath().getList("name");
        List<Object> email = response.jsonPath().getList("email");
        List<Object> gender = response.jsonPath().getList("gender");
        List<Object> status = response.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");

    }

    public void validationResponseJsonWithJSONSchema(String filename) {
        File JSONFile = Utility.getJSONSchemaData(filename);
        response.then().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
        System.out.println(JSONFile);
    }

    //Create new user
    public void urlvalidforcreate() {
        response = postCreateUser(setURL);
        System.out.println(response.body().asString());
    }

    public void hitApiPostCreateUser() {
        response = postCreateUser(setURL);
        System.out.println(response.body().asString());
    }

    public void validationResponseBodyCreateNewUser() {
        JsonPath jsonPath = response.jsonPath();
        Integer id = jsonPath.get("id");
        String name = jsonPath.get("name");
        String email = jsonPath.get("email");
        String gender = jsonPath.get("gender");
        String status = jsonPath.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_id = Integer.toString(id);
    }

    //Delete user
    public void Hitapideletenewuser() {
        response = deleteUser(setURL, global_id);

    }

    //Negative test
    public void hitapigetlistuserwithinvalidendpoint() {
        response = getListUsers(setURL);
        System.out.println(response.getBody().asString());
    }

    public void responsebodymessage(String nomessage) {
        assertThat(response.getBody().asString());
    }
    public void hitapicreateinvaliduser(){
        response = postCreateInvalidUser(setURL);
        System.out.println(response.getBody().asString());
    }

    //update user
    public void hitApiUpdateData(){
        response = updateUser(setURL, global_id);
    }
    public void validationResponseBodyUpdateUser(){
        System.out.println(response.getBody().asString());
    }
}
