package babcock.base;

import babcock.utils.WaitForHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void findAndClick(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    public void findAndSetText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(elementLocation).sendKeys(text);
    }

    public String getText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

    public void moveToElement(By elementLocation) {
        new Actions(driver).moveToElement(driver.findElement(elementLocation)).build().perform();
    }

    public void waitForElementToAppear(By elementLocation) {
        new WaitForHelper(driver).presenceOfElement(elementLocation);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }
    }

    public void waitForElementToDisappear(By elementLocation) {
        new WaitForHelper(driver).absenceOfElement(elementLocation);
    }

    public void waitForElementI(By elementLocation) {
        new WaitForHelper(driver).presenceOfElement(elementLocation);
    }

    public String findAndGetText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
}
