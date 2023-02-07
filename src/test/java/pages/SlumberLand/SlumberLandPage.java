package pages.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import org.openqa.selenium.By;

public class SlumberLandPage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public SlumberLandPage(Helper helper) {
        super(helper);
    }

    public static By hdrSearchResults = By.xpath("//h1[@class='refinement-header']");
    public static By homeSlumberLand = By.xpath("//a[@title='Slumberland Furniture Home']");

    /**************************** MyAccount elements ****************************/

    public static By btnMyAccount = By.xpath("//div[@class='user-info']//*[name()='svg' and contains(@class,'svg-account-filled')]");
    public static By btnSignIn = By.xpath("//li[@class='sl-menu-utility-user']//a[text()='Sign In']");
    public static By btnViewCart = By.xpath("//div[@id='mini-cart']//a[@title='View Cart']");
    public static By btnGoToMyAccount = By.xpath("//li[@class='sl-menu-utility-user']//a[text()='My Account']");
    public static By btnLogout = By.xpath("//li[@class='sl-menu-utility-user']//a[text()='Logout']");

    /**************************** Generic elements ****************************/

    public static By exclusiveOffersContainer=By.xpath("//div[contains(@class,'fixed-container')]");
    public static By btnExclusiveOffersClose=By.xpath("//div[contains(@class,'fixed-container')]//div[contains(@id,'closeBtn')]");
    public static By unlockOffersOverlay=By.xpath("//div[@class='bx-wrap']");
    public static By btnCloseUnlockOffersOverlay=By.xpath("//a[contains(@id,'bx-close-inside')]");

    /**************************** Product Search elements ****************************/

    public static By searchBox=By.xpath("//input[@id='q']");
    public static By searchSuggestionProdName=By.xpath("//div[@id='search-suggestions']//div[@class='product-name']");




}

