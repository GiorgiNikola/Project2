package ge.tbc.tbcitacademy.POM.Steps.SwoopSteps;

import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.HeaderPage;
import io.qameta.allure.Step;

public class HeaderPageSteps {
    HeaderPage headerPage = new HeaderPage();

    @Step("Click on holiday")
    public HeaderPageSteps goToHolidaySection(){
        headerPage.holidaySectionBtn.click();
        return this;
    }

    @Step("Click on categories button")
    public HeaderPageSteps clickCategoriesBtn(){
        headerPage.categoriesBtn.click();
        return this;
    }
}
