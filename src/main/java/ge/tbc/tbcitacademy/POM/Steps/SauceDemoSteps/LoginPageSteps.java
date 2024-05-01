package ge.tbc.tbcitacademy.POM.Steps.SauceDemoSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Pages.SauceDemoPages.LoginPage;
import ge.tbc.tbcitacademy.POM.Steps.DatabaseSteps.DatabaseSteps;
import io.qameta.allure.Step;

import java.util.Map;

public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();

    @Step("Input {0} in username field")
    public LoginPageSteps inputUserName(String userName){
        loginPage.userNameField.sendKeys(userName);
        return this;
    }

    @Step("Input password in password field")
    public LoginPageSteps inputPassword(String password){
        loginPage.passwordField.sendKeys(password);
        return this;
    }

    @Step("Click on login button")
    public LoginPageSteps clickLoginBtn(){
        loginPage.loginBtn.click();
        return this;
    }

    @Step("Validate error message appears")
    public LoginPageSteps validateErrorMessage(){
        loginPage.errorMessage.shouldHave(Condition.text("Epic sadface: Sorry, this user has been locked out."));
        return this;
    }

    @Step("Validate X icons appear")
    public LoginPageSteps validateXButtons(){
        for (SelenideElement xIcon : loginPage.xIcons){
            xIcon.shouldBe(Condition.visible);
        }
        return this;
    }

    @Step("Validate username field is empty")
    public LoginPageSteps validateUserNameField(){
        loginPage.userNameField.shouldHave(Condition.attribute("value", ""));
        return this;
    }

    @Step("Validate password field is empty")
    public LoginPageSteps validatePasswordField(){
        loginPage.passwordField.shouldHave(Condition.attribute("value", ""));
        return this;
    }
}
