package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutInfoPage extends BaseTest {

    public CheckoutInfoPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    public WebElement checkoutInfoTitle;

    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(id = "postal-code")
    public WebElement postalCodeField;

    @FindBy(id = "cancel")
    public WebElement cancelButton;

    @FindBy(id = "continue")
    public WebElement continueButton;

    //--------------------


    public void firstNameInputField(String firstname) {
        firstNameField.clear();
        firstNameField.sendKeys(firstname);
    }

    public void invalidFirstnameInputField() {
        firstNameField.clear();
        String errorMessage = "Error: First Name is required";
        Assert.assertEquals(errorMessage, "Error: First Name is required");
    }

    public void lastNameInputField(String lastname) {
        lastNameField.clear();
        lastNameField.sendKeys(lastname);
    }

    public void invalidLastnameInputField() {
        lastNameField.clear();
        String errorMessage = "Error: Last Name is required";
        Assert.assertEquals(errorMessage, "Error: Last Name is required");
    }

    public void postalCodeInputField(String postalcode) {
        postalCodeField.clear();
        postalCodeField.sendKeys(postalcode);
    }

    public void invalidPostalCodeField() {
        postalCodeField.clear();
        String errorMessage = "Error: Postal Code is required";
        Assert.assertEquals(errorMessage, "Error: Postal Code is required");
    }

    public void checkElementsOnTheCheckoutInfoPage() {
        String checkoutInfoURL = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), checkoutInfoURL);

        Assert.assertTrue(checkoutInfoTitle.isDisplayed());
        Assert.assertTrue(cancelButton.isDisplayed());

        Assert.assertTrue(continueButton.isDisplayed());
        continueButton.click();
    }



}
