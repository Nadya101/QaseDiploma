package api.adapters;

import api.models.TestCase;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TestCaseAdapter extends BaseAdapter {

    public final String CASE_URL = "/case/%s";
    public final String SPECIFIC_TEST_CASE = "/case/%s/%d";

    @Step("Create a new Test case '{testCase}' in '{projectCode}' project.")
    public Response createCase(String projectCode, TestCase testCase) {
        log.info(String.format("Create test case in project %s.", projectCode));
        return post(String.format(CASE_URL, projectCode), converter.toJson(testCase));
    }

    @Step("Get test case from '{projectCode}' project by id = '{id}'")
    public Response getCaseById(String projectCode, int id) {
        log.info(String.format("Get test case by id = '%d' from '%s' project.", id, projectCode));
        return new BaseAdapter().get(String.format(SPECIFIC_TEST_CASE, projectCode, id));
    }

    @Step("Delete test case with id = '{id}' from '{projectCode}' project")
    public Response deleteCase(String projectCode, int id){
        log.info(String.format("Delete test case with id = '%d' from '%s' project.", id, projectCode));
        return delete(String.format(SPECIFIC_TEST_CASE, projectCode, id));
    }

}