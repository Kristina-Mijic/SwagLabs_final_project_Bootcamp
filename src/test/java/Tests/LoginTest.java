package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test
    public void userCanLogin() {
        loginPage.usernameInputField("standard_user");
        loginPage.passwordInputField("secret_sauce");
        loginPage.clickOnLoginButton();

        loginPage.thisIsHomePageURL();
    }

    @Test
    public void userCannotLoginWithEmptyUsername() {
        loginPage.passwordInputField("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    @Test
    public void userCannotLoginWithEmptyPassword() {
        loginPage.usernameInputField("standard_user");
        loginPage.clickOnLoginButton();
    }

    @Test
    public void userCannotLoginWithEmptyFields() {
        loginPage.clickOnLoginButton();
    }

    @Test
    public void userCannotLoginWithInvalidData() {
        loginPage.usernameInputField("123");
        loginPage.passwordInputField("p");
        loginPage.clickOnLoginButton();
    }
}
