import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;

    @Before
    public void setup() {

        //ChromeOptions options = new ChromeOptions();;
        //driver = new ChromeDriver(options);
        FirefoxOptions options = new FirefoxOptions();;
        driver = new FirefoxDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void gotoMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void  clickButton(By button){
        driver.findElement(button).click();
    }

    public String getElementText(By selector) {
        return getElement(selector).getText();
    }

    public WebElement getElement(By selector) {
        return driver.findElement(selector);
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollIntoView(By elementSelector) {
        scrollIntoView(getElement(elementSelector));
    }

}
