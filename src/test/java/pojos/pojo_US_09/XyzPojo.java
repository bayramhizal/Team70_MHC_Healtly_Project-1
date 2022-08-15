package pojos.pojo_US_09;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class XyzPojo {

    /*
    1- Tum keyler icin private variable lar olusturuyoruz
    2- Tum parametrelerle ve parametresiz constructor larimizi olusturuyoruz
    3- Getter ve setter olusturuyoruz
    4- toString methodunu olusturuyoruz
    */
    private String name;
    private String surname;

}
