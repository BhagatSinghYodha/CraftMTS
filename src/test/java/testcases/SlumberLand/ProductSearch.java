package testcases.SlumberLand;

import com.changeCX.core.CoreScript;
import com.changeCX.core.TestConfigurations;
import com.changeCX.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class ProductSearch extends TestConfigurations {

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0029_VerifyProductSearchFunctionality(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Product Search functionality");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0026_VerifyNoProductsFoundMsg(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify No Products Found message for invalid search");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0083_VerifyGuestUserProdSearchByProductID(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest User can perform Product search by Product ID");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0084_VerifyRegUserProdSearchByProductID(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Registered User can perform Product search by Product ID");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }




}
