package entities;

import java.util.ArrayList;

/**
 * Class describes REST API response entity
 */
public class RestApiResponse {

    private ArrayList altSpellings;

    public ArrayList getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(ArrayList altSpellings) {
        this.altSpellings = altSpellings;
    }

    @Override
    public String toString() {
        return "RestApiResponse{" +
                "altSpellings=" + altSpellings +
                '}';
    }
}
