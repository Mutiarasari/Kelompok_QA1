package stepdef;

import api.ReqresApi;
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
}
