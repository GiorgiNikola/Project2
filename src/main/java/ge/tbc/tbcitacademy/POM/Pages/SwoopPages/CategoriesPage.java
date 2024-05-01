package ge.tbc.tbcitacademy.POM.Pages.SwoopPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CategoriesPage {
    public SelenideElement
            categoryFood = $(withTagAndText("a", "კვება")),
            restaurantSubCategory = $(withTagAndText("a", "რესტორანი"));
}
