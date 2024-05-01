package ge.tbc.tbcitacademy.POM.Pages.SwoopPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class PopupPage {
    public SelenideElement facebookTxt = $(withTagAndText("h2", "Facebook"));
}
