package stepdef;

import api.ReqresApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class PostsStepDef {

    @Steps
    ReqresApi reqresApi = new ReqresApi();

    @Given("Get list posts")
    public void getListPosts() {
        reqresApi.getListPosts();
    }

    @When("Send request get list posts with valid endpoint")
    public void sendRequestGetListPostsWithValidEndpoint() {
        SerenityRest.when().get(ReqresApi.GET_LIST_POSTS);
    }

    @When("Send request get list posts with invalid endpoint")
    public void sendRequestGetListPostsWithInvalidEndpoint() {
        SerenityRest.when().get(ReqresApi.GET_LIST_USER_INVALID);
    }

    @Given("Get single posts with id {string}")
    public void getSinglePostsWithId(String id) { reqresApi.getSinglePosts(id);
    }

    @When("Send Request get single posts")
    public void sendRequestGetSinglePosts() { SerenityRest.when().get(ReqresApi.GET_SINGLE_POSTS);
    }

    @Given("Get single posts with invalid id {string}")
    public void getSinglePostsWithInvalidId(String param) { reqresApi.getSingleUser(param);
    }


    @Given("Put update posts with valid json file and id {string}")
    public void putUpdatePostsWithValidJsonFileAndId(String id) {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PutUpdatePosts.json");
        reqresApi.putUpdatePosts(id, jsonFiles);
    }

    @When("Send request put update posts")
    public void sendRequestPutUpdatePosts() { SerenityRest.when().put(ReqresApi.PUT_UPDATE_POSTS);
    }

    @Given("Put update posts with invalid json file and id {string}")
    public void putUpdatePostsWithInvalidJsonFileAndId(String ID) {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PutUpdatePostsInvalid.json");
        reqresApi.putUpdatePosts(ID, jsonFiles);
    }

    @Given("Delete Posts with valid id {string}")
    public void deletePostsWithValidId(String userId) {
        reqresApi.deletePosts(userId);
    }

    @When("Send request delete Posts")
    public void sendRequestDeletePosts() { SerenityRest.when().delete(ReqresApi.DELETE_POST);
    }


    @Given("Delete Posts with invalid id {string}")
    public void deletePostsWithInvalidId(String parameter) {
        reqresApi.deleteComments(parameter);
    }

}
