package businesskeywords.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import com.changeCX.framework.Status;
import com.changeCX.framework.selenium.FrameworkDriver;
import commonkeywords.CommonActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.SlumberLand.BillingPage;
import pages.SlumberLand.DeliveryPage;
import pages.SlumberLand.OrderReviewPage;
import supportLibraries.Utility_Functions;

import java.util.List;

public class Billing extends ReusableLib {
    CommonActions commonObj;
    private FrameworkDriver ownDriver;

    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public Billing(Helper helper) {
        super(helper);
        commonObj = new CommonActions(helper);
        ownDriver = helper.getGSDriver();
    }

    /**
     * Keyword to select [Payment Method] radio button
     */
    public void selectPaymentMethod(){
        String paymentMode = jsonData.getData("PaymentMode").toLowerCase();
        switch (paymentMode){
            case "creditcard":
                selectCreditCardRadioBtn();
                break;
            case "affirm":
                selectAffirmPaymentRadioBtn();
                break;
            case "paypal":
                selectPayPalRadioBtn();
                break;
            default:
                report.updateTestLog("Select Payment Mode", "Provided incorrect Payment Mode", Status.FAIL);
        }
    }

    /**
     * Keyword to select [Credit Card] radio button
     */
    public void selectCreditCardRadioBtn(){
        waitForElementPresent(BillingPage.rbCreditCard);
        boolean isSelected = getElement(BillingPage.rbCreditCard).isSelected();
        if (!isSelected){
            Utility_Functions.xClickHiddenElement(ownDriver, BillingPage.rbCreditCard);
            report.updateTestLog("Select Credit Card payment", "Selected [Credit Card] payment mode radio-button", Status.PASS);
        }
        else
            report.updateTestLog("Select Credit Card", "Credit Card radio-button selected by default", Status.PASS);
        commonObj.verifyElementContainsText(BillingPage.lblCardInformation, "Card Information", "Validating [Card Information] section-header");
    }

    /**
     * Keyword to enter Credit Card information
     */
    public void enterCardInformation(){
        String name = jsonData.getData("Name");
        String cardNumber = jsonData.getData("CardNumber");
        String expiryMonth = jsonData.getData("ExpiryMonth");
        String expiryYear = jsonData.getData("ExpiryYear");
        String security = jsonData.getData("Security");

        sendKeys(BillingPage.tbxNameOnCard, name);
        Utility_Functions.xSendKeysAction(ownDriver, BillingPage.tbxCardNumber, cardNumber);
        Utility_Functions.xSelectDropdownByName(ownDriver, BillingPage.ddnExpirationMonth, expiryMonth);
        Utility_Functions.xSelectDropdownByName(ownDriver, BillingPage.ddnExpirationYear, expiryYear);
        sendKeys(BillingPage.tbxSecurityCode, security, "Entered Credit Card Details");
        Utility_Functions.timeWait(1);
    }

    /**
     * Keyword to click [Review Order] button
     */
    public void clickReviewOrderBtn(){
        Utility_Functions.xScrollElementToCentre(ownDriver, BillingPage.btnReviewOrder);
        click(BillingPage.btnReviewOrder, "Clicked on [Review Order] button");
        waitForElementClickable(OrderReviewPage.btnPlaceOrder, globalWait);
    }

    /**
     * Keyword to click [Review Order] button
     */
    public void clickReviewOrder(){
        Utility_Functions.xScrollIntoViewClck(ownDriver, BillingPage.btnReviewOrder);
        report.updateTestLog("Click Review Order button", "Clicked on [Review Order] button", Status.PASS);
        Utility_Functions.timeWait(5);
    }

    /**
     * Keyword to click [Continue to Place Order] button
     */
    public void submitBilling(){
        Utility_Functions.xScrollIntoViewClck(ownDriver, BillingPage.btnBillingSubmit);
        report.updateTestLog("Click Review Order button", "Clicked on [Review Order] button", Status.PASS);
        Utility_Functions.timeWait(5);
    }

