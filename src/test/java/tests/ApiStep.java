package tests;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPages;



public class ApiStep {

    ApiPages apiPages;

    public ApiStep() {
        this.apiPages = new ApiPages();
    }

    @Given("Url valid for {string}")
    public void theUrlvalidfor(String url) {
        apiPages.prepareurlfor(url);

    }
    @And("Hit api get list user")
    public void Hitapigetlistuser() {
        apiPages.Hitapigetlistuser();

    }

    @Then("Status code should be {int}")
    public void theStatus_code_should_be(Integer statusCode) {
        apiPages.theStatus_code_should_be(statusCode);
    }

    @Then("Validation response body get list data")
    public void Validationresponsebodygetlistdata(){
        apiPages.Validationresponsebodygetlistdata();
    }

    @Then("Validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPages.validationResponseJsonWithJSONSchema(filename);
    }


    @Then("Hit api post create user")
    public void hitApiPostCreateUser() {
        apiPages.hitApiPostCreateUser();
    }

    @Then("Validation response body create new user")
    public void validationResponseBodyCreateNewUser() {
        apiPages.validationResponseBodyCreateNewUser();
    }

    @And("Hit api delete new")
    public void hitApiDeleteNew() {
        apiPages.Hitapideletenewuser();
    }

    //negative test
    @Given("Url invalid for {string}")
    public void urlinvalidfor(String url){
        apiPages.prepareurlfor(url);
    }

    @Then("Hit api get list user with invalid endpoint")
    public void hitApiGetListUserWithInvalidEndpoint() {
        apiPages.hitapigetlistuserwithinvalidendpoint();
    }

    @And("Response body containt {string}")
    public void responseBodyContaintNoMessage(String nomessage) {
        apiPages.responsebodymessage(nomessage);
    }

    @Then("Hit api post create invalid user")
    public void hitApiPostCreateInvalidUser() {
        apiPages.hitapicreateinvaliduser();
    }

    @And("Hit api update data")
    public void hitApiUpdateData() {
        apiPages.hitApiUpdateData();
    }

    @Then("Validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPages.validationResponseBodyUpdateUser();
    }

}
