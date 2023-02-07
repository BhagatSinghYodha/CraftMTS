package pages.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import org.openqa.selenium.By;

public class BillingPage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public BillingPage(Helper helper) {
        super(helper);
    }

    public static By hdrPaymentAndBilling=By.xpath("//legend[text()='Payment & Billing']");
    public static By tbxNameOnCard=By.xpath("//input[contains(@id,'paymentMethods_creditCard_owner')]");
    public static By tbxCardNumber=By.xpath("//input[contains(@id,'paymentMethods_creditCard_number')]");
    public static By ddnExpirationMonth=By.xpath("//select[contains(@id,'paymentMethods_creditCard_expiration_month')]");
    public static By ddnExpirationYear=By.xpath("//select[contains(@id,'paymentMethods_creditCard_expiration_year')]");
    public static By tbxSecurityCode=By.xpath("//input[contains(@id,'paymentMethods_creditCard_cvn')]");
    public static By btnReviewOrder=By.xpath("//button[contains(@class,'experian-submit-btn') and text()='Review Order']");
    public static By btnBillingSubmit=By.xpath("//button[@id='billingSubmitButton']");

    /********************************** Select Payment Method locators **********************************/

    public static By lblSelectPaymentMethod=By.xpath("//legend[contains(text(),'Select Payment Method')]");
    public static By rbCreditCard=By.xpath("//input[@id='is-CREDIT_CARD']");
    public static By lblCardInformation=By.xpath("//legend[contains(text(),'Card Information')]");
    public static By rbAffirmPayment=By.xpath("//input[@id='is-Affirm']");
    public static By rbPaypalPayment=By.xpath("//input[@id='is-PayPal']");


    /********************************** Affirm Payment mode locators **********************************/

    public static By lblAffirmMsg=By.xpath("//div[@class='affirm-msg']/p");
    public static By hdrAffirmContainer=By.xpath("//h2[text()='Pay your way—you pick the plan you like best.']");
    public static By progressBar=By.xpath("//div[@role='progressbar']");
    public static By tbxMobileNumber=By.xpath("//input[@aria-label='Mobile number *']");
    public static By btnContinue=By.xpath("//button[@aria-label='Continue']");
    public static By hdrVerificationCodePopup=By.xpath("//h1[text()='We just texted you']");
    public static By tbxEnterPin=By.xpath("//input[@aria-label='PIN']");
    public static By hdrAffirmApproved=By.xpath("//h1[contains(text(),'approved!')]");
    public static By hdrChoosePlan=By.xpath("//h1[text()='Choose the best plan for you']");
    public static By divAffirmTermCard=By.xpath("//span[contains(text(),'3 months')]/../../..");
    public static By hdrAffirmReviewPaymentPlan=By.xpath("//h1[text()='Review your payment plan']");
    public static By chkbxAffirmDisclosure=By.xpath("//div[@data-testid='disclosure-checkbox-indicator']");
    //public static By btnContinue=By.xpath("//button[text()='Continue']");
    public static By btnConfirm=By.xpath("//button[text()='Confirm']");
    public static By hdrAffirmPurchaseComplete=By.xpath("//h1[contains(text(),'Your purchase is complete')]");

    /********************************** PayPal Payment mode locators **********************************/

    public static By btnLogIn=By.xpath("//button[text()='Log In']");
    public static By tbxEmail=By.id("email");
    public static By tbxPassword=By.id("password");
    public static By btnLogin=By.id("btnLogin");
    public static By btnPayPalProfile=By.id("button-profile");
    public static By btnContinueToReviewOrder=By.id("payment-submit-btn");

}

