package pages.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import org.openqa.selenium.By;

public class OrderReviewPage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public OrderReviewPage(Helper helper) {
        super(helper);
    }

    public static By btnPlaceOrder=By.xpath("//button[@name='placeOrder']");
    public static By chkbxAgreeToTerms=By.id("agreetoterms");
    public static By hdrThankYouForOrder=By.xpath("//h1[text()='Thank you for your order.']");


    /********************************** Order Completed locators **********************************/

    public static By lblOrderNumber = By.xpath("//div[@class='order-number']/span[@class='value']");
    public static By hdrCreateAccount = By.xpath("//h2[text()='Create Account']");
    public static By tbxEmailCreateAccount = By.xpath("//label[@for='dwfrm_profile_customer_email']/..//input");
    public static By tbxPassCreateAccount = By.xpath("//label[@for='dwfrm_profile_login_password']/..//input");
    public static By tbxConfPassCreateAccount = By.xpath("//label[@for='dwfrm_profile_login_passwordconfirm']/..//input");
    public static By btnCreateAccount = By.xpath("//button[@value='Create Account']");



}

