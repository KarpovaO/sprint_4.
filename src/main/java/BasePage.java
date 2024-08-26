import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setInputField(By fieldSelector, String text) {
        getElement(fieldSelector).sendKeys(text);
    }

    public void clickElement(By button) {
        getElement(button).click();
    }

    public String getElementText(By selector) {
        return getElement(selector).getText();
    }

    public WebElement getElement(By selector) {
        return driver.findElement(selector);
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

}
