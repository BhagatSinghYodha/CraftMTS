package businesskeywords.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import com.changeCX.framework.Status;
import com.changeCX.framework.selenium.FrameworkDriver;
import commonkeywords.CommonActions;
import org.openqa.selenium.WebElement;
import pages.SlumberLand.MyShoppingCartPage;
import pages.SlumberLand.ProductDetailsPage;
import pages.SlumberLand.WishlistPage;
import supportLibraries.Utility_Functions;

import java.util.List;

public class ProductDetails extends ReusableLib {
    CommonActions commonObj;
    private FrameworkDriver ownDriver;

    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public ProductDetails(Helper helper) {
        super(helper);
        commonObj = new CommonActions(helper);
        ownDriver = helper.getGSDriver();
    }

    /**
     * Keyword to click on [View Cart] button
     */
    public void vrfyProductDetailsDisplayed(){
        waitForElementClickable(ProductDetailsPage.btnAddToCart, globalWait);
        if (isDisplayed(ProductDetailsPage.hdrProductName)){
            Utility_Functions.xHighlight(ownDriver, ProductDetailsPage.hdrProductName, "red");
            report.updateTestLog("Verify Product Name displayed", "Product Name is displayed", Status.PASS);
        }
        else
            report.updateTestLog("Verify Product Name displayed", "Product Name is NOT displayed",Status.FAIL);

        if (isDisplayed(ProductDetailsPage.lblSalePrice)){
            Utility_Functions.xHighlight(ownDriver, ProductDetailsPage.lblSalePrice, "red");
            report.updateTestLog("Verify Product Sale Price displayed", "Product Sale Price is displayed", Status.PASS);
        }
        else
            report.updateTestLog("Verify Product Sale Price displayed", "Product Sale Price is NOT displayed",Status.FAIL);

        if (isDisplayed(ProductDetailsPage.productPrimaryImg))
            report.updateTestLog("Verify Product Image displayed", "Product Image is displayed", Status.PASS);
        else
            report.updateTestLog("Verify Product Image displayed", "Product Image is NOT displayed",Status.FAIL);
    }

    /**
     * Keyword to click on [Add To Cart] button
     */
    public void clickAddToCartBtn(){
        waitForVisible(ProductDetailsPage.prodReviewStars);
        commonObj.closeOverlays();
        Utility_Functions.xClickHiddenElement(ownDriver, report, ProductDetailsPage.btnAddToCart, "Clicked on [Add To Cart] button");
        //click(ProductDetailsPage.btnAddToCart, "Clicked on [Add To Cart] button");
        Utility_Functions.timeWait(3);
        //Utility_Functions.waitForElementVisible(ownDriver, ProductDetailsPage.popupUIDialogTitle, globalWait);
        commonObj.validateText(ProductDetailsPage.popupUIDialogTitle, "Item Added To Cart!", "Item successfully added to cart");
    }

    /**
     * Keyword to click on [View Cart] button
     */
    public void clickViewCartBtnInPopup(){
        commonObj.closeOverlays();
        Utility_Functions.xClickHiddenElement(ownDriver, report, ProductDetailsPage.btnViewCartInPopup, "Clicked on [View Cart] button");
        //click(ProductDetailsPage.btnViewCartInPopup, "Clicked on View Cart button");
        commonObj.validateText(MyShoppingCartPage.hdrMyShoppingCart, "My Shopping Cart", "Navigated to [My Shopping Cart]");
    }

    /**
     * Keyword to get Product Name and Product ID
     */
    public void getProductNameAndID(){
        String prodName = getText(ProductDetailsPage.hdrProductName);
        String prodID = getText(ProductDetailsPage.productID);
        jsonData.putData("ProductName", prodName);
        jsonData.putData("ProductID", prodID);
    }

    /**
     * Keyword to validate Product Name and Product ID
     */
    public void vrfyProdNameAndID(){
        String prodName = jsonData.getData("ProductName");
        String prodID = jsonData.getData("ProductID");
        commonObj.validateText(ProductDetailsPage.hdrProductName, prodName, "Validating [Product Name]");
        commonObj.validateText(ProductDetailsPage.productID, prodID, "Validating [Product ID]");
    }

