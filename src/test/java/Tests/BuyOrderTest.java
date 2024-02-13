package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BuyOrderTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        loginPage = new LoginPage();
        homePage = new HomePage();
        yourCartPage = new YourCartPage();
        checkoutInfoPage = new CheckoutInfoPage();
        checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutCompletePage = new CheckoutCompletePage();

        loginPage.usernameInputField("standard_user");
        loginPage.passwordInputField("secret_sauce");
        loginPage.clickOnLoginButton();

        homePage.clickOnShoppingCartButton();
        yourCartPage.checkElementsOnTheYourCartProfileWhenCartIsEmpty();
        yourCartPage.clickOnCheckoutButton();
    }

    @Test(priority = 10)
    public void userCanOrderEvenIfCartIsEmpty() {
        checkoutInfoPage.firstNameInputField("Kristina");
        checkoutInfoPage.lastNameInputField("Mijic");
        checkoutInfoPage.postalCodeInputField("123");
        checkoutInfoPage.checkElementsOnTheCheckoutInfoPage();

        checkoutOverviewPage.checkElementsOnTheCheckoutOverviewPage();
        checkoutCompletePage.checkElementOnTheCompletePage();
    }


    @Test(priority = 20)
    public void userCannotOrderIfFirstnameEmpty() {
        checkoutInfoPage.invalidFirstnameInputField();
        checkoutInfoPage.lastNameInputField("Mijic");
        checkoutInfoPage.postalCodeInputField("123");
        checkoutInfoPage.checkElementsOnTheCheckoutInfoPage();
    }

    @Test(priority = 30)
    public void userCannotOrderIfLastnameEmpty() {
        checkoutInfoPage.firstNameInputField("Kristina");
        checkoutInfoPage.invalidLastnameInputField();
        checkoutInfoPage.postalCodeInputField("123");
        checkoutInfoPage.checkElementsOnTheCheckoutInfoPage();
    }

    @Test(priority = 40)
    public void userCannotOrderIfPostalCodeEmpty() {
        checkoutInfoPage.firstNameInputField("Kristina");
        checkoutInfoPage.lastNameInputField("Mijic");
        checkoutInfoPage.invalidPostalCodeField();
        checkoutInfoPage.checkElementsOnTheCheckoutInfoPage();
    }

    @Test(priority = 50)
    public void userCannotOrderIfFieldsEmpty() {
        checkoutInfoPage.invalidFirstnameInputField();
        checkoutInfoPage.invalidLastnameInputField();
        checkoutInfoPage.invalidPostalCodeField();
        checkoutInfoPage.checkElementsOnTheCheckoutInfoPage();
    }



}
