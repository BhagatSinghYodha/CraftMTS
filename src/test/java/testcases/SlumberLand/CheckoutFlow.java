package testcases.SlumberLand;

import com.changeCX.core.CoreScript;
import com.changeCX.core.TestConfigurations;
import com.changeCX.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class CheckoutFlow extends TestConfigurations {

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0019_VerifyGuestCheckoutWithDeliverAddressUsingDiscoverCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest Checkout with Delivery Address using Discover Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0069_VerifyGuestCheckoutWithPickUpInStoreUsingDiscoverCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest Checkout with Pick-up in Store using Discover Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0057_VerifyGuestCheckoutWithDeliverAddressUsingAmexCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest Checkout with Delivery Address using Amex Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0071_VerifyGuestCheckoutWithPickUpInStoreUsingAmexCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest Checkout with Pick-up in Store using Amex Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0058_VerifyGuestCheckoutWithDeliverAddressUsingMasterCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest Checkout with Delivery Address using Master Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0072_VerifyGuestCheckoutWithPickUpInStoreUsingMasterCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest Checkout with Pick-up in Store using Master Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0059_VerifyGuestCheckoutWithDeliverAddressUsingVisaCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest Checkout with Delivery Address using Visa Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0070_VerifyGuestCheckoutWithPickUpInStoreUsingVisaCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest Checkout with Pick-up in Store using Visa Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0046_VerifyGuestCheckoutWithDeliverAddressUsingAffirmPayment(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest Checkout with Delivery Address using Affirm Payment mode");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0067_VerifyGuestCheckoutWithPickUpInStoreUsingAffirmPayment(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest Checkout with Pick-up in Store using Affirm Payment mode");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0047_VerifyGuestCheckoutWithDeliverAddressUsingPaypal(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest Checkout with Delivery Address using Paypal Payment mode");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0068_VerifyGuestCheckoutWithPickUpInStoreUsingPaypal(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Guest Checkout with Pick-up in Store using Paypal Payment mode");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_CreateAccount(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to Create Account");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0063_VerifyCheckoutFlowWithDeliverAddressUsingDiscoverCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Checkout flow with Delivery Address using Discover Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0077_VerifyCheckoutFlowWithPickUpInStoreUsingDiscoverCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Checkout flow with Pick-up in Store using Discover Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0062_VerifyCheckoutFlowWithDeliverAddressUsingAmexCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Checkout flow with Delivery Address using Amex Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0064_VerifyCheckoutFlowWithDeliverAddressUsingMasterCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Checkout flow with Delivery Address using Master Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0061_VerifyCheckoutFlowWithDeliverAddressUsingVisaCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Checkout flow with Delivery Address using Visa Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0066_VerifyCheckoutFlowWithDeliverAddressUsingAffirmPayment(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Checkout flow with Delivery Address using Affirm Payment mode");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0065_VerifyCheckoutFlowWithDeliverAddressUsingPaypal(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Checkout flow with Delivery Address using PayPal Payment mode");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0078_VerifyCheckoutFlowWithPickUpInStoreUsingAmexCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Checkout flow with Pick-up in Store using Amex Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0076_VerifyCheckoutFlowWithPickUpInStoreUsingMasterCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Checkout flow with Pick-up in Store using Master Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0075_VerifyCheckoutFlowWithPickUpInStoreUsingVisaCreditCard(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Checkout flow with Pick-up in Store using Visa Credit Card");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0073_VerifyCheckoutFlowWithPickUpInStoreUsingAffirmPayment(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Checkout flow with Pick-up in Store using Affirm payment mode");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0074_VerifyCheckoutFlowWithPickUpInStoreUsingPaypal(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Checkout flow with Pick-up in Store using PayPal payment");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }


}
