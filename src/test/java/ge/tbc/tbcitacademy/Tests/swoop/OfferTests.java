package ge.tbc.tbcitacademy.Tests.swoop;

import ge.tbc.tbcitacademy.POM.Data.SwoopConstants;
import ge.tbc.tbcitacademy.POM.DataProviders.SwoopDataProvider;
import ge.tbc.tbcitacademy.POM.Steps.SwoopSteps.*;
import ge.tbc.tbcitacademy.POM.Util.Util;
import ge.tbc.tbcitacademy.Tests.ConfigTests;
import io.qameta.allure.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

@Epic("Swoop Functional Tests")
public class OfferTests extends ConfigTests {
    SoftAssert sfa;
    HeaderPageSteps headerPageSteps;
    HolidayPageSteps holidayPageSteps;
    CategoriesPageSteps categoriesPageSteps;
    RestaurantPageSteps restaurantPageSteps;
    AuthorisationPageSteps authorisationPageSteps;
    OfferPageSteps offerPageSteps;
    PopupPageSteps popupPageSteps;
    @BeforeClass(groups = "SwoopRegression")
    public void pageSetup(){
        headerPageSteps = new HeaderPageSteps();
        holidayPageSteps =  new HolidayPageSteps();
        categoriesPageSteps = new CategoriesPageSteps();
        restaurantPageSteps = new RestaurantPageSteps();
        authorisationPageSteps = new AuthorisationPageSteps();
        offerPageSteps = new OfferPageSteps();
        popupPageSteps = new PopupPageSteps();
    }
    @BeforeMethod(groups = "SwoopRegression")
    public void setup(){
        sfa = new SoftAssert();
        open(SwoopConstants.swoopLink);
    }

    @Test(dataProvider = "priceProvider", dataProviderClass = SwoopDataProvider.class, priority = 1,
            groups = "SwoopRegression", description = "Price range test")
    @Feature("Price Range Filtering")
    @Story("Filter offers by price range and validate their prices")
    @Description("This test case allows takes input a minimum and maximum price range" +
            " and filter offers based on these prices and the checks if offers are really in that price range.")
    @Severity(SeverityLevel.CRITICAL)
    public void rangeTest(int minPrice, int maxPrice){
        headerPageSteps
                .goToHolidaySection();
        boolean checkPrices = holidayPageSteps
                .inputMinPrice(minPrice)
                .inputMaxPrice(maxPrice)
                .submitPriceRange()
                .load()
                .priceRangeCheck(minPrice, maxPrice);
        sfa.assertTrue(checkPrices);
        sfa.assertAll();
    }

    @Test(priority = 2, groups = "SwoopRegression", description = "Add to favorite test")
    @Feature("Favorite Offer Functionality")
    @Story("Marks offer as favorites and checks that vouchers are not sold out")
    @Description("This test case clicks to categories hovers on 'კვება' and then" +
            " chooses sub-category 'რესტორანი' and then it clicks favorite button" +
            " to add offer to favorites then login page is opened, validate that" +
            " login page really appeared and then validate vouchers are not soul out")
    @Severity(SeverityLevel.MINOR)
    public void favouriteOfferTest(){
        headerPageSteps
                .clickCategoriesBtn();
        categoriesPageSteps
                .hoverOnFoodCategory()
                .clickRestaurantCategory();
        restaurantPageSteps
                .clickFavoriteBtn();
        authorisationPageSteps
                .validateLoginPage()
                .navigateBack();
        boolean validateVouchers = restaurantPageSteps
                .validateVouchers();
        sfa.assertTrue(validateVouchers);
        sfa.assertAll();
    }

    @Test(priority = 3, groups = "SwoopRegression", description = "Share on facebook test")
    @Feature("Share Offer")
    @Story("Share offer on social media and checks functionality")
    @Description("This test case goes to sub-category then it navigates to" +
            " first offer and tries to share it, facebook popup is opened" +
            " it switches to popup window and validates it")
    @Severity(SeverityLevel.MINOR)
    public void shareOfferTest(){
        headerPageSteps
                .clickCategoriesBtn();
        categoriesPageSteps
                .hoverOnFoodCategory()
                .clickRestaurantCategory();
        restaurantPageSteps
                .clickFirstOption();
        offerPageSteps
                .clickShareBtn();
        popupPageSteps
                .switchToFacebookPopup()
                .validateFacebook();
    }

    @Test(priority = 4, groups = "SwoopRegression", description = "Validating offer availability test")
    @Feature("Offer Availability Tracking")
    @Story("Track remaining availability of offers")
    @Description("This test case goes to category then it finds offers with" +
            " text 'გაყიდულია 0' and validates that their progress bar is empty")
    @Severity(SeverityLevel.CRITICAL)
    public void noOffersSoldTest(){
        headerPageSteps
                .clickCategoriesBtn();
        categoriesPageSteps
                .hoverOnFoodCategory()
                .clickRestaurantCategory();
        boolean validateProgressBar = restaurantPageSteps
                .validateOfferProgressBar();
        sfa.assertTrue(validateProgressBar);
        sfa.assertAll();
    }

    @Test(priority = 5, groups = "SwoopRegression", description = "Filter applying and clearing test")
    @Feature("Filter Management")
    @Story("Apply and clear filters for offers")
    @Description("This test case applies filters for location," +
            " payment method and price range and then clears" +
            " all filters and validates that everything is back to normal")
    @Severity(SeverityLevel.NORMAL)
    public void clearFilterTest(){
        headerPageSteps
                .goToHolidaySection();
        holidayPageSteps
                .rememberPricesBeforeFiltering()
                .clickLocationDropDown()
                .chooseLocation()
                .clickLocationDropDown()
                .choosePaymentMethod()
                .inputMinPrice(Util.generateMinimum())
                .inputMaxPrice(Util.generateMaximum())
                .submitPriceRange()
                .load()
                .clearFilters()
                .load()
                .validateLocation()
                .validatePaymentMethod();
        boolean validatePrices = holidayPageSteps
                .validatePrices();
        sfa.assertTrue(validatePrices);
        sfa.assertAll();
    }

    @AfterMethod(groups = "SwoopRegression")
    public void tearDown(){
        closeWebDriver();
    }
}
