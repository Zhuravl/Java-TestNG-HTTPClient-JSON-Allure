package entities;

/**
 * Class describes REST API request entity
 */
public class RestApiRequest {

    private String host = "https://restcountries.eu/rest/v2/capital/";
    private String city;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFullHost() {
        return host + city;
    }

    @Override
    public String toString() {
        return "RestApiRequest{" +
                "host='" + host + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
