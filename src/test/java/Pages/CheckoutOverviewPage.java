package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutOverviewPage extends BaseTest {

    public CheckoutOverviewPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    public WebElement checkoutOverviewTitle;

    @FindBy(id = "cancel")
    public WebElement cancelButtonCheckoutOverview;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(css = ".summary_info_label.summary_total_label")
    public WebElement totalPrice;

    //----------------------

    public void checkElementsOnTheCheckoutOverviewPage() {
        String checkoutOverviewURL = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(driver.getCurrentUrl(), checkoutOverviewURL);

        Assert.assertTrue(checkoutOverviewTitle.isDisplayed());

        Assert.assertTrue(finishButton.isDisplayed());
        finishButton.click();

    }

    public void clickOnCancelButton() {
        cancelButtonCheckoutOverview.click();
    }


}
