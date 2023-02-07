package testcases.SlumberLand;

import com.changeCX.core.CoreScript;
import com.changeCX.core.TestConfigurations;
import com.changeCX.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class ProductReview extends TestConfigurations {

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0088_VerifyGuestsCanWriteProductReview(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest User should be able to add Product Review for any of the Product");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0089_VerifyGuestsCanPostAQuestionForProduct(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest User can Post a Question in Ask a Question link");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0090_VerifyRegUserCanWriteProductReview(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Registered User should be able to add Product Review for any of the Product");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0091_VerifyRegUserCanPostAQuestionForProduct(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Registered User can Post a Question in Ask a Question link");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

}
