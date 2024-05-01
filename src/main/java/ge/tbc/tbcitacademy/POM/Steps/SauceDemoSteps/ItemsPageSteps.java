package ge.tbc.tbcitacademy.POM.Steps.SauceDemoSteps;

import com.codeborne.selenide.*;
import ge.tbc.tbcitacademy.POM.Data.SauceDemoConstants;
import ge.tbc.tbcitacademy.POM.Pages.SauceDemoPages.ItemsPage;
import io.qameta.allure.Step;

public class ItemsPageSteps {
    ItemsPage itemsPage =  new ItemsPage();

    @Step("Validate images are visible on page")
    public ItemsPageSteps validateImagesAreVisible(){
        for (SelenideElement image : itemsPage.images){
            image.shouldBe(Condition.visible);
        }
        return this;
    }

    @Step("Validate images are not the same")
    public boolean validateImagesAreNotTheSame(){
        for (int i = 1; i < itemsPage.images.size(); i++){
            if (itemsPage.images.get(i).getAttribute(SauceDemoConstants.src)
                    .equals(itemsPage.images.get(i - 1).getAttribute(SauceDemoConstants.src))){
                return false;
            }
        }
        return true;
    }

    @Step("Click on menu button")
    public ItemsPageSteps clickMenuBtn(){
        itemsPage.menuBtn.click();
        return this;
    }
}
