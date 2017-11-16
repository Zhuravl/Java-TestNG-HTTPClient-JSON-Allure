package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import steps.RestSteps;
import utils.TestDataProvider;

import java.util.ArrayList;

/**
 * Class contains tests for REST API
 */
public class RestTest {

    @Test(dataProvider = "restTestData", dataProviderClass = TestDataProvider.class)
    @Features("API tests")
    @Stories("REST API")
    @Title("Check altSpellings")
    public void altSpellingsTest(String city, ArrayList expectedResult) throws InterruptedException {
        Assert.assertEquals(
                RestSteps.callCityAltSpellings(city).getAltSpellings(),
                expectedResult,
                "Check that actual and expected lists with 'altSpellings' are equals"
        );
    }
}
