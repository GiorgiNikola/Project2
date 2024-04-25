package ge.tbc.tbcitacademy.POM.Steps.SwoopSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.SwoopConstants;
import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.HolidayPage;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class HolidayPageSteps {
    HolidayPage holidayPage = new HolidayPage();
    List<Double> pricesBeforeFiltering;

    @Step("Input minimum price {0} in price filter")
    public HolidayPageSteps inputMinPrice(int price){
        holidayPage.minPrice.sendKeys(String.valueOf(price));
        return this;
    }

    @Step("Input maximum price {0} in price filter")
    public HolidayPageSteps inputMaxPrice(int price){
        holidayPage.maxPrice.sendKeys(String.valueOf(price));
        return this;
    }

    @Step("Submit price range of price filter")
    public HolidayPageSteps submitPriceRange(){
        holidayPage.submitBtn.click();
        return this;
    }

    @Step("Wait unit loader disappears")
    public HolidayPageSteps load(){
        holidayPage.loader.shouldNot(Condition.visible);
        return this;
    }

    @Step("Validates if offer prices are between {0} and {1}")
    public boolean priceRangeCheck(double min, double max){
        List<Double> prices = getPricesList();
        for (Double price : prices) {
            if (price < min || price > max) return false;
        }
        return true;
    }

    @Step("Returns list of offers prices")
    public List<Double> getPricesList(){
        List<Double> pricesList = new ArrayList<>();
        for (SelenideElement offer : holidayPage.offers){
            ElementsCollection prices = offer.$(".discounted-prices").$$(".deal-voucher-price");
            AtomicReference<Double> min = new AtomicReference<>((double) Integer.MAX_VALUE);
            prices.forEach(p -> {
                double currentPrice = Double.parseDouble(p.getText().trim().replaceAll("[^\\d.]", ""));
                if (currentPrice < min.get()) min.set(currentPrice);
            });
            pricesList.add(min.get());
        }
        return pricesList;
    }

    @Step("Initialise prices before filtering")
    public HolidayPageSteps rememberPricesBeforeFiltering(){
        pricesBeforeFiltering = getPricesList();
        return this;
    }

    @Step("Click on location dropdown")
    public HolidayPageSteps clickLocationDropDown(){
        holidayPage.locationDropDown.click();
        return this;
    }

    @Step("Choose location on dropdown")
    public HolidayPageSteps chooseLocation(){
        holidayPage.locationOptions.filter(Condition.text("ვარკეთილი")).get(0).click();
        return this;
    }

    @Step("Change payment method to voucher")
    public HolidayPageSteps choosePaymentMethod(){
        executeJavaScript("arguments[0].click();", holidayPage.paymentMethodVoucher);
        return this;
    }

    @Step("Clear delete button to clear all filters")
    public HolidayPageSteps clearFilters(){
        holidayPage.deleteBtn.click();
        return this;
    }

    @Step("Validate location is set to default")
    public HolidayPageSteps validateLocation(){
        holidayPage.dropDownPlaceholder.shouldHave(Condition.text(SwoopConstants.allLocations));
        return this;
    }

    @Step("Validate that default payment method is checked")
    public HolidayPageSteps validatePaymentMethod(){
        holidayPage.allPaymentMethod.shouldHave(Condition.attribute("checked", ""));
        return this;
    }

    @Step("Validates prices are back to normal after removing price filter")
    public boolean validatePrices(){
        List<Double> pricesAfterRemovingFilter = getPricesList();
        if (pricesAfterRemovingFilter.size() != pricesBeforeFiltering.size()){
            return false;
        }else {
            for (int i = 0; i < pricesAfterRemovingFilter.size(); i++){
                if (!Objects.equals(pricesAfterRemovingFilter.get(i), pricesBeforeFiltering.get(i))){
                    return false;
                }
            }
            return true;
        }
    }
}
