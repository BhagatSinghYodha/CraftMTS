package businesskeywords.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import com.changeCX.framework.Status;
import com.changeCX.framework.selenium.FrameworkDriver;
import commonkeywords.CommonActions;
import org.openqa.selenium.WebElement;
import pages.SlumberLand.BillingPage;
import pages.SlumberLand.DeliveryPage;
import pages.SlumberLand.MyShoppingCartPage;
import supportLibraries.Utility_Functions;

import java.util.List;

public class Delivery extends ReusableLib {
    CommonActions commonObj;
    private FrameworkDriver ownDriver;

    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public Delivery(Helper helper) {
        super(helper);
        commonObj = new CommonActions(helper);
        ownDriver = helper.getGSDriver();
    }

    /**
     * Keyword to enter guest email and validate
     */
    public void validateGuestEmailAddress(){
        String email = "Test"+ Utility_Functions.xRandomFunction(9999)+"@gmail.com";
        sendKeys(DeliveryPage.tbxEmailAddress, email);
        Utility_Functions.timeWait(1);

        getElement(DeliveryPage.btnSearchEmail).click();
        commonObj.validateText(DeliveryPage.errorUserNotFound, "We couldn't find a Slumberland.com account with that email address. You can continue checkout as a guest, or re-enter your email address and click \"Search\" to try again.", "Entered random email for search");
    }

    /**
     * Keyword to select [Deliver to Address] radio button
     */
    public void clickDeliverToAnAddress(){
        commonObj.closeOverlays();
        Utility_Functions.xClickHiddenElement(ownDriver, DeliveryPage.rbDeliverToAddress);
        Utility_Functions.timeWait(1);
        //commonObj.validateText(DeliveryPage.hdrEnterYourAddress, "Enter Your Delivery Details", "Selected [Deliver to Address] radio button");
    }

    /**
     * Keyword to enter Address details
     */
    public void enterAddressDetails(){
        String fName = jsonData.getData("FirstName");
        String lName = jsonData.getData("LastName");
        String address = jsonData.getData("Address");
        String city = jsonData.getData("City");
        String zip = jsonData.getData("Zip");
        String country = jsonData.getData("Country");
        String state = jsonData.getData("State");
        String mobile = jsonData.getData("Mobile");

        sendKeys(DeliveryPage.tbxFirstName_Address, fName);
        sendKeys(DeliveryPage.tbxLastName_Address, lName);
        sendKeys(DeliveryPage.tbxAddress1, address);
        sendKeys(DeliveryPage.tbxCity, city);
        sendKeys(DeliveryPage.TbxZipCode, zip);
        Utility_Functions.xSelectDropdownByName(ownDriver, DeliveryPage.ddnCountry, country);
        Utility_Functions.xSelectDropdownByName(ownDriver, DeliveryPage.ddnState, state);
        sendKeysAndTab(DeliveryPage.tbxMobilePhone, mobile, "");
        Utility_Functions.timeWait(3);
    }

    /**
     * Keyword to click [Continue to Payment] button
     */
    public void clickContinueToPaymentBtn(){
        Utility_Functions.xScrollElementToCentre(ownDriver, DeliveryPage.btnContinueToPayment);
        click(DeliveryPage.btnContinueToPayment, "Clicked on [Continue to Payment] button");
        commonObj.validateText(BillingPage.lblSelectPaymentMethod, "Select Payment Method", "Validating [Select Payment Method] section-header");
    }

    /**
     * Keyword to select [Pick Up In-Store] radio button
     */
    public void selectPickUpInStore(){
        commonObj.closeOverlays();
        Utility_Functions.xClickHiddenElement(ownDriver, DeliveryPage.rbPickUpInStore);
        Utility_Functions.timeWait(1);
        editPickUpInStore();
        commonObj.validateText(DeliveryPage.hdrSelectStore, "Select a Store to Ship to and Arrange for In-Store Pickup", "Validating Select a store header");
        commonObj.validateText(DeliveryPage.hdrContactDetails, "Phone Number (For Order Info)", "Validating [Phone Number (For Order Info)] header");
    }

    /**
     * Keyword to edit [Pick Up In-Store]
     */
    public void editPickUpInStore(){
        boolean flag = isDisplayed(DeliveryPage.hdrPickUpInStore);
        if (flag)
            click(DeliveryPage.btnEditPickUpInStore, "Clicked on [Edit] button for Pick-up in Store");
    }

