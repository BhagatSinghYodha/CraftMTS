package pages.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import org.openqa.selenium.By;

public class CreateAccountPage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public CreateAccountPage(Helper helper) {
        super(helper);
    }

    public static By btnCreateAnAccount=By.xpath("//li[@class='sl-menu-utility-user']//a[text()='Create An Account']");
    public static By hdrCreateAccount=By.xpath("//h1[text()='Create Account']");
    public static By tbxFname = By.id("dwfrm_profile_customer_firstname");
    public static By tbxLname = By.id("dwfrm_profile_customer_lastname");
    public static By tbxEmailCreateAccount = By.id("dwfrm_profile_customer_email");
    public static By tbxConfirmEmail = By.id("dwfrm_profile_customer_emailconfirm");
    public static By tbxPasswordCreateAccount = By.id("dwfrm_profile_login_password");
    public static By tbxConfirmPassword = By.id("dwfrm_profile_login_passwordconfirm");
    public static By btnApply = By.xpath("//button[@name='dwfrm_profile_confirm']");

    public static By lstSctnHeader = By.xpath("//div[@class='section-header']/h2");
    public static By passwordHelper = By.xpath("//div[contains(text(),'At least 8 characters')]");
    public static By lblAddToEmailList = By.xpath("//label[contains(@for,'customer_addtoemaillist')]/span");
    public static By chkbxAddToEmailList = By.xpath("//input[contains(@id,'customer_addtoemaillist')]");
    public static By lblErrorMessage = By.xpath("//div[@class='form-caption error-message']");

    /***************************************** Update Account locators *****************************************/

    public static By tbxCurrentPassword = By.xpath("//input[@id='dwfrm_profile_login_currentpassword']");
    public static By tbxNewPassword = By.xpath("//input[@id='dwfrm_profile_login_newpassword']");
    public static By tbxConfirmNewPassword = By.xpath("//input[@id='dwfrm_profile_login_newpasswordconfirm']");
    public static By btnUpdatePassword = By.xpath("//button[@name='dwfrm_profile_changepassword']");

    public static By tbxEmailUpdate = By.xpath("//input[@id='dwfrm_profile_customer_email']");
    public static By tbxConfirmEmailUpdate = By.xpath("//input[@id='dwfrm_profile_customer_emailconfirm']");
    public static By tbxPasswordForEmailUpdate = By.xpath("//input[@id='dwfrm_profile_login_password']");
    public static By btnUpdateEmail = By.xpath("//button[@name='dwfrm_profile_confirm']");

}

