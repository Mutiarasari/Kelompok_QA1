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
}
