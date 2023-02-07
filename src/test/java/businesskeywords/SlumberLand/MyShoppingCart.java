package businesskeywords.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import com.changeCX.framework.selenium.FrameworkDriver;
import commonkeywords.CommonActions;
import pages.SlumberLand.MyShoppingCartPage;
import pages.SlumberLand.ProductDetailsPage;
import supportLibraries.Utility_Functions;

public class MyShoppingCart extends ReusableLib {
    CommonActions commonObj;
    private FrameworkDriver ownDriver;

    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public MyShoppingCart(Helper helper) {
        super(helper);
        commonObj = new CommonActions(helper);
        ownDriver = helper.getGSDriver();
    }

    /**
     * Keyword to validate [My Shopping Cart] page header
     */
    public void vrfyMyShoppingCartPageHeader(){
        commonObj.validateText(MyShoppingCartPage.hdrMyShoppingCart, "My Shopping Cart", "Navigated to [My Shopping Cart]");
    }

    /**
     * Keyword to click on [Secure Checkout] button
     */
    public void clickSecureCheckOutBtn(){
        commonObj.closeOverlays();
        //click(MyShoppingCartPage.btnSecureCheckout, "Clicked [Secure Checkout] button");
        Utility_Functions.xClickHiddenElement(ownDriver, report, MyShoppingCartPage.btnSecureCheckout, "Clicked [Secure Checkout] button");
    }

    /**
     * Keyword to remove all products from cart
     */
    public void emptyCart(){
        String cartQty = getText(MyShoppingCartPage.miniCartQty);
        if (!cartQty.equalsIgnoreCase("(0)")){
            commonObj.navigateToMyShoppingCartPage();
            boolean flag = true;
            while (flag){
                commonObj.closeOverlays();
                click(MyShoppingCartPage.btnRemoveProduct);
                Utility_Functions.timeWait(1);
                flag = isDisplayed(MyShoppingCartPage.btnRemoveProduct);
            }
            commonObj.validateText(MyShoppingCartPage.hdrEmptyCart, "Your Shopping Cart is Empty", "Validating cart empty message!");
        }
    }

    /**
     * Keyword to validate [Product Name] in My Shopping Cart page
     */
    public void vrfyProdNameInCart(){
        commonObj.validateText(MyShoppingCartPage.lblProductName, jsonData.getData("ProductName"), "Validating Product Name in [My Shopping Cart]");
    }

    /**
     * Keyword to navigate to My Shopping Cart page
     */
    public void viewCart(){
        click(MyShoppingCartPage.btnViewCart, "");
        commonObj.validateText(MyShoppingCartPage.hdrMyShoppingCart, "My Shopping Cart", "Navigated to [My Shopping Cart]");
    }



}
