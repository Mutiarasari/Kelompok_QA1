package stepdef;

import api.ReqresApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import response.ReqresResponse;
import static org.hamcrest.Matchers.equalTo;

public class GetStepDef {

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
}
