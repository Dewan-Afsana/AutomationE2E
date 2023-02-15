import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ChaldalHome {

    @DataProvider(name = "data_provider")
    public Object[][] dpMethod() throws IOException{
        FileReader file = new FileReader();
        Object data[][]= file.excelReader();
        return data;

    }
@Test(dataProvider = "data_provider")
public void searchProduct(String Name, String Qty, String Price){


    ChromeOptions options = new ChromeOptions();
    Map<String, Object> prefs = new HashMap<String, Object>();
    Map<String, Object> profile = new HashMap<String, Object>();
    Map<String, Integer> contentSettings = new HashMap<String, Integer>();

    contentSettings.put("notifications", 2);
    contentSettings.put("geolocation", 2);
    profile.put("managed_default_content_settings", contentSettings);
    prefs.put("profile", profile);
    options.setExperimentalOption("prefs", prefs);
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get ("https://chaldal.com/");

    SearchPage sp = new SearchPage(driver);
    sp.Search(Name);


}
}
