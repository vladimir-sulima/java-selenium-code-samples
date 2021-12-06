package babcock.pages;

import babcock.base.BasePage;
import babcock.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //region Locators
    String startDate_InputField = "(//div[@class='v-text-field__slot']//input[@type='text'])[1]";
    String endDate_InputField = "(//div[@class='v-text-field__slot']//input[@type='text'])[2]";
    String searchCars_Button = "//span[contains(text(), 'Search Cars')]";
    String allDisplayedCars_Cards = "//div[@class='d-flex justify-space-between ma-1 result-box v-sheet theme--light elevation-3 rounded']";

    //endregion
// region Click actions
    public HomePage clickSearchCars_Button() {

        findAndClick(By.xpath(searchCars_Button));

        return this;
    }

    public BookCarPage clickBookCar_ByRegistrationNumber_Button(String registrationNumber) {

        String locatorByRegistrationNumber = String.format(String.format("//p[contains(@class,'body') and contains(text(),'%s')]/../../../../..//button//span[text()='Book now']", registrationNumber));
        waitForElementToAppear(By.xpath(locatorByRegistrationNumber));

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(locatorByRegistrationNumber))).perform();

        findAndClick(By.xpath(locatorByRegistrationNumber));
        waitForElementToDisappear(By.xpath(locatorByRegistrationNumber));

        return new BookCarPage(driver);
    }

    //endregion
//region Set actions
    public HomePage selectStartDate(String startDate) {
        waitForElementToAppear(By.xpath(startDate_InputField));

        findAndClick(By.xpath(startDate_InputField));
        findAndClick(By.xpath(String.format("(//table//div[text()=%s])[1]", startDate.substring(8))));
        return this;
    }

    public HomePage selectEndDate(String endtDate) {

        findAndClick(By.xpath(endDate_InputField));
        findAndClick(By.xpath(String.format("(//table//div[text()=%s])[2]", endtDate.substring(8))));

        return this;
    }

    //endregion
//region Check actions
    public HomePage checkAnyCarDisplayed() {
        List<WebElement> listOfAllCars = driver.findElements(By.xpath(allDisplayedCars_Cards));

        Assert.assertNotEquals(listOfAllCars.size(), 0, "There are no car displayed.");

        return this;
    }

    //endregion
//region Other actions
    public HomePage navigateToHomePage() {
        goToUrl(PropertyReader.readItem("url"));
        return this;
    }
//endregion
}
