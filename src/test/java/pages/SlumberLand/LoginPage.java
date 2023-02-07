package pages.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import org.openqa.selenium.By;

public class LoginPage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public LoginPage(Helper helper) {
        super(helper);
    }

    public static By hdrMyAccountLogin = By.xpath("//h1[text()='My Account Login']");
    public static By hdrLoginTitle = By.xpath("//h1[@class='landing-title']");

    /******************************** Returning Customers section Locators ********************************/

    public static By txtReturningCustomers = By.xpath("//div[contains(@class,'returning-customers clearfix')]/p");
    public static By hdrReturningCustomers = By.xpath("//h2[text()='Returning Customers']");
    public static By tbxEmail = By.xpath("//input[@id='dwfrm_login_username']");
    public static By tbxPassword = By.xpath("//input[@id='dwfrm_login_password']");
    public static By btnLogin = By.xpath("//button[@name='dwfrm_login_login']");
    public static By lblRememberMe = By.xpath("//label[@for='dwfrm_login_rememberme']");
    public static By lnkForgotPassword = By.xpath("//a[@id='password-reset']");

    /******************************** Check Order section Locators ********************************/

    public static By hdrCheckOrder = By.xpath("//h2[contains(text(),'Check Order')]");
    public static By txtCheckOrder = By.xpath("//p[contains(text(),'Enter the order number and the billing address')]");
    public static By btnCheckStatus = By.xpath("//button[@name='dwfrm_ordertrack_findorder']");

    /******************************** New Customers section Locators ********************************/

    public static By hdrNewCustomers = By.xpath("//h2[text()='New Customers']");
    public static By txtNewCustomers = By.xpath("//p[contains(text(),'Creating an account is easy')]");
    public static By btnCreateAccountNow = By.xpath("//button[@name='dwfrm_login_register']");

    /******************************** Personal Data page Locators ********************************/

    public static By btnPersonalData = By.xpath("//h2[text()='Personal Data']");
    public static By hdrEditAccount = By.xpath("//h1[text()='Edit Account']");

}

