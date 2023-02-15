package WebStepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginStepDefs {
    WebDriver driver;
    @Given("user in the login page")
    public void userInTheLoginPage() {
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
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get ("https://redx.shopups1.xyz/login/");



    }

    @When("user enter {string} and {string}")
    public void userEnterPasswordAndUsername(String username, String password) {
        driver.navigate().to("https://redx.shopups1.xyz/login/");
        System.out.println("username");

    }

    @And("click Button")
    public void clickButton() {
        driver.navigate().to("https://redx.shopups1.xyz/login/");

    }

    @Then("user will navigate the dashboard button")
    public void userWillNavigateTheDashboardButton() {
        driver.navigate().to("https://redx.shopups1.xyz/login/");

    }
}
