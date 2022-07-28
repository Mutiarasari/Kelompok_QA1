package stepdef;

import api.ReqresApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import response.ReqresResponse;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UserStepDef {

    @Steps
    ReqresApi reqresApi = new ReqresApi();

    @When("Get list users")
    public void getListUserWithParameter() {
        reqresApi.getListUser();
    }

    @When("Send request get list users with valid endpoint")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresApi.GET_LIST_USER);
    }


    @And("Make sure size array is {int}")
    public void makeSureSizeArrayIs(int sizeArray) {
        SerenityRest.then().body(ReqresResponse.SIZE_LIST_USER, equalTo(sizeArray));
    }

    @When("Send request get list users with invalid endpoint")
    public void sendRequestGetListUsersWithInvalidEndpoint() {
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
        reqresApi.postCreatePosts(jsonFiles);
    }

    @When("Send request post create posts")
    public void sendRequestPostCreatePosts() {
        SerenityRest.when().post(ReqresApi.POST_CREATE_POSTS);
    }

    @Given("Post create posts with invalid json file")
    public void postCreatePostsWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PostCreatePostsInvalid.json");
        reqresApi.postCreatePosts(jsonFiles);
    }

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

    @And("Get single user assert json validation")
    public void getSingleResourceAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/GetSingleUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Post create user assert json validation")
    public void postCreateUserAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PostCreateUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Put update user assert json validation")
    public void putUpdateUserAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PutUpdateUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Delete user with valid id {string}")
    public void deleteUserWithValidId(String id) {
        reqresApi.deleteUser(id);
    }

    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        reqresApi.deleteUser(id);
    }

    @And("Post create posts assert json validation")
    public void postCreatePostsAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PutUpdatePostJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
