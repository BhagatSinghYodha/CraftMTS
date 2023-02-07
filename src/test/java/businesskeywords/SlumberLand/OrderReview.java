package businesskeywords.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import com.changeCX.framework.selenium.FrameworkDriver;
import commonkeywords.CommonActions;
import pages.SlumberLand.LoginPage;
import pages.SlumberLand.OrderReviewPage;
import supportLibraries.Utility_Functions;

public class OrderReview extends ReusableLib {
    CommonActions commonObj;
    private FrameworkDriver ownDriver;

    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public OrderReview(Helper helper) {
        super(helper);
        commonObj = new CommonActions(helper);
        ownDriver = helper.getGSDriver();
    }

    /**
     * Keyword to click [Place Order] button
     */
    public void clickPlaceOrderBtn(){
        commonObj.closeOverlays();
        Utility_Functions.xScrollElementToCentre(ownDriver, OrderReviewPage.chkbxAgreeToTerms);
        Utility_Functions.xClickHiddenElement(ownDriver, OrderReviewPage.chkbxAgreeToTerms);
        Utility_Functions.timeWait(1);
        click(OrderReviewPage.btnPlaceOrder, "Clicked on [Place Order] button");
        commonObj.validateText(OrderReviewPage.hdrThankYouForOrder, "Thank you for your order.", "Validating Order Placed confirmation.");
        Utility_Functions.xUpdateJson("OrderNo", getText(OrderReviewPage.lblOrderNumber));
    }

    /**
     * Keyword to validate [Order Placed] notification
     */
    public void vrfyOrderPlaced(){
        commonObj.validateText(OrderReviewPage.hdrThankYouForOrder, "Thank you for your order.", "Validating Order Placed confirmation.");
        Utility_Functions.xUpdateJson("OrderNo", getText(OrderReviewPage.lblOrderNumber));
    }

    /**
     * Keyword to create Account after order placed notification
     */
    public void createAccountAfterOrder(){
        String password = "TestPass@"+Utility_Functions.xRandomFunction(9999);
        commonObj.validateText(OrderReviewPage.hdrCreateAccount, "Create Account", "Validating [Create Account] section header");
        sendKeys(OrderReviewPage.tbxPassCreateAccount, password);
        sendKeys(OrderReviewPage.tbxConfPassCreateAccount, password, "Entered [Password] and [Confirm Password]");
        click(OrderReviewPage.btnCreateAccount, "Clicked on [Create Account] button");
        commonObj.verifyElementContainsText(LoginPage.hdrLoginTitle, "My Account", "Validating [Login Dashboard] page header");
    }



}
