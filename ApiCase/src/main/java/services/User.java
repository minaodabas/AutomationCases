package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import spec.RequestSpec;

public class User extends RequestSpec {

    public String getUserId(){
        Response response = RestAssured.given()
                .spec(getRequestSpecification())
                .when()
                .get("/me")
                .then()
                .statusCode(200)
                .extract().response();

        String userId = response.getBody().jsonPath().getString("id");
        System.out.println(userId);
        return userId;

    }
}
