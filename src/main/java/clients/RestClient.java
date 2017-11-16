package clients;

import entities.RestApiRequest;
import entities.RestApiResponse;
import helpers.DataHelper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class contains client for REST methods
 */
public class RestClient extends BaseClient {

    public static RestApiResponse get(RestApiRequest restApiRequest) {
        String result = null;
        log.info("Get request to: '" + restApiRequest.getFullHost() + "'..");
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(restApiRequest.getFullHost());
            HttpResponse response = client.execute(request);

            BufferedReader rd = new BufferedReader
                    (new InputStreamReader(
                            response.getEntity().getContent()));

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuilder.append(line);
            }
            result = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Response: \n" + result);
        return DataHelper.parse(result);
    }
}
