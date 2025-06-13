package APIClass;

import dataObject.TodoitemObject;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class APIPostmethod {
    @Test
    public void testPostChallengeAPI() {
        //https://apichallenges.eviltester.com/
        //  X-Challenger: 015bb4ef-4707-45d7-8588-9eedc1dfb4ef

        given()
                .when()
                .post("https://apichallenges.eviltester.com/challenger")
                .then()
                .statusCode(201)
                .log().headers()
                .log().body();
    }


    @Test(description = "09")
    public void testPostToDoITemAPI() throws IOException {

        //create read json file
        String jsonRequest = Files.readString(Paths.get("src/test/resources/jsonRequest/todoItemResquestSchema.json"));
        given()
                .when()
                .header("X-Challenger", "8cd5b03a-38b3-403d-bd91-6d48a0747a12")
                .contentType(ContentType.JSON)
                .body(jsonRequest)//payload
                .post("https://apichallenges.eviltester.com/todos")
                .then()
                .statusCode(201)
                .log().body();

    }


    @Test
    public void testInvalidBooleanField() throws IOException {
        // 1. Đọc JSON từ file
        String jsonRequest = Files.readString(Paths.get("src/test/resources/jsonRequest/post010API.json"));

        // 2. Gửi request và trích xuất body trả về
        String errorBody = given()
                .header("X-Challenger", "4ef051d7-b162-4496-91c2-628f3f582164")
                .contentType(ContentType.JSON)
                .body(jsonRequest)
                .when()
                .post("https://apichallenges.eviltester.com/todos")
                .then()
                .body(containsString("doneStatus should be BOOLEAN"))
                .statusCode(400) // Kiểm tra lỗi 400
                .extract()
                .asString();     // Lấy nội dung trả về dưới dạng chuỗi

        // 3. Assert nội dung lỗi
       // Assert.assertTrue(errorBody.contains("doneStatus should be BOOLEAN"));
    }

    @Test
    public void testPostToDoItemWithDataObjectApi() {
        TodoitemObject toDoItemObject = new TodoitemObject("LongNguyen", false, "Test");

        given()
                .headers("X-CHALLENGER", "a4f126f3-1ed9-40f2-a952-3e20b530beb8")
                .contentType(ContentType.JSON)
                .body(toDoItemObject) // payload
                .when()
                .post("https://apichallenges.eviltester.com/todos")
                .then()
                .statusCode(201)
                .body("title", equalTo("LongNguyen"))
                .log().body();
    }


}
