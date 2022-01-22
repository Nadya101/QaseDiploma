package api.adapters;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseAdapter {

    public final String BASE_URL = "https://api.qase.io/v1";
    public final String TOKEN_KEY = "Token";
    public final String TOKEN_VALUE = "c3be23871adcb74a1db73a9373c9f9a2fd85a5eb";
    public final String CONTENT_TYPE_KEY = "Content-Type";
    public final String CONTENT_TYPE_VALUE = "application/json";

    Gson converter = new Gson();

    @Step("Send GET request to URL: '{url}'")
    public Response get(String url) {
        return
                given()
                        .header(TOKEN_KEY, TOKEN_VALUE)
                        .header(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE)
                .when()
                        .get(BASE_URL + url)
                .then()
                        .log().all()
                        .extract().response();
    }

    @Step("Send POST request to URL: '{url}'")
    public Response post(String url, String body) {
        return
                given()
                        .header(TOKEN_KEY, TOKEN_VALUE)
                        .header(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE)
                        .body(body)
                .when()
                        .post(BASE_URL + url)
                .then()
                        .log().all()
                        .extract().response();
    }

    @Step("Send DELETE request to URL: '{url}'")
    public Response delete(String url) {
        return
                given()
                        .header(TOKEN_KEY, TOKEN_VALUE)
                        .header(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE)
                 .when()
                        .delete(BASE_URL + url)
                .then()
                        .log().all()
                        .extract().response();
    }

}