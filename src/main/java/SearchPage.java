import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    By search = By.xpath ("/html/body/div[2]/div/div[3]/div/div[1]/div[1]/form/div/div[1]/input");
    By AddToBag = By.xpath("(//p[@class='buyText'])[1]");
    //By AddToBag = By.xpath("//*[@id=\"page\"]/div/div[6]/section/div/div/div/div/section/div[3]/div[2]/div[1]/div/span");
    public void Search(String Product) {
        driver.findElement(search).sendKeys(Product);
        driver.findElement(search).sendKeys(Keys.ENTER);
        driver.findElement(AddToBag).click();
    }
}
