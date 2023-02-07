package pages.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import org.openqa.selenium.By;

public class ProductDetailsPage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public ProductDetailsPage(Helper helper) {
        super(helper);
    }

    public static By hdrProductName = By.xpath("//h1[@class='product-name']");
    public static By productID = By.xpath("//span[@itemprop='productID']");
    public static By productPrimaryImg = By.xpath("//li[contains(@class,'slick-current slick-active')]//img[@class='primary-image']");
    public static By lblSalePrice = By.xpath("//span[@class='price-sales']");
    public static By ddnSelectQty = By.id("Quantity");
    public static By btnAddToWishlist = By.xpath("//a[text()='Add to Wishlist']");

    public static By btnAddToCart = By.id("add-to-cart");
    public static By popupUIDialogTitle = By.xpath("//h4[@class='ui-dialog-title']");
    public static By btnViewCartInPopup=By.xpath("//td//a[@title='Go to Cart']");
    public static By prodReviewStars = By.xpath("//div[contains(@class,'pr-snippet-stars-png')]");

    /*********************************** Ask a question section locators ***********************************/

    public static By btnQuesAns=By.xpath("//a[@id='pdpQuestionsTabBtn']");
    public static By hdrQuesAns=By.xpath("//abbr[@title='Questions & Answers']");
    public static By btnAskQuestion=By.xpath("//button[@id='pr-question-form-link']");
    public static By rbTheProduct=By.xpath("//label[@for='product']");
    public static By tbxQuestions=By.xpath("//textarea[@id='questionText-input']");
    public static By tbxEmail=By.xpath("//input[@id='authorEmail-input']");
    public static By tbxNickName=By.xpath("//input[@id='authorName-input']");
    public static By tbxYourLocation=By.xpath("//input[@id='authorLocation-input']");
    public static By btnSubmit=By.xpath("//button[text()='Submit']");
    public static By hdrThanksForSubmitting=By.xpath("//h2[@class='pr-qa-display-thankyou-headline']");



}

