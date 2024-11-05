package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;

public class Models {

    private static RequestSpecification request;

    public static void setupHeaders(){
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer e3e45819577727d4cf41d895423607c030916c945a2ae1858b38434e018ec120");
    }

    public static Response getListUsers(String endpoint){
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response postCreateUser(String endpoint){
        String name = "Rizky Fachrieza Yalvinsya";
        String gender = "male";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.when().body(payload.toString()).when().post(endpoint);
    }
    public static Response deleteUser(String endpoint, String user_id){
        setupHeaders();
        String finalendpoint = endpoint + "/" + user_id;
        return request.when().delete(finalendpoint);
    }

    public static Response postCreateInvalidUser(String endpoint){
        String name = "Rizky Fachrieza Yalvinsya";
        String gender = "male";
        String email = " ";

        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.when().body(payload.toString()).when().post(endpoint);
    }

    public static Response updateUser(String endpoint, String user_id){
        String name = "Rizky Yalvinsya";
        String gender = "male";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();

        String finalendpoint = endpoint + "/" + user_id;
        return request.body(payload.toString()).when().patch(finalendpoint);

    }
}
