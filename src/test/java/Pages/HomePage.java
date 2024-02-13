package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "shopping_cart_container")
    public List<WebElement> listShoppingCart;

    @FindBy(className = "btn_small")
    public List<WebElement> addToCartButton;

    @FindBy(className = "btn_small")
    public WebElement addToCartButtonSingleProductPage;

    @FindBy(className = "shopping_cart_badge")
    public WebElement shoppingCartNumber;

    @FindBy(linkText = "Remove")
    public WebElement removeButton;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> productItemName;

    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    @FindBy(className = "inventory_details_name")
    public WebElement productNameAfterOpened;

    @FindBy(css = "option[value='za']")
    public WebElement zaItemFromDropdownmenu;

    @FindBy(className = "select_container")
    public WebElement activeItemDropdownmenu;


    //--------Social media:

    @FindBy(className = "social_twitter")
    public WebElement socialTwitter;

    @FindBy(className = "social_facebook")
    public WebElement socialFacebook;

    @FindBy(className = "social_linkedin")
    public WebElement socialLinkedin;


    //--------------Shopping cart

    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCartButton;

    //--------Logout:

    @FindBy(className = "bm-burger-button")
    public WebElement burgerButton;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    //----------------------------------------------


    //Click on product/s

    public void clickOnSpecificProduct(String productName) {
        driver.findElement(By.id("add-to-cart-" + productName)).click();
    }

    public void clickOnRandomProduct() {
        Random random = new Random();
        int randomNumber = random.nextInt(addToCartButton.size());
        addToCartButton.get(randomNumber).click();
    }

    public void addAllProduct() {
        for(int i = 0; i < addToCartButton.size(); i++) {
            if(addToCartButton.get(i).getText().equalsIgnoreCase("Add to cart")) {
                addToCartButton.get(i).click();
            }
        }
    }

    public void clickOnAddToCartButton() {
        addToCartButtonSingleProductPage.click();
    }

    //Check shopping cart after added product/s
    public void checkCartAfterAddedProduct() {
        Assert.assertFalse(listShoppingCart.isEmpty());
    }

    //Click shopping cart
    public void clickOnShoppingCartButton() {
        shoppingCartButton.click();
    }

    //Dropdown menu
    public void clickOnItemFromDropdownMenu() throws InterruptedException {
        activeItemDropdownmenu.click();
        Thread.sleep(3000);
        zaItemFromDropdownmenu.click();
    }

    //Opened one product
    public void openOneProduct() {
        for(int i = 0; i < productItemName.size(); i++) {
            if(productItemName.get(i).getText().equalsIgnoreCase("Sauce Labs Backpack")) {
                productItemName.get(i).click();
            }
        }
    }

    public void checkElementsOnTheOpenedProduct() {
        String openedProductURL = "https://www.saucedemo.com/inventory-item.html?id=4";
        Assert.assertEquals(driver.getCurrentUrl(), openedProductURL);

        if(productNameAfterOpened.getText().equalsIgnoreCase("Sauce Labs Backpack")) {
            Assert.assertTrue(productNameAfterOpened.isDisplayed());
        }
    }

    public void clickOnBackToProductsButton() {
        backToProductsButton.click();
    }

    //Social media icons
    public void clickOnSocialMediaTwitterIcon()  {
        socialTwitter.click();
    }

    public void clickOnSocialMediaFacebookIcon() {
        socialFacebook.click();
    }

    public void clickOnSocialMediaLinkedinIcon() {
        socialLinkedin.click();
    }

    //Logout:
    public void logout() {
        burgerButton.click();
        logoutButton.click();
    }





}
