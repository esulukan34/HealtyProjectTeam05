package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import utilities.DatabaseUtility;
import utilities.Driver;

import static base_url.MedunnaBaseUrl.medunnaSetup;

public class Hooks {
    static WebDriver driver;
    /*
   Cucumber'da Step definitions package'i icerisinde
   @before,@after gibi bir notasyon varsa
    extends testBase dememeize gerek kalmadan
    her scenario'dan once veya sonra bu methodlar calisacaktir
    Cucumber'da @before,@after kullanma ihtiyacimiz olursa
    bunu step definitions package'i altinda olusturacagimiz
    Hooks class'ina koyariz
    Biz her scenario;dan sonra test sonucunu kontrol edip
    failed olan scenario icin screenshoot almasi amaciyla
    @After method'u kullanacagiz
     */

    @Before(value="@API")
    public void beforeApi() {
        medunnaSetup();
    }

    @Before(value="@DB")
    public void beforeDatabase() {
        DatabaseUtility.createConnection(ConfigReader.getProperty("database_url")
                ,ConfigReader.getProperty("database_username"),
                ConfigReader.getProperty("database_password"));
    }

    @After
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot)
                Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.closeDriver();
       // if (!scenario.isFailed()) Driver.closeDriver();
    }
   //public static void quitDriver() { //quit Method
   //    if (driver != null) {
   //        driver.quit();
   //        driver = null;
   //    }

    }






