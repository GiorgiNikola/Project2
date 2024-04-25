package ge.tbc.tbcitacademy.POM.Steps.SwoopSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.SwoopConstants;
import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.RestaurantPage;
import io.qameta.allure.Step;

public class RestaurantPageSteps {
    RestaurantPage restaurantPage = new RestaurantPage();

    @Step("Click on favorite button")
    public RestaurantPageSteps clickFavoriteBtn(){
        SelenideElement firstOffer = restaurantPage.offers.get(0);
        SelenideElement favoriteBtn = firstOffer.$(".deal-box-wishlist");
        favoriteBtn.click();
        return this;
    }

    @Step("Validate vouchers are still left")
    public boolean validateVouchers(){
        SelenideElement firstOffer = restaurantPage.offers.get(0);
        String percentageString = firstOffer.$(".voucher-limit").getAttribute(SwoopConstants.dataWidth);
        double percentage = Double.parseDouble(percentageString);
        return percentage < 100;
    }

    @Step("Click first offer option")
    public RestaurantPageSteps clickFirstOption(){
        restaurantPage.offers.get(0).click();
        return this;
    }

    @Step("Validate progress bar equals 0 for offers with text 'გაყიდულია 0'")
    public boolean validateOfferProgressBar(){
        SelenideElement firstOffer = restaurantPage.offers
                .filter(Condition.partialText("გაყიდულია 0")).get(0);
        String percentageString = firstOffer.$(".voucher-limit").getAttribute(SwoopConstants.dataWidth);
        double percentage = Double.parseDouble(percentageString);
        return percentage == 0;
    }

    @Step("Wait for loader to disappear")
    public RestaurantPageSteps load(){
        restaurantPage.loader.shouldNot(Condition.visible);
        return this;
    }

}
