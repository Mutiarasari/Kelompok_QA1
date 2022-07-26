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
    public static String GET_SINGLE_POSTS = URL+"posts/{id}";
    public static String GET_LIST_COMMENTS = URL+"comments";
    public static String GET_LIST_COMMENTS_INVALID = URL+"commentssss";
    public static String GET_SINGLE_COMMENTS = URL+"comments/{id}";
    public static String GET_LIST_TODOS = URL+"todos";
    public static String GET_LIST_TODOS_WITH_PARAMETER_USERID = URL+"todos?userId={id}";
    public static String GET_SINGLE_TODOS = URL+"todos/{id}";
 

    // POST
    public static String POST_CREATE_USER = URL+"users";
    public static String POST_CREATE_POSTS = URL+"posts";
    public static String POST_CREATE_COMMENTS = URL+"comments";
    public static String POST_CREATE_TODO = URL+"todos";

    // PUT
    public static String PUT_UPDATE_USER = URL+"users/{id}";
    public static String PUT_UPDATE_POSTS = URL+"posts/{id}";
    public static String PUT_UPDATE_COMMENTS = URL+"comments/{id}";
    public static String PUT_UPDATE_TODO = URL+"todos/{id}";

    // DELETE
    public static String DELETE_TODO = URL+"todos/{id}";
    public static String DELETE_POST = URL+"posts/{id}";
    public static String DELETE_COMMENT = URL+"comments/{id}";
    public static String DELETE_USER = URL+"users/{id}";

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
    public void getListPosts(){
        SerenityRest.given();
    }

    @Step("Get single posts")
    public void getSinglePosts(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get list comments")
    public void getListComments(){
        SerenityRest.given();
    }

    @Step("Get single comments")
    public void getSingleComments(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Get list todos")
    public void getListTodos(){
        SerenityRest.given();
    }

    @Step("Get list todos with parameter userId")
    public void getListTodosWithParameterUserid(String userId){
        SerenityRest.given()
                .pathParam("id", userId);
    }

    @Step("Get single todos")
    public void getSingleTodos(String todoId){
        SerenityRest.given()
                .pathParam("id", todoId);
    }

    @Step("Post create user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create posts")
    public void postCreatePosts(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create comments")
    public void postCreateComments(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create todo")
    public void postCreateTodo(File json){
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
    @Step("Put update posts")
    public void putUpdatePosts(String id,File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update comments")
    public void putUpdateComments(String id,File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update todo")
    public void putUpdateTodo(String id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete todo")
    public void deleteTodo(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete Posts")
    public void deletePosts(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Delete Comments")
    public void deleteComments(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Delete user")
    public void deleteUser(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}
