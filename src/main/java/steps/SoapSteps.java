package steps;

import clients.SoapClient;
import entities.Table;
import entities.TablesList;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Class contains steps for SOAP API
 */
public class SoapSteps extends BaseSteps {

    @Step("Execute SOAP request")
    public static List<Table> callCityInfo(String city) {
        log.info("Call to city: '" + city + "'..");
        TablesList result = SoapClient.getInfoByCity(city);
        log.info("Result is: '" + result + "'");
        return result.getTables();
    }
}
