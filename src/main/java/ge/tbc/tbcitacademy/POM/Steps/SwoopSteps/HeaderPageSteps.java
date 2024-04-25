package ge.tbc.tbcitacademy.POM.Steps.SwoopSteps;

import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.HeaderPage;
import io.qameta.allure.Step;

public class HeaderPageSteps {
    HeaderPage headerPage = new HeaderPage();

    @Step("Click on holiday")
    public HeaderPageSteps goToHolidaySection(){
        headerPage.holidaySectionBtn.click();
        System.out.println("i am the change3");
        return this;
    }

    @Step("Click on categories button")
    public HeaderPageSteps clickCategoriesBtn(){
        headerPage.categoriesBtn.click();
        return this;
    }
}
