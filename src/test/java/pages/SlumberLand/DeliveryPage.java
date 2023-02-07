package pages.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import org.openqa.selenium.By;

public class DeliveryPage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public DeliveryPage(Helper helper) {
        super(helper);
    }

    public static By tbxEmailAddress=By.id("dwfrm_login_username");
    public static By btnSearchEmail=By.name("dwfrm_login_search");
    public static By errorUserNotFound=By.xpath("//div[@class='not-found-user user-alert-msg']");
    public static By rbDeliverToAddress=By.xpath("//input[@id='shipToOption-address']");
    public static By rbPickUpInStore=By.xpath("//input[@id='shipToOption-store']");
    public static By hdrDeliveryMethods=By.xpath("//legend[text()='Delivery Methods & Details']");

    /********************************** Deliver to an Address section locators **********************************/

    public static By hdrEnterYourAddress=By.xpath("//legend[contains(text(),'Enter Your Delivery Details')]");
    public static By tbxFirstName_Address=By.xpath("//input[contains(@id,'addressFields_firstName')]");
    public static By tbxLastName_Address=By.xpath("//input[contains(@id,'addressFields_lastName')]");
    public static By tbxAddress1=By.xpath("//input[contains(@id,'addressFields_address1')]");
    public static By tbxCity=By.xpath("//input[contains(@id,'addressFields_city')]");
    public static By TbxZipCode=By.xpath("//input[contains(@id,'addressFields_postal')]");
    public static By ddnCountry=By.xpath("//select[contains(@id,'addressFields_country')]");
    public static By ddnState=By.xpath("//select[contains(@id,'addressFields_state')]");
    public static By tbxMobilePhone=By.xpath("//input[contains(@id,'addressFields_phone')]");
    public static By btnContinueToPayment=By.xpath("//button[@id='form-submit' and text()='Continue to Payment']");

    /********************************** Pick-up in Store section locators **********************************/

    public static By hdrSelectStore=By.xpath("//legend[text()='Select a Store to Ship to and Arrange for In-Store Pickup']");
    public static By tbxEnterAddress=By.xpath("//form[@id='find-store-form']//input[@id='address']");
    public static By ddnDistance=By.xpath("//form[@id='find-store-form']//select[@id='distance']");
    public static By btnSearch=By.xpath("//form[@id='find-store-form']//button[@value='Search']");
    public static By lblStoreName=By.xpath("//div[@class='find-store-name']/div[@class='name']");
    public static By btnChooseStore=By.xpath("//div[@class='find-store-results']//button[@value='Choose Store']");
    public static By hdrPickUpInStore=By.xpath("//span[text()='Pick Up In-Store']");
    public static By btnEditPickUpInStore=By.xpath("//a[@class='find-store']");
    public static By lblSelectedStoreName=By.xpath("//div[contains(@class,'hasShipToStore')]/div[2]/span[1]");
    public static By hdrContactDetails=By.xpath("//legend[contains(text(),'Phone Number (For Order Info)')]");
    public static By tbxPickupInStoreMobilePhone=By.xpath("//input[contains(@id,'shippingAddress_addressFields_phone')]");

    /********************************** Delivery Address section locators **********************************/

    public static By btnEditDeliverAddress=By.xpath("//span[text()='Delivery Address']/..");
    public static By txtMiniShipmentMethod=By.xpath("//div[@class='minishipments-method']");

    /********************************** Your Order section locators **********************************/

    public static By btnEditYourOrder=By.xpath("//h3[contains(text(),'Your Order')]/a");
    public static By lblQty=By.xpath("//div[@class='mini-cart-pricing']/span[@class='value']");
    public static By lblItemPrice=By.xpath("//div[@class='mini-cart-pricing']/span[@class='mini-cart-price']");


    /********************************** Order Summary section locators **********************************/

    public static By btnEditOrderSummary=By.xpath("//h3[contains(text(),'Order Summary')]/a");
}

