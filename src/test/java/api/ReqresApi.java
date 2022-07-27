package api;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ReqresApi {

    public static final String URL = "https://jsonplaceholder.typicode.com/";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/json/";

    // GET
    public static String GET_LIST_USER = URL+"users";
    public static String GET_LIST_USER_INVALID = URL+"usersss";
    public static String GET_LIST_POSTS = URL+"posts";
    public static String GET_LIST_POST_INVALID = URL+"postssssss";

    @Step("Get list user")
    public void getListUser() {
        SerenityRest.given();
    }

    @Step("Get list posts")
    public void GetListPosts(){
        SerenityRest.given();
    }

}
