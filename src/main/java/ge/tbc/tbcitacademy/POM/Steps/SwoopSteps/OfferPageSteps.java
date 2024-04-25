package ge.tbc.tbcitacademy.POM.Steps.SwoopSteps;

import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.OfferPage;
import io.qameta.allure.Step;

public class OfferPageSteps {
    OfferPage offerPage = new OfferPage();

    @Step("Click on share button")
    public OfferPageSteps clickShareBtn(){
        offerPage.shareBtn.click();
        System.out.println("I am the fix4");
        return this;
    }
}
