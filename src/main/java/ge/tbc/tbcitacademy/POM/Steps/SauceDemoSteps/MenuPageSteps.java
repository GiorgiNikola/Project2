package ge.tbc.tbcitacademy.POM.Steps.SauceDemoSteps;

import ge.tbc.tbcitacademy.POM.Pages.SauceDemoPages.MenuPage;
import io.qameta.allure.Step;

public class MenuPageSteps {
    MenuPage menuPage = new MenuPage();

    @Step("Click on logout button")
    public MenuPageSteps clickLogoutBtn(){
        menuPage.logoutBtn.click();
        return this;
    }
}
