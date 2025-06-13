package APIClass;

import dataObject.TodoitemObject;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutMethod {
    @Test
    public void testPutToDoApi()
    {
        TodoitemObject toDoItemObject = new TodoitemObject();
        toDoItemObject.setTitle("Update Method");

        given()
                .headers("x-challenger", "e38e5193-0150-40ae-ba2c-81d2d8e7fa26")
                .contentType(ContentType.JSON)
                .body(toDoItemObject)
                .when()
                .put("https://apichallenges.eviltester.com/todos/9")
                .then()
                .log().body();
    }

}
