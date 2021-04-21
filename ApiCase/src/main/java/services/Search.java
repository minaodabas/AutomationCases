package services;
import io.restassured.RestAssured;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import spec.RequestSpec;
import java.util.List;

public class Search extends RequestSpec {


    public String searchASong(String song,String type,String market){
        Response response = RestAssured.given()
                .spec(getRequestSpecification())
                .queryParam("q",song)
                .queryParam("type",type)
                .queryParam("market",market)
                .when()
                .get("/search")
                .then()
                .statusCode(200)
                .extract().response();

        List<String> uri = ((RestAssuredResponseImpl) response).response().path("tracks.items.uri");
        System.out.println(uri);
        return uri.get(0);
    }
}
