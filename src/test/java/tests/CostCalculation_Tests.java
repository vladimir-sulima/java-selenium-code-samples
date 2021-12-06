package tests;

import babcock.pages.HomePage;
import base.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CostCalculation_Tests extends TestBase {

    @DataProvider(name = "CarRentCosts")
    public Object[][] createData1() {
        return new Object[][]{
                {"G699R", "250"},
                {"F334G", "350"},
                {"D722V", "500"},
        };
    }

    @Test(dataProvider = "CarRentCosts")
    @Description("Technical task - Selecting a specific vehicle and a start and end date, invoking the calculation, and verifying the correct cost is displayed.")
    public void CarRentCost(String carCategoryName, String expectedCost) {
        HomePage page = new HomePage(driver);

        page.navigateToHomePage()
                .selectStartDate("2021-08-01")
                .selectEndDate("2012-08-10")
                .clickSearchCars_Button()
                .clickBookCar_ByRegistrationNumber_Button(carCategoryName)
                .checkTotalCarRent_Value(expectedCost);
    }
}
