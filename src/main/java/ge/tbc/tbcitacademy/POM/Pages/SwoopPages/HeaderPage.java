package ge.tbc.tbcitacademy.POM.Pages.SwoopPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    public SelenideElement
            holidaySectionBtn = $(".Menus").$(byText("დასვენება")),
            categoriesBtn = $(".NewCategories.newcat");
}
