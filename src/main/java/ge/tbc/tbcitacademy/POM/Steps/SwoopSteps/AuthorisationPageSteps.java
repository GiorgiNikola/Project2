package ge.tbc.tbcitacademy.POM.Steps.SwoopSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.AuthorisationPage;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class AuthorisationPageSteps {
    AuthorisationPage authorisationPage = new AuthorisationPage();

    @Step("Validate that login page appeared")
    public AuthorisationPageSteps validateLoginPage(){
        authorisationPage.authorisationTxt.shouldBe(Condition.visible);
        System.out.println("I am the fix1");
        return this;
    }

    @Step("Navigate back from login page")
    public AuthorisationPageSteps navigateBack(){
        Selenide.back();;
        return this;
    }
}
