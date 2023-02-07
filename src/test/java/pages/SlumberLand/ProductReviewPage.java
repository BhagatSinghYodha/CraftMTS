package pages.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import org.openqa.selenium.By;

public class ProductReviewPage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public ProductReviewPage(Helper helper) {
        super(helper);
    }

    public static By btnWriteFirstReview=By.xpath("//section[@id='pr-review-display']//a[text()='Write the First Review']");

    /********************************** Write Review Form locators **********************************/

    public static By hdrWriteAReview = By.xpath("//h3[text()='Write a Review']");
    public static By rbStarRating = By.xpath("//div[@class='pr-rating-stars']//input");
    public static By tbxReviewHeadline = By.xpath("//input[@name='Review Headline']");
    public static By tbxComments = By.xpath("//textarea[@id='pr-comments-input']");
    public static By tbxNickName = By.xpath("//input[@id='pr-name-input']");
    public static By tbxLocation = By.xpath("//input[@name='Location']");
    public static By chkbxPrivacyPolicy = By.xpath("//div[@class='pr-submit']//input");
    public static By btnSubmitReview = By.xpath("//button[text()='Submit Review']");

    public static By hdrThankYou = By.xpath("//h1[@class='title']");
    public static By hdrReviewSubmitted = By.xpath("//h3[@class='subtitle']");
    public static By hdrReviewHeadline = By.xpath("//h2[@class='headline']");
    public static By hdrReviewComments = By.xpath("//p[@class='pr-text']");

}

