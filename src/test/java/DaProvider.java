import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DaProvider {

    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"Egg"}};
    }

    @Test(dataProvider = "data-provider")
    public void myTest (String val) throws InterruptedException {
        System.out.println("Result : " + val);


        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(new FirefoxProfile());
        options.addPreference("dom.webnotifications.enabled", false);
        options.addPreference("geo.enabled", true);
        options.addPreference("geo.prompt.testing", true);
        options.addPreference("geo.prompt.testing.allow", true);
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://chaldal.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[1]/div[1]/form/div/div[1]/input")).sendKeys(val);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[1]/div[1]/form/div/div[1]/input")).sendKeys(Keys.ENTER);
    }
}



