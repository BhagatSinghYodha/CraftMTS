package pages.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import org.openqa.selenium.By;

public class ProductListingPage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public ProductListingPage(Helper helper) {
        super(helper);
    }

    public static By productName = By.xpath("//div[@class='product-name']/a");
    public static By productImage = By.xpath("//div[@class='product-image']//img");
    public static By productSalesPrice = By.xpath("//span[@class='product-sales-price']");
    public static By msgNoProductsFound = By.xpath("//div[@class='section-header']/p");

}