    /**
     * Keyword to click on [Wishlist] button
     */
    public void clickAddToWishlistbtn() {
        commonObj.closeOverlays();
        Utility_Functions.xScrollElementToCentre(ownDriver, ProductDetailsPage.btnAddToWishlist);
        click(ProductDetailsPage.btnAddToWishlist, "Clicked [Add to Wishlist] button");
        commonObj.validateText(WishlistPage.hdrFindWishlist, "Find Someone's Wish List:", "Navigated to [Wishlist] page");
    }

    /**
     * Keyword to click on [Wishlist] button and verify Product added to Wishlist
     */
    public void wishlistProduct(){
        String prodName = jsonData.getData("ProductName");
        String prodID = jsonData.getData("ProductID");
        clickAddToWishlistbtn();

        List<WebElement> lstProdName = Utility_Functions.findElementsByXpath(ownDriver, WishlistPage.itemName);
        List<WebElement> lstProdID = Utility_Functions.findElementsByXpath(ownDriver, WishlistPage.itemNo);
        Utility_Functions.xScrollElementToCentre(ownDriver, lstProdName.get(lstProdName.size()-1));
        commonObj.validateText(lstProdName.get(lstProdName.size()-1), prodName, "Validating [Product Name] added to Wishlist");
        commonObj.validateText(lstProdID.get(lstProdID.size()-1), prodID, "Validating [Product ID] added to Wishlist");
    }

    /**
     * Keyword to empty items from wishlist
     */
    public void removeWishlistProd() {
        if (isDisplayed(WishlistPage.btnRemove)){
            boolean flag = true;
            while (flag){
                Utility_Functions.xScrollElementToCentre(ownDriver, WishlistPage.btnRemove);
                click(WishlistPage.btnRemove);
                Utility_Functions.timeWait(2);
                flag = xWaitForElementPresent(ownDriver, WishlistPage.btnRemove, 5);
                //flag = isDisplayed(WishlistPage.btnRemove);
            }
        }
        commonObj.validateText(WishlistPage.lblNoItemsInWishlist, "You have no items on your wish list.", "Removed products from wishlist and validating wishlist empty message!");
    }

    /**
     * Keyword to add product to cart from wishlist page
     */
    public void addToCartFromWishlist() {
        List<WebElement> lstAddToCart = Utility_Functions.findElementsByXpath(ownDriver, WishlistPage.btnAddToCart);
        Utility_Functions.xScrollElementToCentre(ownDriver, lstAddToCart.get(lstAddToCart.size()-1));
        click(lstAddToCart.get(lstAddToCart.size()-1), "Clicked on [Add To Cart] button");
    }

    /**
     * Keyword to post a question under a product
     */
    public void postQuestion() {
        int random = Utility_Functions.xRandomFunction(9999);
        String question = "Test Automation Question "+random;
        String email = "Test"+random+"@gmail.com";
        String nickName = "TestNickName"+random;
        String location = "San Jose, CA";

        commonObj.closeOverlays();
        Utility_Functions.xScrollElementToCentre(ownDriver, ProductDetailsPage.btnQuesAns);
        Utility_Functions.timeWait(1);
        click(ProductDetailsPage.btnQuesAns, "Clicked on [Questions & Answers] tab button");
        commonObj.validateText(ProductDetailsPage.hdrQuesAns, "What do you want to know about this product?", "Validating [Questions & Answers] tab header");
        click(ProductDetailsPage.btnAskQuestion, "Clicked on [Ask A Question] button under [Questions & Answers] tab");
        click(ProductDetailsPage.rbTheProduct, "Selected [The Product] as [Type of question]");
        sendKeys(ProductDetailsPage.tbxQuestions, question, "Entered data in [Question] textarea");
        sendKeys(ProductDetailsPage.tbxEmail, email, "Entered data in [Email] textbox");
        sendKeys(ProductDetailsPage.tbxNickName, nickName, "Entered data in [Question] textbox");
        sendKeys(ProductDetailsPage.tbxYourLocation, location, "Entered data in [Your Location] textbox");
        //click(ProductDetailsPage.btnSubmit, "Clicked on [Submit] button");
        Utility_Functions.xClickHiddenElement(ownDriver, ProductDetailsPage.btnSubmit);
        Utility_Functions.xScrollElementToCentre(ownDriver, ProductDetailsPage.hdrThanksForSubmitting);
        commonObj.validateText(ProductDetailsPage.hdrThanksForSubmitting, "Thank you for submitting your question.", "Validating [Question Submitted] message");
    }
}
