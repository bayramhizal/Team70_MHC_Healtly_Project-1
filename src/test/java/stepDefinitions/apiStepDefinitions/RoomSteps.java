package stepDefinitions.apiStepDefinitions;

import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import pojos.pojo_US_09.Room1;
import pojos.pojo_US_09.Room1Post;
import utilities.ConfigReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;

public class RoomSteps {

    Response response;
    Room1Post room1Post = new Room1Post();
    Room1 roomPut = new Room1();
    Room1 [] rooms ;
    @Given("kullanici roomlar icin get request yapar")
    public void kullanici_roomlar_icin_get_request_yapar() {
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken("DzKKaya","Sword1234."),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().get(ConfigReader.getProperty("room_endpoint"));
    }
    @Given("kullanici gelen room datayi deserialize eder")
    public void kullanici_gelen_room_datayi_deserialize_eder() throws Exception{
        ObjectMapper obj = new ObjectMapper();
        rooms = obj.readValue(response.asString(), Room1[].class);
        System.out.println("kac tane room obejesi var? " +rooms.length);
        for(int i=0; i < rooms.length; i++){
            System.out.println(rooms[i].getDescription());
            System.out.println(rooms[i].getRoomNumber());
        }
    }
    @Then("kullanici room datasini validate eder")
    public void kullanici_room_datasini_validate_eder() {
    }
    @Given("kullanici roomlar icin put request yapar")
    public void kullanici_roomlar_icin_put_request_yapar() {
        roomPut.setId(180673);
        roomPut.setRoomType("DELUXE");
        roomPut.setRoomNumber(73465673);
        roomPut.setDescription("Techproed innovation3");
        roomPut.setStatus(true);
        roomPut.setPrice(1001);
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken("DzKKaya","Sword1234."),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).body(roomPut).contentType(ContentType.JSON).when().put(ConfigReader.getProperty("room_endpoint"));
    }
    @Given("kullanici roomlar icin post request yapar")
    public void kullanici_roomlar_icin_post_request_yapar() {
        //Set the expected data / istenilen datayi ekle
        room1Post.setRoomType("TWIN");
        room1Post.setPrice(700);
        room1Post.setRoomNumber(34736);
        room1Post.setStatus(true);
        room1Post.setDescription("Techproed TWIN Room 2");
       // response = postRequest(ConfigReader.getProperty("room_post"),room1Post );
    }
    @Then("kullanici post request validation yapar")
    public void kullanici_post_request_validation_yapar() throws Exception {
        //1. validation
        response.then().assertThat().statusCode(200);
        response.then().assertThat().
                body("price", equalTo(700)).
                body("roomNumber",equalTo(34736) )
                .body("roomType",equalTo("TWIN"));
        //2. validation
        JsonPath json = response.jsonPath();
        assertEquals(room1Post.getRoomType(), json.getString("roomType"));
      //  assertEquals(room1Post.getRoomNumber(), json.getInt("roomNumber"));
       // assertEquals(room1Post.getPrice(), json.getInt("price"));

        //3. validation
        Map<String , Object> actualMapData = response.as(HashMap.class);
        assertEquals(room1Post.getPrice(), actualMapData.get("price"));
        assertEquals(room1Post.getRoomType(), actualMapData.get("roomType"));
        assertEquals(room1Post.getRoomNumber(), actualMapData.get("roomNumber"));

        //4. validation
        Room1 room1ActualData = response.as(Room1.class);
        assertEquals(room1Post.getRoomNumber(), room1ActualData.getRoomNumber());
        assertEquals(room1Post.getRoomType(),room1ActualData.getRoomType());
        assertEquals(room1Post.getPrice(),room1ActualData.getPrice());

        //5. validation
        ObjectMapper obj = new ObjectMapper();
        Room1 room2ActualData = obj.readValue(response.asString(),Room1.class );
        assertEquals(room1Post.getPrice(), room2ActualData.getPrice());
        assertEquals(room1Post.getDescription(), room2ActualData.getDescription());
        assertEquals(room1Post.getRoomNumber(), room2ActualData.getRoomNumber());

        //6. validation
        Gson gson = new Gson();
        Room1 room3ActualData = gson.fromJson(response.asString(),Room1.class );
        assertEquals(room1Post.getPrice(), room3ActualData.getPrice());
        assertEquals(room1Post.getDescription(), room3ActualData.getDescription());
        assertEquals(room1Post.getRoomNumber(), room3ActualData.getRoomNumber());
    }
    @Then("kullanici put request validation yapar")
    public void kullanici_put_request_validation_yapar()throws Exception {
        //1. validation
//        response.then().assertThat().statusCode(201);
        response.then().assertThat().statusCode(200);
        response.then().assertThat().
                body("price", equalTo(1000)).
                body("roomNumber",equalTo(73466237) )
                .body("roomType",equalTo("DELUXE"));
        //2. validation
        JsonPath json = response.jsonPath();
        assertEquals(roomPut.getRoomType(), json.getString("roomType"));
      //  assertEquals(roomPut.getRoomNumber(), json.getInt("roomNumber"));
      //  assertEquals(roomPut.getPrice(), json.getInt("price"));
        //3. validation
        Map<String , Object> actualMapData = response.as(HashMap.class);
        assertEquals(roomPut.getPrice(), actualMapData.get("price"));
        assertEquals(roomPut.getRoomType(), actualMapData.get("roomType"));
        assertEquals(roomPut.getRoomNumber(), actualMapData.get("roomNumber"));
        //4. validation
        Room1 room1ActualData = response.as(Room1.class);
        assertEquals(roomPut.getRoomNumber(), room1ActualData.getRoomNumber());
        assertEquals(roomPut.getRoomType(),room1ActualData.getRoomType());
        assertEquals(roomPut.getPrice(),room1ActualData.getPrice());
        //5. validation
        ObjectMapper obj = new ObjectMapper();
        Room1 room2ActualData = obj.readValue(response.asString(),Room1.class );
        assertEquals(roomPut.getPrice(), room2ActualData.getPrice());
        assertEquals(roomPut.getDescription(), room2ActualData.getDescription());
        assertEquals(roomPut.getRoomNumber(), room2ActualData.getRoomNumber());
        //6. validation
        Gson gson = new Gson();
        Room1 room3ActualData = gson.fromJson(response.asString(),Room1.class );
        assertEquals(roomPut.getPrice(), room3ActualData.getPrice());
        assertEquals(roomPut.getDescription(), room3ActualData.getDescription());
        assertEquals(roomPut.getRoomNumber(), room3ActualData.getRoomNumber());
    }
    @Given("kullanici Delete request eder {string}")
    public void kullanici_delete_request_eder(String id) {
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken("DzKKaya","Sword1234."),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().delete("https://medunna.com/api/rooms"+"/"+id);
    }
    @Then("delete validation")
    public void delete_validation() {
        response.then().assertThat().statusCode(204);
    }
}

