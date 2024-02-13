package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomepageTest extends BaseTest {

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
    }


    @Test(priority = 10)
    public void userCanAddRandomProduct() {
        homePage.clickOnRandomProduct();
        homePage.checkCartAfterAddedProduct();
    }

    @Test(priority = 15)
    public void userCanAddSpecificProduct() {
        homePage.clickOnSpecificProduct("sauce-labs-bolt-t-shirt");
        homePage.checkCartAfterAddedProduct();
    }

    @Test(priority = 20)
    public void userCanAddAllProduct() {
        homePage.addAllProduct();
        homePage.checkCartAfterAddedProduct();
        homePage.clickOnShoppingCartButton();
    }

    @Test(priority = 25)
    public void userCanChooseItemFromDropdownMenu() throws InterruptedException {
        homePage.clickOnItemFromDropdownMenu();
    }

    //------------

    @Test(priority = 30)
    public void userCanOpenProduct() {
        homePage.openOneProduct();
        homePage.checkElementsOnTheOpenedProduct();
        homePage.clickOnBackToProductsButton();
    }

    @Test(priority = 35)
    public void userCanOpenProductInNewWindowAndBuyIt() {
        homePage.openOneProduct();
        homePage.checkElementsOnTheOpenedProduct();
        homePage.clickOnAddToCartButton();
        homePage.clickOnBackToProductsButton();
        homePage.checkCartAfterAddedProduct();
    }

    @Test(priority = 40)
    public void clickSocialMediaTwitterIcon() {
        homePage.clickOnSocialMediaTwitterIcon();
    }

    @Test(priority = 45)
    public void clickSocialMediaFacebookIcon() {
        homePage.clickOnSocialMediaFacebookIcon();
    }

    @Test(priority = 50)
    public void clickSocialMediaLinkedinIcon() {
        homePage.clickOnSocialMediaLinkedinIcon();
    }

    @Test(priority = 55)
    public void userCanLogout() {
        homePage.logout();
    }

    @Test(priority = 60)
    public void userCanOrderRandomProduct() {
        homePage.clickOnRandomProduct();
        homePage.clickOnShoppingCartButton();

        yourCartPage.checkElementsOnTheYourCartProfileWhenCartIsEmpty();
        yourCartPage.clickOnCheckoutButton();

        checkoutInfoPage.firstNameInputField("Kristina");
        checkoutInfoPage.lastNameInputField("Mijic");
        checkoutInfoPage.postalCodeInputField("123");
        checkoutInfoPage.checkElementsOnTheCheckoutInfoPage();

        checkoutOverviewPage.checkElementsOnTheCheckoutOverviewPage();
        checkoutCompletePage.checkElementOnTheCompletePage();

    }

}
