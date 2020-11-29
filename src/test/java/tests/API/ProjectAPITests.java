package test.java.tests.API;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import test.java.utils.PropertyLoader;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static io.restassured.RestAssured.given;

@Epic("API")
@Feature("Projects")
public class ProjectAPITests {
    private final String API_TOKEN = "94e6f8475e6ad71752b378111e59b2c1105fc4da";
    private final String API_PATH = "/projects";
    private long generatedId;

    @Story("Get by ID")
    @Test
    public void getProjectById(){
        given()
            .header("Authorization", "Bearer " + API_TOKEN)
        .when()
            .get(PropertyLoader.loadProperty("api.url") + API_PATH + "/2251274652")
        .then()
            .statusCode(200)
            .assertThat()
            .body(matchesJsonSchemaInClasspath("getProjectByIdSchema.json"));
//            .extract()
//            .path("id");
    }

    @Story("Create project")
    @Test
    public void createProject(){
        String body = "{" +
                "    \"id\": 1234," +
                "    \"name\": \"Movies to watch\"," +
                "    \"comment_count\": 0," +
                "    \"color\": 47," +
                "    \"shared\": false," +
                "    \"sync_id\": 0," +
                "    \"order\": 1," +
                "    \"favorite\": true" +
                "}";

        generatedId = given()
                .header("Authorization", "Bearer " + API_TOKEN)
                .header("Content-Type", "application/json")
                .header("X-Request-Id", "123123-123123-1231233")
                .body(body)
        .when()
                .post(PropertyLoader.loadProperty("api.url") + API_PATH)
        .then()
                .statusCode(200)
                .extract()
                .path("id")
        ;
    }

    @Story("Delete project")
    @Test(dependsOnMethods = "createProject")
    public void deleteProjectById(){
        given()
                .header("Authorization", "Bearer " + API_TOKEN)
        .when()
                .delete(PropertyLoader.loadProperty("api.url") + API_PATH + "/" + generatedId)
        .then()
                .statusCode(204)
        ;
    }

}
