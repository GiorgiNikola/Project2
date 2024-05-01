package ge.tbc.tbcitacademy.POM.Pages.SauceDemoPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {
    public SelenideElement
            userNameField = $("#user-name"),
            passwordField = $("#password"),
            loginBtn = $("#login-button"),
            errorMessage = $("h3[data-test='error']");

    public ElementsCollection
            xIcons = $$("form svg");
}