    /**
     * Keyword to select [Affirm] radio-button as Payment Mode
     */
    public void selectAffirmPaymentRadioBtn(){
        String affirmMsgExpected = "You will be redirected to Affirm to securely complete your purchase. " +
                "Just fill out a few pieces of basic information and get a real-time decision. Checking your eligibility won't affect your credit score.";
        waitForElementPresent(BillingPage.rbAffirmPayment);
        boolean isSelected = getElement(BillingPage.rbAffirmPayment).isSelected();
        if (!isSelected){
            Utility_Functions.xClickHiddenElement(ownDriver, BillingPage.rbAffirmPayment);
            report.updateTestLog("Select Affirm payment mode", "Affirm payment mode selected", Status.PASS);
        }
        else
            report.updateTestLog("Select Affirm payment mode", "Affirm payment mode radio-button selected by default", Status.PASS);
        commonObj.verifyElementContainsText(BillingPage.lblAffirmMsg, affirmMsgExpected, "Validating [Affirm Message] notification");
    }

    /**
     * Keyword to perform Affirm payment
     */
    public void paymentByAffirm(){
        String mobile = jsonData.getData("Mobile");
        boolean flag = true;
        try{
            Utility_Functions.xSwitchToWindow(ownDriver, report, 1);
            Utility_Functions.timeWait(5);
            sendKeys(BillingPage.tbxMobileNumber, mobile, "Entered [Mobile Number] in Affirm payment console");
        }catch (Exception ex){
            Utility_Functions.xSwitchToParentWin(ownDriver);
            Utility_Functions.timeWait(5);
            Utility_Functions.xswitchToFrameById(ownDriver, "checkout-application");
            Utility_Functions.timeWait(5);
            sendKeys(BillingPage.tbxMobileNumber, mobile, "Entered [Mobile Number] in Affirm payment console");
            flag = false;
        }
        click(BillingPage.btnContinue, "Clicked [Continue] button");
        commonObj.verifyElementContainsText(BillingPage.hdrVerificationCodePopup, "We just texted you", "Validating [We just texted you] header");
        sendKeys(BillingPage.tbxEnterPin, "1234", "Entered [Verification Code] in Affirm payment console");
        commonObj.validateText(BillingPage.hdrChoosePlan, "Choose the best plan for you", "Validating [Choose the best plan for you] header");
        click(BillingPage.divAffirmTermCard, "Selected [3 months] plan");
        click(BillingPage.btnContinue, "Checked [Continue] button");
        commonObj.verifyElementContainsText(BillingPage.hdrAffirmReviewPaymentPlan, "Review your payment plan", "Validating [Review your payment plan] header");
        click(BillingPage.chkbxAffirmDisclosure, "Checked Affirm disclosure checkbox");
        click(BillingPage.btnConfirm, "Checked [Confirm] button");
        commonObj.verifyElementContainsText(BillingPage.hdrAffirmPurchaseComplete, "Your purchase is complete", "Validating [Your purchase is complete] header");

        if (flag){
            Utility_Functions.xSwitchToParentWin(ownDriver);
            Utility_Functions.timeWait(5);
        }else {
            Utility_Functions.xswitchToDfultFrame(ownDriver);
            Utility_Functions.timeWait(5);
        }
    }

    /**
     * Keyword to select [PayPal] radio button
     */
    public void selectPayPalRadioBtn(){
        waitForElementPresent(BillingPage.rbPaypalPayment);
        boolean isSelected = getElement(BillingPage.rbPaypalPayment).isSelected();
        if (!isSelected){
            Utility_Functions.xClickHiddenElement(ownDriver, BillingPage.rbPaypalPayment);
            report.updateTestLog("Select PayPal payment", "Selected [PayPal] payment mode radio-button", Status.PASS);
        }
        else
            report.updateTestLog("Select PayPal payment", "PayPal radio-button selected by default", Status.PASS);
        Utility_Functions.timeWait(2);
    }

