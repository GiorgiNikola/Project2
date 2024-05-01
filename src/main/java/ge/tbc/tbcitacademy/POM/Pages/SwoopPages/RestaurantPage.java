package ge.tbc.tbcitacademy.POM.Pages.SwoopPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RestaurantPage {
    public ElementsCollection offers = $$(".special-offer"),
    locationOptions = $(".category-filter-desk").$(".ms-drop.bottom").$$("li");
    public SelenideElement locationDropDown = $(".category-filter-desk").$("button[type='button']"),
            paymentMethodVoucher = $(withTagAndText("label", "ვაუჩერი")).$("input"),
            minPrice = $(".category-filter-desk").$("#minprice"),
            maxPrice = $(".category-filter-desk").$("#maxprice"),
            submitBtn = $(".category-filter-desk").$(".submit-button"),
            deleteBtn = $(".category-filter-desk").$(".delete-search-button"),
            dropDownPlaceholder = $(".category-filter-desk").$(".placeholder"),
            allPaymentMethod = $(withTagAndText("label", "ყველა")).$("input"),
            loader = $(".loader");
}
