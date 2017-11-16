package clients;

import entities.TablesList;
import helpers.DataHelper;
import net.webservicex.GetInfoByCityResponse;
import net.webservicex.USZip;
import net.webservicex.USZipSoap;

/**
 * Class contains client for SOAP methods
 */
public class SoapClient extends BaseClient {

    public static TablesList getInfoByCity(String city) {
        TablesList result;
        USZip usZip = new USZip();
        USZipSoap usZipSoap = usZip.getUSZipSoap();
        log.info("Get InfoByCity SOAP request for city: '" + city + "'..");
        GetInfoByCityResponse.GetInfoByCityResult response = usZipSoap.getInfoByCity(city);
        result = DataHelper.parse(response);
        log.info("Response: \n" + result);
        return result;
    }
}
