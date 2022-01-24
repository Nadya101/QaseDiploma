package api.adapters;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import ui.constants.IConstants;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseAdapter implements IConstants {

    private static final String TOKEN_KEY = "Token";
    private static final String TOKEN_VALUE = System.getProperty("TOKEN", PropertyReader.getProperty("TOKEN"));
    private static final String CONTENT_TYPE_KEY = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";

    Gson converter = new Gson();

    @Step("Send GET request to URL: '{url}'")
    public Response get(String url) {
        return
                given()
                        .header(TOKEN_KEY, TOKEN_VALUE)
                        .header(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE)
                        .when()
                        .get(BASE_API_URL + url)
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
                        .post(BASE_API_URL + url)
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
                        .delete(BASE_API_URL + url)
                        .then()
                        .log().all()
                        .extract().response();
    }

}