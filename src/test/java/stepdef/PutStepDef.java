package stepdef;

import api.ReqresApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import response.ReqresResponse;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PutStepDef {
    
    ReqresApi reqresApi = new ReqresApi();
    
    // GET LIST USER
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
}
