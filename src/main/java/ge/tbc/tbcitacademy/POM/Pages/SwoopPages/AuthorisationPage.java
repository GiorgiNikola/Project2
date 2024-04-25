package ge.tbc.tbcitacademy.POM.Pages.SwoopPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class AuthorisationPage {
    public SelenideElement authorisationTxt = $(withTagAndText("h2", "ავტორიზაცია"));
}
