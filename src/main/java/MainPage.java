import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MainPage extends BasePage {
    public static final By BUTTON_ORDER_TOP = By.xpath("//button[@class='Button_Button__ra12g']");
    public static final By BUTTON_ORDER_BOTTOM = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnQuestionAndCheckAnswers(int answerNum, String answerValue) {
        String faqQuestionIndex = "accordion__heading-";
        String questionId = faqQuestionIndex + answerNum;
        String faqAnswerIndex = "accordion__panel-";
        String answerId = faqAnswerIndex + answerNum;

        // Клик по вопросу
        WebElement faqElement = driver.findElement(By.id(questionId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", faqElement);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(faqElement));
        faqElement.click();

        // Ассерт ответа
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id(answerId)));
        WebElement answerElement = driver.findElement(By.id(answerId));
        String actualAnswerText = answerElement.getText();
        assertEquals("Текст ответа не совпадает с ожидаемым", answerValue, actualAnswerText);
    }

}
