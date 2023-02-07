package businesskeywords.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import com.changeCX.framework.selenium.FrameworkDriver;
import commonkeywords.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SlumberLand.LoginPage;
import pages.SlumberLand.SlumberLandPage;
import pages.SlumberLand.WishlistPage;

import java.util.List;

public class SlumberLand extends ReusableLib {
    CommonActions commonObj;
    private FrameworkDriver ownDriver;
    //private Eyes eyes;
    //protected String apiKey = "F7vZ4ZJKiHDPBDgm98qVUPekYv107exvtWjbg8foLmonKw110";

    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public SlumberLand(Helper helper) {
        super(helper);
        commonObj = new CommonActions(helper);
        ownDriver = helper.getGSDriver();
        /*eyes = new Eyes();
        eyes.setApiKey(apiKey);
        eyes.setStitchMode(StitchMode.CSS);
        eyes.setHideScrollbars(true);
        eyes.setHideCaret(true);*/
    }

    /**
     * Keyword to launch SlumberLand App
     */
    public void launchSlumberLand() {
        String url = properties.getProperty("SlumberLand");
        String username = properties.getProperty("SlumberLand_UserName");
        String password = properties.getProperty("SlumberLand_Password");
        String embedURL = url.replaceAll("https://", "https://"+username+":"+password+"@");
        ownDriver.get(embedURL);
    }

    private WebElement getTopMenu(String menu){
        return ownDriver.findElement(By.xpath("//a[contains(@class,'top-menu-link') and contains(text(),'"+menu+"')]/../button"));
    }

    private WebElement getSubMenu(String subMenu){
        return ownDriver.findElement(By.xpath("//a[contains(@class,'top-menu-link')]/../div[@class='level-2']//a[contains(text(),'"+subMenu+"')]"));
    }

    /**
     * Keyword to navigate to [All Mattresses] page
     */
    public void navigateToAllMattresses(){
        click(getTopMenu("Mattresses"));
        click(getSubMenu("All Mattresses"));
        commonObj.validateText(SlumberLandPage.hdrSearchResults, "All Mattresses", "Navigated to [All Mattresses] page");
    }

    /**
     * Keyword to navigate to [All Chairs] page
     */
    public void navigateToAllChairs(){
        click(getTopMenu("Chairs"));
        click(getSubMenu("All Chairs"));
        commonObj.validateText(SlumberLandPage.hdrSearchResults, "Chairs For Sale", "Navigated to [Chairs For Sale] page");
    }

    /**
     * Keyword to navigate to [Recliners and Rocking Recliners] page
     */
    public void navigateToReclinersSearch(){
        click(getTopMenu("Chairs"));
        click(getSubMenu("Recliners"));
        commonObj.validateText(SlumberLandPage.hdrSearchResults, "Recliners and Rocking Recliners", "Navigated to [Recliners and Rocking Recliners] page");
    }

    /**
     * Keyword to navigate to [All Mattresses] page
     */
    public void goToAllMattresses(){
        String url = properties.getProperty("SlumberLand")+"c/mattresses/all-mattresses";
        String username = properties.getProperty("SlumberLand_UserName");
        String password = properties.getProperty("SlumberLand_Password");
        String embedURL = url.replaceAll("https://", "https://"+username+":"+password+"@");
        ownDriver.get(embedURL);
        commonObj.validateText(SlumberLandPage.hdrSearchResults, "All Mattresses", "Navigated to [All Mattresses] page");
    }

    /**
     * Keyword to navigate to [All Chairs] page
     */
    public void goToAllChairs(){
        String url = properties.getProperty("SlumberLand")+"c/chairs/all-chairs";
        String username = properties.getProperty("SlumberLand_UserName");
        String password = properties.getProperty("SlumberLand_Password");
        String embedURL = url.replaceAll("https://", "https://"+username+":"+password+"@");
        ownDriver.get(embedURL);
        commonObj.validateText(SlumberLandPage.hdrSearchResults, "Chairs For Sale", "Navigated to [Chairs For Sale] page");
    }

    /**
     * Keyword to navigate to [Recliners Search] page
     */
    public void goToReclinerSearch(){
        String url = properties.getProperty("SlumberLand")+"c/chairs/all-chairs/recliners";
        String username = properties.getProperty("SlumberLand_UserName");
        String password = properties.getProperty("SlumberLand_Password");
        String embedURL = url.replaceAll("https://", "https://"+username+":"+password+"@");
        ownDriver.get(embedURL);
        commonObj.validateText(SlumberLandPage.hdrSearchResults, "Recliners and Rocking Recliners", "Navigated to [Recliners and Rocking Recliners] page");
    }

    /**
     * Keyword to search products using keyword
     */
    public void searchProductByKeyword(){
        String keyword = jsonData.getData("Keyword");
        sendKeysAndEnter(SlumberLandPage.searchBox, keyword, "Entered keyword ["+keyword+"] for product search");
    }

    /**
     * Keyword to search products using [Product ID]
     */
    public void searchProdID(){
        sendKeysAndEnter(SlumberLandPage.searchBox, jsonData.getData("ProductID"), "Entered Product ID in product search tbx and hit [Enter]");
    }

    /**
     * Keyword to click on [SlumberLand Home] button
     */
    public void goToHome(){
        click(SlumberLandPage.homeSlumberLand, "Clicked on [SlumberLand Home] button");
    }

    /**
     * Keyword to navigate to [WishList] page
     */
    public void navToWishlist(){
        click(SlumberLandPage.btnMyAccount, "Clicked on [My Account] button");
        click(WishlistPage.btnWishlist, "Clicked on [Wishlist] button");
        commonObj.validateText(WishlistPage.hdrFindWishlist, "Find Someone's Wish List:", "Navigated to [Wishlist] page");
    }

    /**
     * Keyword to navigate to [My Account] page
     */
    public void navMyAccount(){
        click(SlumberLandPage.btnMyAccount, "Clicked on [User Info] button");
        click(SlumberLandPage.btnGoToMyAccount, "Clicked on [My Account] button");
        commonObj.verifyElementContainsText(LoginPage.hdrLoginTitle, "My Account |", "Validating [My Account] page header");
    }

    /**
     * Keyword to signout
     */
    public void signout(){
        click(SlumberLandPage.btnMyAccount, "Clicked on [User Info] button");
        click(SlumberLandPage.btnLogout, "Clicked on [Logout] button");
        commonObj.validateText(LoginPage.hdrMyAccountLogin, "My Account Login", "Validating [My Account Login] page header");
    }

}
