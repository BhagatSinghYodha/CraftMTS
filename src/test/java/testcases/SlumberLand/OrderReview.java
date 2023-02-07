package testcases.SlumberLand;

import com.changeCX.core.CoreScript;
import com.changeCX.core.TestConfigurations;
import com.changeCX.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class OrderReview extends TestConfigurations {

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0079_VerifyGuestUserCanEditDeliveryAddressFromBillingPage(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify that Guest User is able to edit address from Delivery Address section in the Billing page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0080_VerifyGuestUserCanEditOrderSummarySectionFromBillingPage(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify that Guest user is able to edit orders from Order Summary section in the Billing page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0081_VerifyGuestUserCanEditYourOrderSectionFromBillingPage(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify that Guest user is able to edit orders from Your Order section in the Billing page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0020_VerifyRegUserCanEditYourOrderSectionFromBillingPage(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify that Registered User is able to edit orders from Your Order section in the Billing page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0021_VerifyRegUserCanEditOrderSummarySectionFromBillingPage(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify that Registered User is able to edit orders from Order Summary section in the Billing page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0022_VerifyRegUserCanEditDeliveryAddressFromBillingPage(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify that Registered User is able to edit address from Delivery Address section in the Billing page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }






}
