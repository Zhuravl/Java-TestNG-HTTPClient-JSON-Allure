package tests;

import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import steps.SoapSteps;
import utils.TestDataProvider;

/**
 * Class contains tests for SOAP API
 */
public class SoapTest {

    @Test(dataProvider = "soapTestData", dataProviderClass = TestDataProvider.class)
    @Features("API tests")
    @Stories("SOAP API")
    @Title("Number of ZIP codes")
    public void calculateZipCodesTest(String city, int expectedResult) throws InterruptedException {
        Assert.assertTrue(
                DataHelper.getUniqueZipCodesList(SoapSteps.callCityInfo(city)).size() > expectedResult,
                "Check that number of ZIP codes is greater then " + expectedResult);
    }
}
