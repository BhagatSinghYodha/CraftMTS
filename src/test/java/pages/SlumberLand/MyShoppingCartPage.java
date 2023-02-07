package pages.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import org.openqa.selenium.By;

public class MyShoppingCartPage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public MyShoppingCartPage(Helper helper) {
        super(helper);
    }

    public static By hdrMyShoppingCart = By.xpath("//h1[text()='My Shopping Cart']");
    public static By lblProductName = By.xpath("//div[@class='name']/a");
    public static By btnSecureCheckout = By.xpath("//button[@value='Secure Checkout']");
    public static By miniCartQty = By.xpath("//div[@id='mini-cart']//span[@class='minicart-quantity']");
    public static By btnViewCart = By.xpath("//div[@id='mini-cart']//a[@title='View Cart']");
    public static By btnRemoveProduct = By.xpath("//button[contains(@name,'deleteProduct')]");
    public static By hdrEmptyCart = By.xpath("//h1[text()='Your Shopping Cart is Empty']");
    public static By ddnSelectQty = By.xpath("//select[@class='quantity-select cart-update']");
    public static By lblItemTotalPrice = By.xpath("//span[@class='price-total']");
    public static By lblSubTotal = By.xpath("//tr[@class='order-subtotal']/td[2]");
    public static By lblEstimatedSalesTax = By.xpath("//tr[@class='order-sales-tax']/td[2]");
    public static By lblEstimatedTotal = By.xpath("//td[@class='order-value']");

}

