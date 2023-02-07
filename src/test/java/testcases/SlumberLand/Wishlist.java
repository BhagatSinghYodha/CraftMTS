package testcases.SlumberLand;

import com.changeCX.core.CoreScript;
import com.changeCX.core.TestConfigurations;
import com.changeCX.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class Wishlist extends TestConfigurations {

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0085_VerifyAddingProductToWishlist(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify User can add a Product to Wish List section");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0086_VerifyDeletingProductFromWishlist(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify User can remove a Product from Wish List section");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void TC_0087_VerifyAddProductToCartFromWishlist(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test to verify User is able to add any Product to Cart from Wishlist section");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }




}
