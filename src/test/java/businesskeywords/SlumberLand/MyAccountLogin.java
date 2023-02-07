package businesskeywords.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import com.changeCX.framework.selenium.FrameworkDriver;
import commonkeywords.CommonActions;
import pages.SlumberLand.CreateAccountPage;
import pages.SlumberLand.LoginPage;
import pages.SlumberLand.SlumberLandPage;
import supportLibraries.Utility_Functions;


public class MyAccountLogin extends ReusableLib {
    CommonActions commonObj;
    private FrameworkDriver ownDriver;

    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public MyAccountLogin(Helper helper) {
        super(helper);
        commonObj = new CommonActions(helper);
        ownDriver = helper.getGSDriver();
    }

    /**
     * Keyword to validate [My Account Login] page header
     */
    public void vrfyMyAccountLoginPageHeader(){
        commonObj.validateText(LoginPage.hdrMyAccountLogin, "My Account Login", "Validating [My Account Login] page header");
    }

    /**
     * Keyword to navigate to [Sign in] page
     */
    public void navigateToLoginPage(){
        click(SlumberLandPage.btnMyAccount, "Clicked on [My Account] button");
        Utility_Functions.xWaitForElementClickable(ownDriver, SlumberLandPage.btnSignIn, globalWait);
        click(SlumberLandPage.btnSignIn, "Clicked on [Sign In] button");
        vrfyMyAccountLoginPageHeader();
    }

    /**
     * Keyword to navigate to [Sign in] page
     */
    public void goToLoginPage(){
        String url = properties.getProperty("SlumberLand")+"login?original=%2Fs%2Fslumberland%2Fmyaccount";
        String username = properties.getProperty("SlumberLand_UserName");
        String password = properties.getProperty("SlumberLand_Password");
        String embedURL = url.replaceAll("https://", "https://"+username+":"+password+"@");
        ownDriver.get(embedURL);
        vrfyMyAccountLoginPageHeader();
    }

    /**
     * Keyword to perform login using integration data
     */
    public void signIn(){
        String email = Utility_Functions.xGetJsonData("Email");
        String password = Utility_Functions.xGetJsonData("Password");
        String fullname = Utility_Functions.xGetJsonData("FirstName")+" "+Utility_Functions.xGetJsonData("LastName");
        login(email, password, fullname);
    }

    /**
     * Keyword to enter login credentials and click [Login] button
     */
    public void login(String email, String password, String fullname){
        sendKeys(LoginPage.tbxEmail, email);
        sendKeys(LoginPage.tbxPassword, password, "Entered [Email] and [Password]");
        Utility_Functions.timeWait(1);
        click(LoginPage.btnLogin, "Clicked on [Log In] button");
        commonObj.verifyElementContainsText(LoginPage.hdrLoginTitle, fullname, "Validating [Login Dashboard] page header");
    }

    /**
     * Keyword to perform login using test case data
     */
    public void performLogin(){
        String email = jsonData.getData("Email");
        String password = jsonData.getData("Password");
        String fullname = jsonData.getData("FullName");
        login(email, password, fullname);
    }

    /**
     * Keyword to validate UI of [Returning Customers] section in [My Account Login] page
     */
    public void vrfyRetrngCustSctn(){
        String info = "If you are a registered user, please enter your email and password.";
        commonObj.validateText(LoginPage.hdrReturningCustomers, "Returning Customers", "Validating [Returning Customers] section header");
        commonObj.validateText(LoginPage.txtReturningCustomers, info, "Validating [Returning Customers] section info");

        String[] fields = {"Email", "Password"};
        for (int i=0; i<fields.length;i++){
            commonObj.validateText(commonObj.getSpan(fields[i]), fields[i], "Validating field label");
        }
        commonObj.validateText(LoginPage.lblRememberMe, "Remember Me", "Validating [Remember Me] checkbox");
        commonObj.validateElementExists(LoginPage.lnkForgotPassword, "Validating presence of [Forgot Password] hyperlink");
        commonObj.validateElementExists(LoginPage.btnLogin, "Validating presence of [Login] button");
    }

