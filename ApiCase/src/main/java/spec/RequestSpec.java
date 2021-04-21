package spec;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    RequestSpecification requestSpecification;
    String token ="BQCvPBDNycEXPhHSzUrsIgqCLOhdngD4hba9eJQQ5iIaeEEUqNpSyJFozp0Qzt9a0pjosB5o1v9Dy0bhmfEJ0BQqM7VXX8njTOOa7YNldImQVTJEWzjFdW-ABQMGWHVKkaUfbMawxHI1jW6ZM1GyJZ1TkoVbbou_G2l7AQFUyUx0C759gR9PogNVreqwZDKAJ7-81Z-HQgPSWccgooTfV7Fd65g_GQ6SE3Ods-74a9Mbdffuoiw47-xf5UHhDsdFqlu498Oul6pgj6b_zK08vzxowjVYGrq5y044hJeo";
    String baseUrl = "https://api.spotify.com/v1";

    public RequestSpec(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setAccept("application/json")
                .setContentType("application/json")
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
