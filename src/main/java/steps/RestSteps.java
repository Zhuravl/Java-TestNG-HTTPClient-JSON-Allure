package steps;

import clients.RestClient;
import entities.RestApiRequest;
import entities.RestApiResponse;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Class contains steps for REST API
 */
public class RestSteps extends BaseSteps {

    @Step("Execute REST request")
    public static RestApiResponse callCityAltSpellings(String city) {
        RestApiRequest restApiRequest = new RestApiRequest();
        restApiRequest.setCity(city);

        log.info("Call to city: '" + city + "'..");
        RestApiResponse result = RestClient.get(restApiRequest);
        log.info("Result is: '" + result + "'");
        return result;
    }
}
