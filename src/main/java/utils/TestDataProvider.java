package utils;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;

/**
 * Class contains providers for tests data
 */
public class TestDataProvider {

    /**
     * Returns set of data for soap testing
     */
    @DataProvider
    public static Object[][] soapTestData(){
        return new Object[][]{
                {"New York", 2}
        };
    }

    /**
     * Returns set of data for rest testing
     */
    @DataProvider
    public static Object[][] restTestData(){
        ArrayList<String> spellings = new ArrayList<String>();
        spellings.add("DE");
        spellings.add("Federal Republic of Germany");
        spellings.add("Bundesrepublik Deutschland");
        return new Object[][]{
                {"Berlin", spellings}
        };
    }
}
