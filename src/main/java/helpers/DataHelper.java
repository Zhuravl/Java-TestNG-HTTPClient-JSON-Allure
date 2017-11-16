package helpers;

import constants.Constants;
import entities.RestApiResponse;
import entities.Table;
import entities.TablesList;
import net.webservicex.GetInfoByCityResponse;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.CommonLogger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class contains help methods for REST API
 */
public class DataHelper {

    private static Logger log = CommonLogger.getLogger();

    /**
     * Parses json string to REST API response object
     * @param jsonString String to parse
     */
    public static RestApiResponse parse(String jsonString) {
        RestApiResponse restApiResponse = new RestApiResponse();

        log.info("Parse json to RestApiResponse..");
        JSONArray jsonArray = new JSONArray(jsonString);
        if (jsonArray.length() == 1) {
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            JSONArray array = jsonObject.getJSONArray(Constants.ALT_SPELLINGS_ARRAY_NAME);

            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < array.length(); i++) {
                list.add(array.get(i).toString());
            }
            restApiResponse.setAltSpellings(list);
        } else {
            throw new IllegalArgumentException("Response array contains more then one object!");
        }

        log.info("Parsing has been completed successful!");
        return restApiResponse;
    }

    /**
     * Parses SOAP class GetInfoByCityResult to TablesList class
     * @param getInfoByCityResult Instance to parse
     */
    public static TablesList parse(GetInfoByCityResponse.GetInfoByCityResult getInfoByCityResult) {
        TablesList tablesList = null;
        log.info("Parse GetInfoByCityResult to TablesList..");
        try {
            Object content = ((List) getInfoByCityResult.getContent()).get(0);
            JAXBContext jaxbContext = null;
            jaxbContext = JAXBContext.newInstance(TablesList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            tablesList = (TablesList) jaxbUnmarshaller.unmarshal((org.w3c.dom.Node) content);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        log.info("Parsing has been completed successful!");
        return tablesList;
    }

    /**
     * Gets unique ZIP codes from list of Tables
     * @param list List with all Tables
     * @return Set with unique ZIP codes
     */
    public static Set<Integer> getUniqueZipCodesList(List<Table> list) {
        Set<Integer> resultSet = new HashSet<>();
        log.info("Get unique ZIP codes..");
        for (Table table: list) {
            if (!resultSet.contains(table.getZip())) {
                resultSet.add(table.getZip());
            }
        }
        log.info("Result is: " + resultSet);
        return resultSet;
    }
}
