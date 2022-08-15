package pojos.pojo_US_09;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country2 {
    /*
     "country": {
                "id": 1201,
                "name": "Türkye"
            },
     */
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
        return "Country2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
