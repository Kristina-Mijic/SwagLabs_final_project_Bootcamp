package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutCompletePage extends BaseTest {

    public CheckoutCompletePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    public WebElement checkoutCompleteTitle;

    @FindBy(className = "complete-header")
    public WebElement thankYouTitle;

    @FindBy(className = "complete-text")
    public WebElement thankfulDesc;

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    //--------------------

    public void checkElementOnTheCompletePage() {
        String completePageURL = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(driver.getCurrentUrl(), completePageURL);

        Assert.assertTrue(checkoutCompleteTitle.isDisplayed());
        Assert.assertTrue(thankYouTitle.isDisplayed());
        Assert.assertTrue(thankfulDesc.isDisplayed());

        Assert.assertTrue(backHomeButton.isDisplayed());
        backHomeButton.click();
    }


}
