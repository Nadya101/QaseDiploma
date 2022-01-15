package api.adapters;

import api.models.TestSuite;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TestSuiteAdapter extends BaseAdapter {

    public final String SUITE_URL = "/suite/%s";
    public final String SPECIFIC_TEST_SUITE = "/suite/%s/%d";

    @Step("Create a new suite case in '{projectCode}' project")
    public Response createSuite(String projectCode, TestSuite testSuite) {
        log.info(String.format("Create new test suite in '%s' project.", projectCode));
        return post(String.format(SUITE_URL, projectCode), converter.toJson(testSuite)).then().log().all().extract().response();
    }

    @Step("Get suite case from '{projectCode}' by id = '{id}'")
    public Response getSuiteById(String projectCode, int id) {
        log.info(String.format("Get test suite with id = '%d' from '%s' project.", id, projectCode));
        return new BaseAdapter().get(String.format(SPECIFIC_TEST_SUITE, projectCode, id));
    }

}