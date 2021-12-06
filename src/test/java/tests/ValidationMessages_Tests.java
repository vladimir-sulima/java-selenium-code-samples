package tests;

import babcock.pages.HomePage;
import base.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ValidationMessages_Tests extends TestBase {

    @Test
    @Description("Technical task - •Error/validation-failure scenario of selecting a specific vehicle and a start and end date, where the vehicle is already booked/reserved.")
    public void ValidationForAlreadyBookedCar() {
        HomePage page = new HomePage(driver);

        page.navigateToHomePage()
                .clickBookCar_ByRegistrationNumber_Button("B121C")
                .selectStartDate("2021-08-05")
                .selectEndtDate("2021-08-06")
                .selectClient_ByName_DDL("John")
                .clickTermsAndConditions_CheckBox()
                .clickBook_Button()
                .clickClose_Button()
                .clickBookCar_ByRegistrationNumber_Button("B121C")
                .selectStartDate("2021-08-01")
                .selectEndtDate("2021-08-09")
                .selectClient_ByName_DDL("Amdaris")
                .clickTermsAndConditions_CheckBox()
                .clickBook_Button()
                .checkInvalidBookingMessage_Displayed();

    }
}
