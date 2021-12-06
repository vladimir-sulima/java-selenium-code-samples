package tests;

import babcock.pages.HomePage;
import base.TestBase;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DisplayAvailableCars_Tests extends TestBase {

    @Test
    @Description("Technical task - Selecting a particular date and showing all available vehicles on that day, verifying that some vehicles are returned and displayed.")
    public void SearchResultDisplayed() {
        HomePage page = new HomePage(driver);

        page.navigateToHomePage()
                .selectStartDate("2021-08-24")
                .selectEndDate("2021-08-30")
                .clickSearchCars_Button()
                .checkAnyCarDisplayed();
    }


}
