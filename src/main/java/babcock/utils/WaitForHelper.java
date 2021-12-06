package babcock.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitForHelper {
    public WebDriver driver;

    public  WaitForHelper(WebDriver driver){
        this.driver = driver;
    }
    public  void impicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public WebElement presenceOfElement(final By elementLocation){

        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }
    public void absenceOfElement(final By elementLocation){

        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(elementLocation));
    }
    public WebElement elementToBeClickable(final By elementIdentifier){

        return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(elementIdentifier));
    }
}
