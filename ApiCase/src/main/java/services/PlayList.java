package services;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import spec.RequestSpec;
import java.util.List;

public class PlayList extends RequestSpec {
    public String createPlayList(String id){
        String body = "{\n" +
                "  \"name\": \"New Playlist\",\n" +
                "  \"description\": \"New playlist description\",\n" +
                "  \"public\": false\n" +
                "}";
        Response response = RestAssured.given()
                .spec(getRequestSpecification())
                .body(body)
                .when()
                .post("/users/{user_id}/playlists",id)
                .then()
                .statusCode(201)
                .extract().response();

        String playListId = response.getBody().jsonPath().getString("id");
        System.out.println(playListId);
        return playListId;


    }

    public boolean checkPlayListIsNull(String id){
        Response response = RestAssured.given()
               .spec(getRequestSpecification())
                .when()
                .get("/playlists/{playlist_id}/tracks",id)
                .then()
                .statusCode(200)
                .extract().response();
        List<Object> list = response.jsonPath().getList("items");
        System.out.println(list.size());
        if (list.size() != 0) return false;
        return true;

    }

    public void addATrack(List<String> uri,String playListId){
        for(String track:uri){
            RestAssured.given()
                    .spec(getRequestSpecification())
                    .queryParam("uris",track)
                    .when()
                    .post("/playlists/{playlist_id}/tracks",playListId)
                    .then()
                    .statusCode(201)
                    .extract().response();


        }
}
}