    /**
     * Keyword to select Store for Pick-Up
     */
    public void selectRandomStore() {
        String zipCode = jsonData.getData("Zip");
        String mobile = jsonData.getData("Mobile");
        sendKeys(DeliveryPage.tbxEnterAddress, zipCode, "Entered [Zip Code] for Pick-up store search");
        Utility_Functions.xSelectDropdownByName(ownDriver, DeliveryPage.ddnDistance, "50 Miles");
        click(DeliveryPage.btnSearch, "Clicked on [Search] button");
        waitForVisible(DeliveryPage.btnChooseStore);

        List<WebElement> lstStoreName = Utility_Functions.findElementsByXpath(ownDriver, DeliveryPage.lblStoreName);
        List<WebElement> lstChooseStoreBtn = Utility_Functions.findElementsByXpath(ownDriver, DeliveryPage.btnChooseStore);
        int random = Utility_Functions.xRandomFunction(0, lstChooseStoreBtn.size()-1);
        String storeName = lstStoreName.get(random).getText().trim();
        click(lstChooseStoreBtn.get(random), "Clicked on [Choose Store] button");
        Utility_Functions.timeWait(3);
        commonObj.validateText(DeliveryPage.hdrPickUpInStore, "Pick Up In-Store", "Validating [Pick Up In-Store] header");
        commonObj.validateText(DeliveryPage.lblSelectedStoreName, storeName, "Validating selected store name");
        sendKeysAndTab(DeliveryPage.tbxPickupInStoreMobilePhone, mobile, "Entered [Mobile Number]");
    }

    /**
     * Keyword to click [Edit] button in [Delivery Address] section
     */
    public void clickEditDeliveryAddress(){
        click(DeliveryPage.btnEditDeliverAddress, "Clicked on [Edit] button in [Delivery Address] section");
        waitForElementPresent(DeliveryPage.hdrDeliveryMethods);
    }

    /**
     * Keyword to validate [Delivery Method] in Delivery Address section
     */
    public void vrfyDeliveryMethod() {
        Utility_Functions.xScrollElementToCentre(ownDriver, DeliveryPage.txtMiniShipmentMethod);
        commonObj.validateText(DeliveryPage.txtMiniShipmentMethod, "Method: Store Pickup", "Validating [Delivery Method]");
    }

    /**
     * Keyword to edit and verify Your Order section data
     */
    public void editYourOrderAndVerify(){
        String qty = "2";
        click(DeliveryPage.btnEditYourOrder, "Clicked on [Edit] button in [Your Order] section");
        commonObj.validateText(MyShoppingCartPage.hdrMyShoppingCart, "My Shopping Cart", "Navigated to [My Shopping Cart]");
        Utility_Functions.xSelectDropdownByName(ownDriver, MyShoppingCartPage.ddnSelectQty, qty);
        Utility_Functions.timeWait(2);
        report.updateTestLog("Selected Qty", "Selected Qty", Status.PASS);

        commonObj.closeOverlays();
        click(MyShoppingCartPage.btnSecureCheckout, "Clicked [Secure Checkout] button");
        waitForElementPresent(DeliveryPage.btnEditYourOrder);

        List<WebElement> lstQty = Utility_Functions.findElementsByXpath(ownDriver, DeliveryPage.lblQty);
        for (WebElement qtyElement : lstQty) {
            if (qtyElement.isDisplayed()) {
                commonObj.validateText(qtyElement, qty, "Validating updated [Quantity] of product");
                break;
            }
        }
    }

    /**
     * Keyword to edit and verify Order Summary section data
     */
    public void editOrderSummaryAndVerify() {
        String qty = "2";
        click(DeliveryPage.btnEditOrderSummary, "Clicked on [Edit] button in [Order Summary] section");
        commonObj.validateText(MyShoppingCartPage.hdrMyShoppingCart, "My Shopping Cart", "Navigated to [My Shopping Cart]");
        Utility_Functions.xSelectDropdownByName(ownDriver, MyShoppingCartPage.ddnSelectQty, qty);
        Utility_Functions.timeWait(2);
        report.updateTestLog("Selected Qty", "Selected Qty", Status.PASS);

        String subTotal = getText(MyShoppingCartPage.lblSubTotal);
        String estimatedSalesTax = getText(MyShoppingCartPage.lblEstimatedSalesTax);
        String estimatedTotal = getText(MyShoppingCartPage.lblEstimatedTotal);

        commonObj.closeOverlays();
        click(MyShoppingCartPage.btnSecureCheckout, "Clicked [Secure Checkout] button");
        waitForElementPresent(DeliveryPage.btnEditOrderSummary);

        Utility_Functions.xHighlight(ownDriver, MyShoppingCartPage.lblSubTotal, "red");
        Utility_Functions.xAssertEquals(report, subTotal, ownDriver.findElement(MyShoppingCartPage.lblSubTotal), "Validating updated [Sub Total]");
        Utility_Functions.xHighlight(ownDriver, MyShoppingCartPage.lblEstimatedSalesTax, "red");
        Utility_Functions.xAssertEquals(report, estimatedSalesTax, ownDriver.findElement(MyShoppingCartPage.lblEstimatedSalesTax), "Validating updated [Estimated Sales Tax]");
        Utility_Functions.xHighlight(ownDriver, MyShoppingCartPage.lblEstimatedTotal, "red");
        Utility_Functions.xAssertEquals(report, estimatedTotal, ownDriver.findElement(MyShoppingCartPage.lblEstimatedTotal), "Validating updated [Estimated Order Total]");
    }



}