    /**
     * Keyword to validate UI of [New Customers] section in [My Account Login] page
     */
    public void vrfyNewCustSctn(){
        String info = "Creating an account is easy. Just fill out the form below and enjoy the benefits of being a registered customer.";
        commonObj.validateText(LoginPage.hdrNewCustomers, "New Customers", "Validating [New Customers] section header");
        commonObj.validateText(LoginPage.txtNewCustomers, info, "Validating [New Customers] section info");
        commonObj.validateElementExists(LoginPage.btnCreateAccountNow, "Validating presence of [Create Account Now] button");
    }

    /**
     * Keyword to validate UI of [Check Order] section in [My Account Login] page
     */
    public void vrfyChkOrdrSctn(){
        String info = "See your order even if you are not a registered user. Enter the order number and the billing address ZIP code.";
        commonObj.validateText(LoginPage.hdrCheckOrder, "Check Order", "Validating [Check Order] section header");
        commonObj.validateText(LoginPage.txtCheckOrder, info, "Validating [Check Order] section info");

        String[] fields = {"Order Number", "Order Email", "Billing ZIP Code"};
        for (int i=0; i<fields.length;i++){
            commonObj.validateText(commonObj.getSpan(fields[i]), fields[i], "Validating field label");
        }
        commonObj.validateElementExists(LoginPage.btnCheckStatus, "Validating presence of [Check Status] button");
    }

    /**
     * Keyword to click on [Personal Data] button in [My Account] page
     */
    public void clickPersonalData(){
        click(LoginPage.btnPersonalData, "Clicked on [Personal Data] button");
        commonObj.validateText(LoginPage.hdrEditAccount, "Edit Account", "Validating [Edit Account] header");
    }

    /**
     * Keyword to update password in [Edit Account] page
     */
    public void updatePassword(){
        String currentPw = Utility_Functions.xGetJsonData("Password");
        String updatedPw = currentPw+"1";
        Utility_Functions.xUpdateJson("Password", updatedPw);
        Utility_Functions.xScrollElementToCentre(ownDriver, CreateAccountPage.tbxCurrentPassword);
        sendKeys(CreateAccountPage.tbxCurrentPassword, currentPw, "Entered current password");
        sendKeys(CreateAccountPage.tbxNewPassword, updatedPw, "Entered updated password");
        sendKeysAndTab(CreateAccountPage.tbxConfirmNewPassword, updatedPw, "Re-entered updated password");
        click(CreateAccountPage.btnUpdatePassword, "Clicked on change password [Apply] button");
        commonObj.verifyElementContainsText(LoginPage.hdrLoginTitle, "My Account |", "Validating [My Account] page header");
    }

    /**
     * Keyword to update email in [Edit Account] page
     */
    public void updateEmail(){
        String pw = Utility_Functions.xGetJsonData("Password");
        String updatedEmail = "Test"+Utility_Functions.xRandomFunction(999999)+"@gmail.com";
        Utility_Functions.xUpdateJson("Email", updatedEmail);
        Utility_Functions.xScrollElementToCentre(ownDriver, CreateAccountPage.tbxEmailUpdate);
        sendKeys(CreateAccountPage.tbxEmailUpdate, updatedEmail, "Entered new Email id");
        sendKeys(CreateAccountPage.tbxConfirmEmailUpdate, updatedEmail, "Re-entered new Email id");
        sendKeysAndTab(CreateAccountPage.tbxPasswordForEmailUpdate, pw, "Entered current password");
        click(CreateAccountPage.btnUpdateEmail, "Clicked on update email [Apply] button");
        commonObj.verifyElementContainsText(LoginPage.hdrLoginTitle, "My Account |", "Validating [My Account] page header");
    }

}
