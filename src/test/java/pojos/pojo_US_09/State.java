package pojos.pojo_US_09;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class State {
    /*
     "cstate": {
                "id": 1251,
                "name": "antep",
                "country": {
                    "id": 1201,
                    "name": "Türkye"
                }
     */
    private int id;
    private String name;
    private Country2 country;
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
    public Country2 getCountry() {
        return country;
    }
    public void setCountry(Country2 country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
