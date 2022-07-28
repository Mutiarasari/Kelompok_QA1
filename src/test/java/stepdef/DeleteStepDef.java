package stepdef;

import api.ReqresApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class DeleteStepDef {
    
    ReqresApi reqresApi = new ReqresApi();

    // GET LIST USER
    @When("Delete todo with valid id {string}")
    public void deleteTodoWithValidId(String id) {
        reqresApi.deleteTodo(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresApi.DELETE_TODO);
    }

    @Given("Delete Posts with valid id {string}")
    public void deletePostsWithValidId(String userId) {
        reqresApi.deletePosts(userId);
    }

    @When("Send request delete Posts")
    public void sendRequestDeletePosts() { SerenityRest.when().delete(ReqresApi.DELETE_POST);
    }

    @When("Delete Comment with valid id {string}")
    public void deleteCommentWithValidId(String params) {
        reqresApi.deleteComments(params);
    }

    @When("Send request delete Comment")
    public void sendRequestDeleteComment() { SerenityRest.when().delete(ReqresApi.DELETE_COMMENT);
    }

    @Given("Delete Posts with invalid id {string}")
    public void deletePostsWithInvalidId(String parameter) {
        reqresApi.deleteComments(parameter);
    }

    @Given("Delete Comment with invalid id {string}")
    public void deleteCommentWithInvalidId(String par1) {
        reqresApi.deleteComments(par1);
    }
}
