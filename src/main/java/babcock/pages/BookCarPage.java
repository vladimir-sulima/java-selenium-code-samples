package babcock.pages;

import babcock.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BookCarPage extends BasePage {
    WebDriver driver;

    public BookCarPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //region Locators
    String book_Button = "//form//button/span[contains(text(), 'Book')]";
    String selectClient_DDL = "//div[@role='button']";
    String totalPrice_Value = "//p[text()='Total price: ']/strong";
    String startDate_InputField = "(//input)[1]";
    String endDate_InputField = "(//input)[2]";
    String termsAndConditions_CheckBox = "//input[@aria-checked]/../..";
    String close_Button = "//span[text()=' Close ']/..";
    String validationMessage_Value = "//div[text()=' Invalid Booking ']/following-sibling::div/p";

    //endregion
    //region Click actions
    public BookCarPage clickBook_Button() {
        findAndClick(By.xpath(book_Button));

        return this;
    }

    public BookCarPage clickTermsAndConditions_CheckBox() {
        findAndClick(By.xpath(termsAndConditions_CheckBox));

        return this;
    }

    public HomePage clickClose_Button() {
        waitForElementToAppear(By.xpath(close_Button));

        findAndClick(By.xpath(close_Button));

        //This sleep needed to wait till changes applied in db
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

        }
        return new HomePage(driver);
    }

    //endregion
    //region Set actions
    public BookCarPage selectClient_ByName_DDL(String clientName) {
        String locatorByClientName = String.format("//div[@class='v-list-item__title' and contains(text(),'%s')]", clientName);

        findAndClick(By.xpath(selectClient_DDL));

        waitForElementToAppear(By.xpath("//*[@aria-expanded='true']"));

        findAndClick(By.xpath(locatorByClientName));

        return this;
    }

    public BookCarPage selectStartDate(String startDate) {
        findAndClick(By.xpath(startDate_InputField));
        findAndClick(By.xpath(String.format("(//table//div[text()=%s])[1]", startDate.substring(8))));
        return this;
    }

    public BookCarPage selectEndtDate(String endDate) {
        findAndClick(By.xpath(endDate_InputField));
        findAndClick(By.xpath(String.format("(//table//div[text()=%s])[2]", endDate.substring(8))));
        return this;
    }

    //endregion
    //region Check actions
    public BookCarPage checkTotalCarRent_Value(String expectedValue) {
        String actualValue = getTotalValue();
        Assert.assertEquals(actualValue, expectedValue, "Total car rental cost not as");

        return this;
    }
public void checkInvalidBookingMessage_Displayed(){
        waitForElementToAppear(By.xpath(validationMessage_Value));
        String actualValidationMessage = findAndGetText(By.xpath(validationMessage_Value));
        Assert.assertEquals(actualValidationMessage, "Vehicle is booked for this range, chose another range", "Incorrect validation message." );
}
    //endregion
    //region Other actions
    private String getTotalValue() {
        String totalValue = findAndGetText(By.xpath(totalPrice_Value));
        return totalValue.substring(2);
    }
    //endregion
}

