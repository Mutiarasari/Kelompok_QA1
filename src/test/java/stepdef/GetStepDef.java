package stepdef;

import api.ReqresApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import response.ReqresResponse;
import static org.hamcrest.Matchers.equalTo;

public class GetStepDef {

    @Steps
    ReqresApi reqresApi = new ReqresApi();

    // GET LIST USER
    @When("Get list users")
    public void getListUserWithParameter() {
        reqresApi.getListUser();
    }

    @When("Send request get list users with valid endpoint")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresApi.GET_LIST_USER);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Make sure size array is {int}")
    public void makeSureSizeArrayIs(int sizeArray) {
        SerenityRest.then().body(ReqresResponse.SIZE_LIST_USER, equalTo(sizeArray));
    }

    @When("Send request get list users with invalid endpoint")
    public void sendRequestGetListUsersWithInvalidEndpoint() {
        SerenityRest.when().get(ReqresApi.GET_LIST_USER_INVALID);
    }

    @Given("Get list posts")
    public void getListPosts() {
        reqresApi.GetListPosts();
    }

    @When("Send request get list posts with valid endpoint")
    public void sendRequestGetListPostsWithValidEndpoint() {
        SerenityRest.when().get(ReqresApi.GET_LIST_POSTS);
    }

    @When("Send request get list posts with invalid endpoint")
    public void sendRequestGetListPostsWithInvalidEndpoint() {
        SerenityRest.when().get(ReqresApi.GET_LIST_USER_INVALID);
    }

    @Given("Get single user with id {string}")
    public void getSingleUserWithId(String userId) {
        reqresApi.getSingleUser(userId);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUserWithValidId() {
        SerenityRest.when().get(ReqresApi.GET_SINGLE_USER);
    }

    @And("Response body resource should contain name {string} and email {string}")
    public void responseBodyResourceShouldContainNameAndEmail(String name, String email) {
        SerenityRest.then().body(ReqresResponse.NAME, equalTo(name))
                .body(ReqresResponse.EMAIL, equalTo(email));
    }


    @Given("Get single posts with id {string}")
    public void getSinglePostsWithId(String id) { reqresApi.GetSinglePosts(id);
    }

    @When("Send Request get single posts")
    public void sendRequestGetSinglePosts() { SerenityRest.when().get(ReqresApi.GET_SINGLE_POSTS);
    }

    @Given("Get single posts with invalid id {string}")
    public void getSinglePostsWithInvalidId(String param) { reqresApi.getSingleUser(param);
    }

    @Given("Get list comment")
    public void getListComment() {
        reqresApi.GetListComments();
    }

    @When("Send Request get list comment")
    public void sendRequestGetListComment() {
        SerenityRest.when().get(ReqresApi.GET_LIST_COMMENTS_INVALID);
    }
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
}
