package pages.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import org.openqa.selenium.By;

public class WishlistPage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public WishlistPage(Helper helper) {
        super(helper);
    }

    public static By btnWishlist=By.xpath("//li[@class='sl-menu-utility-user']//a[text()='Wish List']");
    public static By hdrFindWishlist=By.xpath("//h1[contains(text(),'Wish List')]");

    /******************************************* Wishlist Table locators *******************************************/

    public static By lblNoItemsInWishlist=By.xpath("//h2[text()='You have no items on your wish list.']");
    public static By itemName=By.xpath("//tr//div[@class='name ']/a");
    public static By itemNo=By.xpath("//tr//div[@class='sku']/span[@class='value']");
    public static By btnAddToCart=By.xpath("//tr//button[@title='Add to Cart']");
    public static By btnRemove=By.xpath("//tr//button[@class='button-text delete-item']");

}

