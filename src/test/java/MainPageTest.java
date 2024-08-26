import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;


@RunWith(Parameterized.class)
public class MainPageTest {
    //объявление переменных
    private WebDriver driver;
    private final int answerNum;
    private final String answerValue;

    //конструктор
    public MainPageTest(int answerNum, String answerValue) {
        this.answerNum = answerNum;
        this.answerValue = answerValue;
    }

    //тестовые данные
    @Parameterized.Parameters
    public static Object[][] createOrder() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    //браузер
    @Before
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions();
        ;
        driver = new FirefoxDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void testQuestionsBlock() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnQuestionAndCheckAnswers(answerNum, answerValue);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
