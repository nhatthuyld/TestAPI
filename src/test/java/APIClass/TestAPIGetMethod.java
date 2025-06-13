package APIClass;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestAPIGetMethod {

    @Test
    public void testGetChallengeAPI()
    {
        given()
                .when()
                .get("https://apichallenges.eviltester.com/challenges")
                .then()
                .statusCode(200)
                .body("challenges[0].'name'",equalTo("POST /challenger (201)"))
                .log().body();
    }

    @Test
    public void testGetTOdoPathAPI()
    {
        given()
                .queryParam("title","file paperwork")
                .when()
                .get("https://apichallenges.eviltester.com/todos")
                .then()
                .statusCode(200)
                .log().body();
    }


}
