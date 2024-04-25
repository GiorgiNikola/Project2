package ge.tbc.tbcitacademy.POM.Steps.SwoopSteps;

import ge.tbc.tbcitacademy.POM.Pages.SwoopPages.CategoriesPage;
import io.qameta.allure.Step;

public class CategoriesPageSteps {
    CategoriesPage categoriesPage = new CategoriesPage();

    @Step("Hover on food category")
    public CategoriesPageSteps hoverOnFoodCategory(){
        categoriesPage.categoryFood.hover();
        System.out.println("i am the change2");
        return this;
    }

    @Step("Click on restaurant sub-category")
    public CategoriesPageSteps clickRestaurantCategory(){
        categoriesPage.restaurantSubCategory.click();
        return this;
    }
}
