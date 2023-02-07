package businesskeywords.SlumberLand;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import com.changeCX.framework.selenium.FrameworkDriver;
import commonkeywords.CommonActions;
import pages.SlumberLand.ProductReviewPage;
import supportLibraries.Utility_Functions;

public class ProductReview extends ReusableLib {
    CommonActions commonObj;
    private FrameworkDriver ownDriver;

    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public ProductReview(Helper helper) {
        super(helper);
        commonObj = new CommonActions(helper);
        ownDriver = helper.getGSDriver();
    }

    /**
     * Keyword to click [Write the First Review] button
     */
    public void clickWriteFirstReview(){
        commonObj.closeOverlays();
        Utility_Functions.xScrollElementToCentre(ownDriver, ProductReviewPage.btnWriteFirstReview);
        Utility_Functions.timeWait(1);
        //Utility_Functions.xClickHiddenElement(ownDriver, ProductReviewPage.btnWriteFirstReview);
        Utility_Functions.xClickHiddenElement(ownDriver, report, ProductReviewPage.btnWriteFirstReview, "Clicked on [Write the First Review] button");
        commonObj.validateText(ProductReviewPage.hdrWriteAReview, "Write a Review", "Clicked on [Write the First Review] button and Validating [Write a Review] page header");
    }

    /**
     * Keyword to write first review
     */
    public void writeFirstReview(){
        int random = Utility_Functions.xRandomFunction(9999);
        String headline = "Test Review Headline "+random;
        String comments = "Test Review Comments "+random;
        String nickname = "TestNickname"+random;
        String location = "San Jose, CA";

        Utility_Functions.xClickHiddenElement(ownDriver, ProductReviewPage.rbStarRating);
        sendKeys(ProductReviewPage.tbxReviewHeadline, headline, "Entered [Product Headline]");
        sendKeys(ProductReviewPage.tbxComments, comments, "Entered [Comments]");
        sendKeys(ProductReviewPage.tbxNickName, nickname, "Entered [Nick Name]");
        sendKeys(ProductReviewPage.tbxLocation, location, "Entered [Location]");

        Utility_Functions.xScrollElementToCentre(ownDriver, ProductReviewPage.chkbxPrivacyPolicy);
        click(ProductReviewPage.chkbxPrivacyPolicy, "Checked [Privacy Policy] checkbox");
        click(ProductReviewPage.btnSubmitReview, "Clicked on [Submit Review] button");

        Utility_Functions.xScrollElementToCentre(ownDriver, ProductReviewPage.hdrThankYou);
        commonObj.validateText(ProductReviewPage.hdrThankYou, "Thank you!", "Validating [Thank you!] message");
        commonObj.validateText(ProductReviewPage.hdrReviewSubmitted, "We will process your review and publish it within 3-7 business days.", "Validating [Review will be processed] sub-header");
        commonObj.validateText(ProductReviewPage.hdrReviewHeadline, headline, "Validating [Review Headline]");
        commonObj.validateText(ProductReviewPage.hdrReviewComments, comments, "Validating [Review Comment]");
    }



}
