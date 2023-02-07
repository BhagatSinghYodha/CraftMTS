package businesskeywords.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import com.changeCX.framework.selenium.FrameworkDriver;
import commonkeywords.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SlumberLand.CreateAccountPage;
import pages.SlumberLand.LoginPage;
import pages.SlumberLand.SlumberLandPage;
import supportLibraries.Utility_Functions;

import java.util.List;

public class CreateAccount extends ReusableLib {
    CommonActions commonObj;
    private FrameworkDriver ownDriver;

    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public CreateAccount(Helper helper) {
        super(helper);
        commonObj = new CommonActions(helper);
        ownDriver = helper.getGSDriver();
    }

    /**
     * Keyword to validate [Create Account] page header
     */
    public void vrfyCreateAccountPageHeader(){
        commonObj.validateText(CreateAccountPage.hdrCreateAccount, "Create Account", "Validating [Create Account] page header");
    }

    /**
     * Keyword to navigate to [Create Account] page
     */
    public void navigateToCreateAccountPage(){
        click(SlumberLandPage.btnMyAccount, "Clicked on [My Account] button");
        click(CreateAccountPage.btnCreateAnAccount, "Clicked on [Create An Accoount] button");
        vrfyCreateAccountPageHeader();
    }

    /**
     * Keyword to UI of [Create Account] page
     */
    public void vrfyUIofCreateAccountPage(){
        String[] sectionHeader = {"Name", "Email/Login Information"};
        List<String> sectionHeaderActual = getListOfWebElementText(CreateAccountPage.lstSctnHeader);
        for (int i=0; i<sectionHeader.length;i++){
            Utility_Functions.xAssertEquals(report, sectionHeader[i], sectionHeaderActual.get(i),"Validating section-header ["+sectionHeader[i]+"]");
        }

        String[] fields = {"First Name", "Last Name", "Email", "Confirm Email", "Password", "Confirm Password"};
        for (int i=0; i<fields.length;i++){
            commonObj.validateText(commonObj.getSpan(fields[i]), fields[i], "Validating field label");
        }
        commonObj.validateText(CreateAccountPage.passwordHelper, "At least 8 characters, at least 1 number and 1 letter", "Validating Password helper text");
        String addToEmailListText = "Add me to the Slumberland email list for access to private sales and offers. Slumberland does not share or sell personal info.";
        commonObj.validateText(CreateAccountPage.lblAddToEmailList, addToEmailListText, "Validating Add To Email List text");
        commonObj.validateElementExists(CreateAccountPage.chkbxAddToEmailList, "Validating presence of [Add To Email List] checkbox");
        commonObj.validateElementExists(CreateAccountPage.btnApply, "Validating presence of [Apply] button");
    }

    /**
     * Keyword to enter details for account creation
     */
    public void enterDataForCreateAccount(){
        int random = Utility_Functions.xRandomFunction(999999);
        String fName = "TestFname"+random;
        String lName = "TestLname"+random;
        String email = "Test"+random+"@gmail.com";
        String password = "Test@"+random;
        Utility_Functions.xUpdateJson("Email", email);
        Utility_Functions.xUpdateJson("Password", password);
        Utility_Functions.xUpdateJson("FirstName", fName);
        Utility_Functions.xUpdateJson("LastName", lName);

        sendKeys(CreateAccountPage.tbxFname, fName);
        sendKeys(CreateAccountPage.tbxLname, lName, "Entered [First Name] and [Last Name]");
        sendKeys(CreateAccountPage.tbxEmailCreateAccount, email);
        sendKeys(CreateAccountPage.tbxConfirmEmail, email);
        sendKeys(CreateAccountPage.tbxPasswordCreateAccount, password);
        sendKeys(CreateAccountPage.tbxConfirmPassword, password, "Entered [Email] and [Password]");
        click(CreateAccountPage.btnApply, "Clicked on [Apply] button");
        commonObj.verifyElementContainsText(LoginPage.hdrLoginTitle, fName+" "+lName, "Validating [Login Dashboard] page header");
    }

    /**
     * Keyword to validate Required Field Message in [Create Account] page
     */
    public void vrfyRequiredFieldMsgInCreateAccountPage(){
        click(CreateAccountPage.btnApply, "Clicked on [Apply] button");
        String[] fields = {"First Name", "Last Name", "Email", "Confirm Email", "Password", "Confirm Password"};
        for (int i=0; i<fields.length;i++){
            WebElement element = ownDriver.findElement(By.xpath("//span[text()='"+fields[i]+" is required.']"));
            vrfyElementExist(element, "Validating presence of field required error for ["+fields[i]+"]");
        }
    }

    /**
     * Keyword to Acceptable Password Policy for account creation
     */
    public void vrfyPasswordPolicy(){
        int random = Utility_Functions.xRandomFunction(9999);
        String fName = "TestFname"+random;
        String lName = "TestLname"+random;
        String email = "Test"+random+"@gmail.com";
        String password = "Test@"+random;
        sendKeys(CreateAccountPage.tbxFname, fName);
        sendKeys(CreateAccountPage.tbxLname, lName, "Entered [First Name] and [Last Name]");
        sendKeys(CreateAccountPage.tbxEmailCreateAccount, email);
        sendKeys(CreateAccountPage.tbxConfirmEmail, email);

        sendKeys(CreateAccountPage.tbxPasswordCreateAccount, "test");
        sendKeysAndTab(CreateAccountPage.tbxConfirmPassword, "test", "Entered [Password] as [test] less than 8 characters");
        click(CreateAccountPage.btnApply, "Clicked on [Apply] button");

        String[] fields = {"Password", "Confirm Password"};
        for (int i=0; i<fields.length;i++){
            WebElement element = ownDriver.findElement(By.xpath("//input[@data-required-text='"+fields[i]+"']/following-sibling::span"));
            commonObj.validateText(element, "Please enter at least 8 characters.", "Validating error");
        }

        sendKeys(CreateAccountPage.tbxPasswordCreateAccount, "testingg");
        sendKeysAndTab(CreateAccountPage.tbxConfirmPassword, "testingg", "Entered [Password] as [testingg] exactly 8 characters");
        click(CreateAccountPage.btnApply, "Clicked on [Apply] button");
        commonObj.validateText(CreateAccountPage.lblErrorMessage, "Password must have at least 1 uppercase, lowercase, special character and number.", "Validating error");
    }

}
