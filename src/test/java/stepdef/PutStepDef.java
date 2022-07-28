package stepdef;

import api.ReqresApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import response.ReqresResponse;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PutStepDef {
    
    ReqresApi reqresApi = new ReqresApi();
    
    // GET LIST USER
    @When("Put update user with valid json file and id {string}")
    public void putUpdateUserWithValiJsonFile(String id) {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PutUpdateUser.json");
        reqresApi.putUpdateUser(id, jsonFiles);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresApi.PUT_UPDATE_USER);
    }

    @And("Response body resource should contain name {string}, email {string}, phone {string}, id {int}")
    public void responseBodyResourceShouldContainNameEmailPhoneId(String name, String email, String phone, int id) {
        SerenityRest.then().body(ReqresResponse.NAME, equalTo(name))
                .body(ReqresResponse.EMAIL, equalTo(email))
                .body(ReqresResponse.PHONE, equalTo(phone))
                .body(ReqresResponse.ID, equalTo(id));
    }

    @Given("Put update user with invalid json file and id {string}")
    public void putUpdateUserWithInvalidJsonFileAndId(String id) {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PutUpdateUserInvalid.json");
        reqresApi.putUpdateUser(id, jsonFiles);
    }

    @Given("Put update todo with valid json file and id {string}")
    public void putUpdateTodoWithValidJsonFileAndId(String id) {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PutUpdateTodo.json");
        reqresApi.putUpdateTodo(id, jsonFiles);
    }

    @When("Send request put update todo")
    public void sendRequestPutUpdateTodo() {
        SerenityRest.when().put(ReqresApi.PUT_UPDATE_TODO);
    }

    @And("Response body resource should contain title {string}, completed {string}")
    public void responseBodyResourceShouldContainTitleCompleted(String title, String isCompleted) {
        SerenityRest.then().body(ReqresResponse.SINGLE_TODO_TITLE, equalTo(title))
                .body(ReqresResponse.SINGLE_TODO_COMPLETED, equalTo(Boolean.parseBoolean(isCompleted)));
    }

    @Given("Put update todo with invalid json file and id {string}")
    public void putUpdateTodoWithInvalidJsonFileAndId(String id) {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PutUpdateTodoInvalid.json");
        reqresApi.putUpdateTodo(id, jsonFiles);
    }

    @Given("Put update todo with invalid id {string}")
    public void putUpdateTodoWithInvalidId(String id) {
    }
}
