package ge.tbc.tbcitacademy.POM.Pages.SauceDemoPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ItemsPage {
    public ElementsCollection images = $$(".inventory_item_img img");
    public SelenideElement menuBtn = $("#react-burger-menu-btn");
}
