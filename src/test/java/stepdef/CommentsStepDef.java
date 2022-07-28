package stepdef;

import api.ReqresApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class CommentsStepDef {

    @Steps
    ReqresApi reqresApi = new ReqresApi();

    @Given("Get list comment")
    public void getListComment() {
        reqresApi.getListComments();
    }

    @When("Send Request get list comment")
    public void sendRequestGetListComment() {
        SerenityRest.when().get(ReqresApi.GET_LIST_COMMENTS);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Get single comment with id {string}")
    public void getSingleCommentWithId(String parameter) {
        reqresApi.getSingleComments(parameter);
    }

    @When("Send Request get single comment")
    public void sendRequestGetSingleComment() {
        SerenityRest.when().get(ReqresApi.GET_SINGLE_COMMENTS);
    }

    @Given("Get single comment with invalid id {string}")
    public void getSingleCommentWithInvalidId(String param1) {
        reqresApi.getSingleComments(param1);
    }

    @Given("Post create comment with valid json file")
    public void postCreateCommentWithValidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PostCreateComments.json");
        reqresApi.postCreateComments(jsonFiles);
    }

    @When("Send request post create comments")
    public void sendRequestPostCreateComments() {
        SerenityRest.when().post(ReqresApi.POST_CREATE_COMMENTS);
    }

    @Given("Post create comment with invalid json file")
    public void postCreateCommentWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PostCreateCommentsInvalid.json");
        reqresApi.postCreatePosts(jsonFiles);
    }

    @Given("Put update Comments with valid json file and id {string}")
    public void putUpdateCommentsWithValidJsonFileAndId(String par) {
        File jsonFiles = new File(ReqresApi.DIR+"/src/test/resources/json/requestbody/PutUpdateComment.json");
        reqresApi.putUpdateComments(par, jsonFiles);
    }

    @When("Send request put update Comments")
    public void sendRequestPutUpdateComments() { SerenityRest.when().put(ReqresApi.PUT_UPDATE_COMMENTS);
    }

    @Given("Put update Comments with invalid json file and id {string}")
    public void putUpdateCommentsWithInvalidJsonFileAndId(String ids) {
        File jsonFiles = new File(ReqresApi.DIR + "/src/test/resources/json/requestbody/PutUpdateCommentInvalid.json");
        reqresApi.putUpdateComments(ids, jsonFiles);
    }

    @When("Delete Comment with valid id {string}")
    public void deleteCommentWithValidId(String params) {
        reqresApi.deleteComments(params);
    }

    @When("Send request delete Comment")
    public void sendRequestDeleteComment() { SerenityRest.when().delete(ReqresApi.DELETE_COMMENT);
    }

    @Given("Delete Comment with invalid id {string}")
    public void deleteCommentWithInvalidId(String par1) {
        reqresApi.deleteComments(par1);
    }

    @And("Get single comment assert json validation")
    public void getSingleCommentAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/GetSingleCommentJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Post create comment assert json validation")
    public void postCreateCommentAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PostCreateCommentJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Put update comment assert json validation")
    public void putUpdateCommentAssertJsonValidation() {
        File jsonFile = new File(ReqresApi.JSON_FILE+"/validation/PutUpdateCommentJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
