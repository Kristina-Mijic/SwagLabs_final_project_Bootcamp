package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class YourCartPage extends BaseTest {

    public YourCartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(className = "title")
    public WebElement yourCartTitle;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    //-------------------


    //Empty Page: (without product/s)
    public void clickOnContinueShoppingButton() {
        Assert.assertTrue(continueShoppingButton.isDisplayed());
        continueShoppingButton.click();
    }

    public void clickOnCheckoutButton() {
        Assert.assertTrue(checkoutButton.isDisplayed());
        checkoutButton.click();
    }

    public void checkElementsOnTheYourCartProfileWhenCartIsEmpty() {
        String yourCartURL = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(driver.getCurrentUrl(), yourCartURL);

        Assert.assertTrue(yourCartTitle.isDisplayed());
        Assert.assertTrue(continueShoppingButton.isDisplayed());
    }


}