    /**
     * Keyword to perform PayPal payment
     */
    public void paymentByPayPal(){
        String paypalEmail = jsonData.getData("PayPalEmail");
        String paypalPassword = jsonData.getData("PayPalPassword");
        boolean flag = true;
        try{
            Utility_Functions.xSwitchToWindow(ownDriver, report, 1);
            Utility_Functions.timeWait(5);
            click(BillingPage.btnLogIn, "Clicked PayPal [Login] button");
        }catch (Exception ex){
            Utility_Functions.xSwitchToParentWin(ownDriver);
            Utility_Functions.timeWait(5);
            Utility_Functions.xSwitchtoFrame(ownDriver, BillingPage.btnLogIn);
            Utility_Functions.timeWait(5);
            click(BillingPage.btnLogIn, "Clicked PayPal [Login] button");
            flag = false;
        }
        sendKeys(BillingPage.tbxEmail, paypalEmail, "Entered [PayPal Email] in Pay with PayPal window");
        sendKeys(BillingPage.tbxPassword, paypalPassword, "Entered [PayPal Password] in Pay with PayPal window");
        click(BillingPage.btnLogin, "Clicked [Login] button in Pay with PayPal window");
        waitForElementClickable(BillingPage.btnPayPalProfile, globalWait);
        //click(BillingPage.btnContinueToReviewOrder, "Clicked [Continue to Review Order] button");
        Utility_Functions.xClickHiddenElement(ownDriver, BillingPage.btnContinueToReviewOrder);
        report.updateTestLog("Click [Continue to Review Order] button", "Click [Continue to Review Order] button",Status.PASS);

        if (flag){
            Utility_Functions.xSwitchToParentWin(ownDriver);
            Utility_Functions.timeWait(5);
        }else {
            Utility_Functions.xswitchToDfultFrame(ownDriver);
            Utility_Functions.timeWait(5);
        }
    }

    /**
     * Keyword to enter Billing Address details
     */
    public void enterBillingAddress(){
        String fName = jsonData.getData("FirstName");
        String lName = jsonData.getData("LastName");
        String address = jsonData.getData("Address");
        String mobile = jsonData.getData("Mobile");
        String city = jsonData.getData("City");
        String zip = jsonData.getData("Zip");
        String state = jsonData.getData("State");

        List<WebElement> lstFname = Utility_Functions.findElementsByXpath(ownDriver, DeliveryPage.tbxFirstName_Address);
        List<WebElement> lstLname = Utility_Functions.findElementsByXpath(ownDriver, DeliveryPage.tbxLastName_Address);
        List<WebElement> lstAddress = Utility_Functions.findElementsByXpath(ownDriver, DeliveryPage.tbxAddress1);
        List<WebElement> lstCity = Utility_Functions.findElementsByXpath(ownDriver, DeliveryPage.tbxCity);
        List<WebElement> lstZip = Utility_Functions.findElementsByXpath(ownDriver, DeliveryPage.TbxZipCode);
        List<WebElement> lstState = Utility_Functions.findElementsByXpath(ownDriver, DeliveryPage.ddnState);
        List<WebElement> lstMbile = Utility_Functions.findElementsByXpath(ownDriver, DeliveryPage.tbxMobilePhone);

        Utility_Functions.xSendKeysVisibleListElement(lstFname, fName);
        Utility_Functions.xSendKeysVisibleListElement(lstLname, lName);
        Utility_Functions.xSendKeysVisibleListElement(lstAddress, address);
        Utility_Functions.xSendKeysVisibleListElement(lstCity, city);
        Utility_Functions.xSendKeysVisibleListElement(lstZip, zip);
        Utility_Functions.xSendKeysVisibleListElement(lstMbile, mobile);
        Utility_Functions.timeWait(1);
        Utility_Functions.actionKey(Keys.TAB, ownDriver);
        for (WebElement stateElement : lstState) {
            if (stateElement.isDisplayed()) {
                Utility_Functions.xSelectDropdownByName(ownDriver, stateElement, state);
                break;
            }
        }
        Utility_Functions.timeWait(1);
    }



}
