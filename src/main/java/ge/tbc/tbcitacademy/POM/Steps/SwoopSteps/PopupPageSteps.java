package ge.tbc.tbcitacademy.POM.Steps.SwoopSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.PopupPage;
import io.qameta.allure.Step;

public class PopupPageSteps {
    PopupPage popupPage = new PopupPage();

    @Step("Switches to facebook popup")
    public PopupPageSteps switchToFacebookPopup(){
        Selenide.switchTo().window(1);
        return this;
    }

    @Step("Validate that facebook popup is really opened")
    public PopupPageSteps validateFacebook(){
        popupPage.facebookTxt.shouldBe(Condition.visible);
        return this;
    }
}
