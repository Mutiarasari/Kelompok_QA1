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

public class PostStepDef {

    @Steps
    ReqresApi reqresApi = new ReqresApi();

    @Given("Post create user with valid json file")
    public void postCreateUser() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PostCreateUser.json");
        reqresApi.postCreateUser(jsonFiles);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresApi.POST_CREATE_USER);
    }

    @And("Response body resource should contain name {string}, email {string}, phone {string}")
    public void responseBodyResourceShouldContainNameEmailPhone(String name, String email, String phone) {
        SerenityRest.then().body(ReqresResponse.NAME, equalTo(name))
                .body(ReqresResponse.EMAIL, equalTo(email))
                .body(ReqresResponse.PHONE, equalTo(phone));
    }

    @Given("Post create user with invalid json file")
    public void postCreateUserWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PostCreateUserInvalid.json");
        reqresApi.postCreateUser(jsonFiles);
    }

    @Given("Post create posts with valid json file")
    public void postCreatePostsWithvalidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PostCreatePosts.json");
        reqresApi.PostCreatePosts(jsonFiles);
    }

    @When("Send request post create posts")
    public void sendRequestPostCreatePosts() {
        SerenityRest.when().post(ReqresApi.POST_CREATE_POSTS);
    }

    @Given("Post create posts with invalid json file")
    public void postCreatePostsWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PostCreatePostsInvalid.json");
        reqresApi.PostCreatePosts(jsonFiles);
    }

    @Given("Post create comment with valid json file")
    public void postCreateCommentWithValidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PostCreateComments.json");
        reqresApi.PostCreateComments(jsonFiles);
    }

    @When("Send request post create comments")
    public void sendRequestPostCreateComments() {
        SerenityRest.when().post(ReqresApi.POST_CREATE_COMMENTS);
    }

    @Given("Post create comment with invalid json file")
    public void postCreateCommentWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PostCreateCommentsInvalid.json");
        reqresApi.PostCreatePosts(jsonFiles);
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
}
