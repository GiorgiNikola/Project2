package ge.tbc.tbcitacademy.Tests.saucedemo;

import ge.tbc.tbcitacademy.POM.Data.SauceDemoConstants;
import ge.tbc.tbcitacademy.POM.Steps.DatabaseSteps.DatabaseSteps;
import ge.tbc.tbcitacademy.POM.Steps.SauceDemoSteps.ItemsPageSteps;
import ge.tbc.tbcitacademy.POM.Steps.SauceDemoSteps.LoginPageSteps;
import ge.tbc.tbcitacademy.POM.Steps.SauceDemoSteps.MenuPageSteps;
import ge.tbc.tbcitacademy.Tests.ConfigTests;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Epic("SauceDemo Functional Tests")
public class LoginTests extends ConfigTests {
    SoftAssert sfa;
    LoginPageSteps loginPageSteps;
    ItemsPageSteps itemsPageSteps;
    DatabaseSteps databaseSteps;
    MenuPageSteps menuPageSteps;
    @BeforeClass(groups = "SauceDemoLogin")
    public void pageSetup(){
        loginPageSteps =  new LoginPageSteps();
        itemsPageSteps = new ItemsPageSteps();
        databaseSteps = new DatabaseSteps();
        menuPageSteps = new MenuPageSteps();
    }
    @BeforeMethod(groups = "SauceDemoLogin")
    public void setup(){
        sfa = new SoftAssert();
        open(SauceDemoConstants.sauceDemoLink);
    }

    @Test(priority = 1, groups = "SauceDemoLogin",
    description = "Standard user login test")
    @Feature("User Authentication")
    @Story("Logins with valid user and validates images")
    @Description("This test case logins valid user to site and validates " +
            "images are loaded and visible")
    @Severity(SeverityLevel.CRITICAL)
    public void successfulLoginTest(){
        loginPageSteps
                .inputUserName(databaseSteps.returnStandardUserCredentials().get(SauceDemoConstants.userNameTxt))
                .inputPassword(databaseSteps.returnStandardUserCredentials().get(SauceDemoConstants.passwordTxt))
                .clickLoginBtn();
        itemsPageSteps
                .validateImagesAreVisible();
    }

    @Test(priority = 2, groups = "SauceDemoLogin",
    description = "Locked out user login test")
    @Feature("Error Message Validation")
    @Story("Tries to login with banned user and validates error")
    @Description("This test case tries to log in to application with locked out user" +
            " credentials and then validates error message and X button")
    @Severity(SeverityLevel.CRITICAL)
    public void bannedUserLoginTest(){
        loginPageSteps
                .inputUserName(databaseSteps.returnBannedUserCredentials().get(SauceDemoConstants.userNameTxt))
                .inputPassword(databaseSteps.returnBannedUserCredentials().get(SauceDemoConstants.passwordTxt))
                .clickLoginBtn()
                .validateErrorMessage()
                .validateXButtons();
    }

    @Test(priority = 3, groups = "SauceDemoLogin",
    description = "Problematic user login test")
    @Feature("Image Loading Validation")
    @Story("Logins with problematic user and validates images")
    @Description("This test case logs in with problematic user and " +
            " then validates images for products are not the same")
    @Severity(SeverityLevel.NORMAL)
    public void problematicLoginTest(){
        loginPageSteps
                .inputUserName(databaseSteps.returnProblematicUserCredentials().get(SauceDemoConstants.userNameTxt))
                .inputPassword(databaseSteps.returnProblematicUserCredentials().get(SauceDemoConstants.passwordTxt))
                .clickLoginBtn();
        boolean checkImages = itemsPageSteps
                .validateImagesAreNotTheSame();
        sfa.assertTrue(checkImages);
        sfa.assertAll();
    }

    @Test(priority = 4, groups =  "SauceDemoLogin",
    description = "Log out test")
    @Feature("Logout Feature Validation")
    @Story("Tries to log out of the application when done and validates username and password fields")
    @Description("This test case logs in with standard user " +
            "and then clicks on menu button and logs out" +
            " then it validates that username and password" +
            "fields are empty")
    @Severity(SeverityLevel.BLOCKER)
    public void logOutTest(){
        loginPageSteps
                .inputUserName(databaseSteps.returnStandardUserCredentials().get(SauceDemoConstants.userNameTxt))
                .inputPassword(databaseSteps.returnStandardUserCredentials().get(SauceDemoConstants.passwordTxt))
                .clickLoginBtn();
        itemsPageSteps
                .clickMenuBtn();
        menuPageSteps
                .clickLogoutBtn();
        loginPageSteps
                .validateUserNameField()
                .validatePasswordField();
    }

    @AfterMethod(groups = "SauceDemoLogin")
    public void tearDown(){
        closeWebDriver();
    }
}
