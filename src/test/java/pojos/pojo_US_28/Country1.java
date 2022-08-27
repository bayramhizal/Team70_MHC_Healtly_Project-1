package pojos.pojo_US_28;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import utilities.Authentication;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country1 {

  private int id;
  private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}