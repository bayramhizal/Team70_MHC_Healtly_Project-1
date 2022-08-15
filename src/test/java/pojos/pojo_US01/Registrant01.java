package pojos.pojo_US01;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Registrant01 {

    /*
    {
  "activated": true,
  "authorities": [
    "string"
  ],
  "createdBy": "string",
  "createdDate": "2022-03-06T16:16:26.333Z",
  "email": "string",
  "firstName": "string",
  "id": 0,
  "imageUrl": "string",
  "langKey": "string",
  "lastModifiedBy": "string",
  "lastModifiedDate": "2022-03-06T16:16:26.333Z",
  "lastName": "string",
  "login": "string",
  "password": "string",
  "ssn": "string"
}
     */


    private String firstName;
    private String lastName;
    private String ssn;
    private String login;
    private String langKey;
    private String password;
    private String email;
    private int id;
    private boolean activated;
    private String [] authorities;
    private String imageUrl;
    private String createdBy;
    private String createdDate;
    private String lastModifiedBy;
    private String lastModifiedDate;

}

// @NoArgsConstructor   --- lombok dependincies sayesinde... parametresiz cons. kendi olusturuyor ben yazmıyorum
// @AllArgsConstructor  --- lombok dependincies sayesinde... tüm parametrelerle cons. kendi olusturuyor ben yazmıyorum
// @Data                --- lombok dependincies sayesinde... data ile set ve get