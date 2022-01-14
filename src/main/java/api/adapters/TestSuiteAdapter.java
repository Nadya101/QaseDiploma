package api.adapters;

import api.models.TestSuite;
import io.restassured.response.Response;

public class TestSuiteAdapter extends BaseAdapter{

    public final String SUITE_URL = "/suite/%s";
    public final String SPECIFIC_TEST_SUITE = "/suite/%s/%d";


    public Response createSuite(String projectCode, TestSuite testSuite){
        return post(String.format(SUITE_URL, projectCode), converter.toJson(testSuite)).then().log().all().extract().response();
    }

    public Response getSuiteById(String projectCode, int id){
        return new BaseAdapter().get(String.format(SPECIFIC_TEST_SUITE, projectCode, id));
    }

}