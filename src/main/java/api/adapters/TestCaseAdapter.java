package api.adapters;

import api.models.TestCase;
import io.restassured.response.Response;

public class TestCaseAdapter extends BaseAdapter{

    public final String CASE_URL = "/case/%s";
    public final String SPECIFIC_TEST_CASE = "/case/%s/%d";


    public Response createTestCase(String projectCode, TestCase testCase){
        return post(String.format(CASE_URL, projectCode), converter.toJson(testCase));
    }

    public Response getTestById(String projectCode, int id){
        return new BaseAdapter().get(String.format(SPECIFIC_TEST_CASE, projectCode, id));
    }

}