package commonkeywords;

import com.changeCX.core.Helper;
import com.changeCX.core.ReusableLib;
import com.changeCX.framework.Status;
import com.changeCX.framework.selenium.FrameworkDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.SlumberLand.MyShoppingCartPage;
import pages.SlumberLand.SlumberLandPage;
import supportLibraries.Utility_Functions;



public class CommonActions extends ReusableLib {

	/**
	 * Constructor to initialize the {@link Helper} object and in turn the
	 * objects wrapped by it
	 *
	 * @param helper The {@link Helper} object
	 */

	private FrameworkDriver ownDriver;
	public CommonActions(Helper helper) {
		super(helper);
		ownDriver=helper.getGSDriver();
	}

	/**
	 * Keyword to get dynamic span WebElement
	 */
	public WebElement getSpan(String text){
		return ownDriver.findElement(By.xpath("//span[text()='"+text+"']"));
	}

	/**
	 *
	 *
	 * This method validates the text displayed in an element
	 *
	 */
	public void validateText(By ele,String text,String msg) {
		if(Utility_Functions.xWaitForElementPresent(ownDriver,ele, globalWait)) {
			String title = getText(ele).trim();
			if (title.isEmpty())
				title = getAttribute(ele, "value").trim();
			System.out.println("Text: "+title);
			Utility_Functions.xAssertEquals(report, text.toLowerCase(), title.trim().toLowerCase(), msg);
		}else {
			System.out.println("Text: Not found");
			throw new NoSuchElementException("Could not find :"+ele);
		}
	}

	public void validateText(WebElement ele,String text,String msg) {
		if(Utility_Functions.xWaitForElementPresent(ownDriver,ele, globalWait)) {
			//Utility_Functions.xHighlight(ownDriver, ele, "red");
			String title = ele.getText().trim();
			if (title.isEmpty()){
				title = ele.getAttribute("value").trim();
			}
			System.out.println("Text: "+title);
			Utility_Functions.xAssertEquals(report, text.toLowerCase(), title.trim().toLowerCase(), msg);
		}else {
			System.out.println("Text: Not found");
			throw new NoSuchElementException("Could not find :"+ele);
		}
	}

	/**
	 * This method verifies that the element contains expected text
	 */
	public void verifyElementContainsText(By ele,String textExpected,String msg) {
		if(Utility_Functions.xWaitForElementPresent(ownDriver,ele, globalWait)) {
			String textActual = getText(ele);
			System.out.println("Text: "+textActual);
			boolean flag = textActual.contains(textExpected);
			if (flag)
				report.updateTestLog("Verify text", "Element contains text expected: "+textExpected+" and actual: "+textActual, Status.PASS);
			else
				report.updateTestLog("Verify text", "Element contains text expected: "+textExpected+" and actual: "+textActual, Status.FAIL);
			Assert.assertTrue(msg, flag);
		}else {
			System.out.println("Text: Not found");
			throw new NoSuchElementException("Could not find :"+ele);
		}
	}

	/**
	 * This method verifies that the actual text contains expected text
	 */
	public void validateContainsText(String textExpected, String textActual, String msg) {
		boolean flag = textActual.trim().contains(textExpected.trim());
		if (flag)
			report.updateTestLog("Verify text", msg, Status.PASS);
		else
			report.updateTestLog("Verify text", msg, Status.FAIL);
		Assert.assertTrue(msg, flag);
	}


	public void validateElementExists(By ele, String msg) {
        if(Utility_Functions.xWaitForElementPresent(ownDriver,ele, globalWait)) {
            System.out.println("Element: "+ ele + " exists");
			report.updateTestLog("Validate ", msg + "" + "",
					Status.PASS);
        }else {
            System.out.println("Element: Not found");
            throw new NoSuchElementException("Could not find :"+ele);
        }
    }

	/**
	 * This method presses [F9] key
	 */
	public void pressF9Key() {
		Utility_Functions.actionKey(Keys.F9, ownDriver);
	}

	/**
	 * Keyword to close the [Exclusive Offers] and [Unlock Offers] overlay
	 */
	public void closeOverlays(){
		int count = 0;
		boolean flag = true;
		while(flag){
			closeUnlockOffersOverlay();
			count++;
			if (count==3)
				flag = false;
			Utility_Functions.timeWait(1);
		}
		count = 0;
		flag = true;
		while(flag){
			closeExOfferPopup();
			count++;
			if (count==3)
				flag = false;
			Utility_Functions.timeWait(1);
		}
	}

	/**
	 * Keyword to close the [Unlock Offers] overlay
	 */
	public void closeUnlockOffersOverlay(){
		boolean flag = isDisplayed(SlumberLandPage.unlockOffersOverlay);
		if (flag)
			Utility_Functions.xClickHiddenElement(ownDriver, SlumberLandPage.btnCloseUnlockOffersOverlay);
	}

	/**
	 * Keyword to close the [Exclusive Offers] pop-up
	 */
	public void closeExOfferPopup(){
		boolean flag = isDisplayed(SlumberLandPage.exclusiveOffersContainer);
		if (flag)
			Utility_Functions.xClickHiddenElement(ownDriver, SlumberLandPage.btnExclusiveOffersClose);
	}

	/**
	 * Keyword to navigate to [My Shopping Cart] page
	 */
	public void navigateToMyShoppingCartPage(){
		click(MyShoppingCartPage.btnViewCart, "");
		validateText(MyShoppingCartPage.hdrMyShoppingCart, "My Shopping Cart", "Navigated to [My Shopping Cart]");
	}
}