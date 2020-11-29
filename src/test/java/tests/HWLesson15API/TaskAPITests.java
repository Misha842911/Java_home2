package test.java.tests.HWLesson15API;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import test.java.utils.PropertyLoader;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static io.restassured.RestAssured.given;

@Epic("API")
@Feature("Tasks")
public class TaskAPITests {
    private final String API_TOKEN = "94e6f8475e6ad71752b378111e59b2c1105fc4da";
    private final String API_PATH_PROJECTS = "/projects";
    private final String API_PATH_TASKS = "/tasks";
    private long taskID = 4373864713l;
    private long taskIDToDelete = 4373883665l;

    @Story("Get all tasks")
    @Test
    public void getAllTasks(){
        given()
            .header("Authorization", "Bearer " + API_TOKEN)
        .when()
            .get(PropertyLoader.loadProperty("api.url") + API_PATH_TASKS)
        .then()
            .statusCode(200)
            .assertThat()
            .body(matchesJsonSchemaInClasspath("getTasksByIdSchema.json"));
    }

    @Story("Get task by ID")
    @Test
    public void getTask(){
        given()
            .header("Authorization", "Bearer " + API_TOKEN)
        .when()
            .get(PropertyLoader.loadProperty("api.url") + API_PATH_TASKS + "/" + taskID)
        .then()
            .statusCode(200)
            .assertThat()
            .body(matchesJsonSchemaInClasspath("getTaskByIdSchema.json"));
    }


    @Story("Delete task by ID")
    @Test(dependsOnMethods = "getAllTasks")
    public void deleteTaskById(){
        given()
            .header("Authorization", "Bearer " + API_TOKEN)
        .when()
            .delete(PropertyLoader.loadProperty("api.url") + API_PATH_TASKS + "/" + taskIDToDelete)
        .then()
            .statusCode(204)
        ;
    }
}
