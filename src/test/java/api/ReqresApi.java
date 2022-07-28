package api;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresApi {

    public static final String URL = "https://jsonplaceholder.typicode.com/";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/json/";

    // GET
    public static String GET_LIST_USER = URL+"users";
    public static String GET_LIST_USER_INVALID = URL+"usersss";
    public static String GET_LIST_POSTS = URL+"posts";
    public static String GET_LIST_POST_INVALID = URL+"postssssss";
    public static String GET_SINGLE_USER = URL+"users/{id}";

    // POST
    public static String POST_CREATE_USER = URL+"users";

    // PUT
    public static String PUT_UPDATE_USER = URL+"users/{id}";

    @Step("Get list user")
    public void getListUser() {
        SerenityRest.given();
    }

    @Step("Get single user with id")
    public void getSingleUser(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get list posts")
    public void GetListPosts(){
        SerenityRest.given();
    }

    @Step("Post create user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(String id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
