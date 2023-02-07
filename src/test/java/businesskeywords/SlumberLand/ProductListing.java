package businesskeywords.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import com.changeCX.framework.Status;
import com.changeCX.framework.selenium.FrameworkDriver;
import commonkeywords.CommonActions;
import org.openqa.selenium.WebElement;
import pages.SlumberLand.ProductListingPage;
import supportLibraries.Utility_Functions;

import java.util.List;

public class ProductListing extends ReusableLib {
    CommonActions commonObj;
    private FrameworkDriver ownDriver;

    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public ProductListing(Helper helper) {
        super(helper);
        commonObj = new CommonActions(helper);
        ownDriver = helper.getGSDriver();
    }

    /**
     * Keyword to click on Product Name
     */
    public void clickProductName() {
        //click(ProductListingPage.productName, "Clicked on product name");
        Utility_Functions.xClickHiddenElement(ownDriver, report, ProductListingPage.productName, "Clicked on product name");
    }

    /**
     * Keyword to click on random Product Name
     */
    public void clickRandomProductName() {
        waitForElementClickable(ProductListingPage.productName, globalWait);
        waitForElementPresent(ProductListingPage.productImage);
        List<WebElement> lstItems = Utility_Functions.findElementsByXpath(ownDriver, ProductListingPage.productName);
        int random = Utility_Functions.xRandomFunction(0, lstItems.size()-1);
        Utility_Functions.xScrollElementToCentre(ownDriver, lstItems.get(random));
        Utility_Functions.xHighlight(ownDriver, lstItems.get(random), "red");
        commonObj.closeOverlays();
        //click(lstItems.get(random), "Clicked on random product name");
        Utility_Functions.xClickHiddenElement(ownDriver, report, lstItems.get(random), "Clicked on random product name");
    }

    /**
     * Keyword to validate the the product details - Name, Image, price are displayed
     */
    public void vrfyProdDtlsDisplayed() {
        waitForElementClickable(ProductListingPage.productName, globalWait);
        List<WebElement> lstProdName = Utility_Functions.findElementsByXpath(ownDriver, ProductListingPage.productName);
        List<WebElement> lstProdImg = Utility_Functions.findElementsByXpath(ownDriver, ProductListingPage.productImage);
        List<WebElement> lstSalesPrice = Utility_Functions.findElementsByXpath(ownDriver, ProductListingPage.productSalesPrice);
        int count = 0;
        for (int i = 0; i < lstProdName.size(); i++) {
            Utility_Functions.xScrollElementToCentre(ownDriver, lstProdName.get(i));
            Utility_Functions.xHighlight(ownDriver, lstProdName.get(i), "red");
            Utility_Functions.timeWait(1);
            if (!isDisplayed(lstSalesPrice.get(i))) {
                report.updateTestLog("Verify Product Price is displayed", "Product Price is NOT displayed", Status.FAIL);
                break;
            }
            if (!isDisplayed(lstProdImg.get(i))) {
                report.updateTestLog("Verify Product Image is displayed", "Product Image is NOT displayed", Status.FAIL);
                break;
            }
            count++;
        }
        if (count == lstProdName.size())
            report.updateTestLog("Verify Product Details displayed", "Product Details are displayed properly", Status.PASS);
        else
            report.updateTestLog("Verify Product Details displayed", "Product Details are NOT displayed properly", Status.FAIL);
    }

    /**
     * Keyword to click on Product Name
     */
    public void vrfyNoProdFoundMsg() {
        String keyword = jsonData.getData("Keyword");
        commonObj.validateText(ProductListingPage.msgNoProductsFound, "We're sorry, no products were found for your search: "+keyword, "Validating [No Products Found] msg");
    }

}
