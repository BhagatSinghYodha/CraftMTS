package testcases.SlumberLand;

import com.changeCX.core.CoreScript;
import com.changeCX.core.TestConfigurations;
import com.changeCX.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class MyAccount extends TestConfigurations {

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_0002_VerifyCreateAccount(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Create Account functionality");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0051_VerifyUIOfCreateAccountPage(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify UI of Create Account page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0056_VerifyUIOfLoginPage(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify UI of My Account Login page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0003_VerifyLogin(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify user is able to login as a registered user");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0082_VerifyCreateAccountAfterOrderProcessingAsGuest(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Create Account after Order Processing as Guest User");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0052_VerifyRequiredFieldMsgInCreateAccountPage(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Required Field Message in Create Account Page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0055_VerifyAcceptablePwdPolicyInCreateAccountPage(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify Acceptable Password Policy in Create Account Page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0092_VerifyUpdatePasswordFunctionality(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify User can update the Password from Personal Data under My Account section");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0093_VerifyUpdateAccountEmailFunctionality(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify User can update the Email ID from Personal Data under My Account section");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }


}
