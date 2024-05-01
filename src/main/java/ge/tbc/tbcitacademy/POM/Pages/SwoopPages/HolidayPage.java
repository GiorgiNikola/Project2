package ge.tbc.tbcitacademy.POM.Pages.SwoopPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HolidayPage {
    public SelenideElement
            minPrice = $(".category-filter-desk").$("#minprice"),
            maxPrice = $(".category-filter-desk").$("#maxprice"),
            submitBtn = $(".category-filter-desk").$(".submit-button"),
            loader = $(".loader"),
            dropDownPlaceholder = $(".category-filter-desk").$(".placeholder"),
            allPaymentMethod = $(withTagAndText("label", "ყველა")).$("input"),
            locationDropDown = $(".category-filter-desk").$("button[type='button']"),
            paymentMethodVoucher = $(withTagAndText("label", "ვაუჩერი")).$("input"),
            deleteBtn = $(".category-filter-desk").$(".delete-search-button");

    public ElementsCollection offers = $$(".special-offer"),
            locationOptions = $(".category-filter-desk").$(".ms-drop.bottom").$$("li");
}
