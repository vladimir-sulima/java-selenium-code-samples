package base;

import babcock.utils.DriverManager;
import babcock.utils.Log;
import babcock.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends DriverManager {
    public WebDriver driver;

    PropertyReader propertyReader = new PropertyReader();

    public TestBase(){
        this.driver = super.getDriver();
    }

    @BeforeMethod
    public  void setUp(){
        try{
            if(PropertyReader.readItem("browser").equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
            }
            else{
                try{
                    throw new Exception("Browser Driver is not supported. Please, check browser value at used config file.");
                }
                catch (Exception e){
                    Log.Log.error("No Compatible browser found", e);
                }
            }
            driver.manage().window().maximize();
        }catch (Exception e){
            Log.Log.error(e);
        }
    }
    @AfterMethod
    public  void tearDown(){
        driver.quit();
    }
}
