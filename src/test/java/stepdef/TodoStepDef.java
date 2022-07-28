package stepdef;

import api.ReqresApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import response.ReqresResponse;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class TodoStepDef {

    @Steps
    ReqresApi reqresApi = new ReqresApi();

    @Given("Get list todos with valid endpoint")
    public void getListTodosWithValidEndpoint() {
        reqresApi.getListTodos();
    }

    @When("Send request get list todos")
    public void sendRequestGetListTodos() {
        SerenityRest.when().get(ReqresApi.GET_LIST_TODOS);
    }

    @And("Response body resource list should contain title {string}, complete {string}")
    public void responseBodyResourceShouldContainTitleComplete(String title, String isComplete) {
        SerenityRest.then().body(ReqresResponse.LIST_TODO_TITLE, equalTo(title))
                .body(ReqresResponse.LIST_TODO_COMPLETED, equalTo(Boolean.parseBoolean(isComplete)));
    }

    @Given("Get single todo with valid id {string}")
    public void getSingleTodoWithValidId(String userId) {
        reqresApi.getSingleUser(userId);
    }

    @When("Send request get single todo")
    public void sendRequestGetSingleTodo() {
        SerenityRest.when().get(ReqresApi.GET_SINGLE_TODOS);
    }

    @And("Response body resource single should contain title {string}, complete {string}")
    public void responseBodyResourceSingleShouldContainTitleComplete(String title, String isComplete) {
        SerenityRest.then().body(ReqresResponse.SINGLE_TODO_TITLE, equalTo(title))
                .body(ReqresResponse.SINGLE_TODO_COMPLETED, equalTo(Boolean.parseBoolean(isComplete)));

    }

    @Given("Get list todo with valid userId {string}")
    public void getListTodoWithValidUserId(String userId) {
        reqresApi.getListTodosWithParameterUserid(userId);
    }

    @When("Send request get list todos with parameter")
    public void sendRequestGetListTodosWithParameter() {
        SerenityRest.when().get(ReqresApi.GET_LIST_TODOS_WITH_PARAMETER_USERID);
    }

    @Given("Post create todo with valid json file")
    public void postCreateTodoWithValidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PostCreateTodo.json");
        reqresApi.postCreateUser(jsonFiles);
    }

    @When("Send request post create todo")
    public void sendRequestPostCreateTodo() {
        SerenityRest.when().post(ReqresApi.POST_CREATE_TODO);
    }

    @And("Response body resource should contain title {string}, complete {string}, id {int}")
    public void responseBodyResourceShouldContainTitleCompleteId(String title, String isComplete, int id) {
        SerenityRest.then().body(ReqresResponse.SINGLE_TODO_TITLE, equalTo(title))
                .body(ReqresResponse.SINGLE_TODO_COMPLETED, equalTo(Boolean.parseBoolean(isComplete)))
                .body(ReqresResponse.ID, equalTo(id));
    }

    @Given("Post create todo with invalid json file")
    public void postCreateTodoWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PostCreateTodoInvalid.json");
        reqresApi.postCreateUser(jsonFiles);
    }

    @When("Delete todo with valid id {string}")
    public void deleteTodoWithValidId(String id) {
        reqresApi.deleteTodo(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresApi.DELETE_TODO);
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
