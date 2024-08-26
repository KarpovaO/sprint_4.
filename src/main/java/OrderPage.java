import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage extends BasePage {
    //Локаторы 1 панель
    public static final By NAME_INPUT = By.xpath("(//input[@placeholder='* Имя'])[1]");
    public static final By SURNAME_INPUT = By.xpath("//input[@placeholder='* Фамилия']");
    public static final By ADDRESS_INPUT = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    public static final By METRO_STATION_INPUT = By.xpath("//input[@placeholder='* Станция метро']");
    public static final String METRO_STATION_CSS_FORMAT = "[data-index='%s']";
    public static final By PHONE_INPUT = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    public static final By BUTTON_NEXT = By.xpath("//button[contains(text(), 'Далее')]");

    //Локаторы 2 панель
    public static final By DATE_INPUT = By.xpath("//input[@placeholder= '* Когда привезти самокат']");
    public static final By CALENDAR_SELECTED_DAY = By.xpath(".//div[contains(@class, 'react-datepicker__day--selected')]");
    public static final By RENTTERMFIELD = By.xpath(".//div[@class='Dropdown-placeholder']");
    public static final By RENTTERMOPTION = By.xpath(".//div[@class='Dropdown-root Order_FilledDate__1pb8n']");
    public static final String RENTA_OPTION_FORMAT = ".//div[@class='Dropdown-option'][%s]";
    public static final By GREY_CHECKBOX = By.xpath("//label[@for='grey']");
    public static final By BLACK_CHECKBOX = By.xpath("//label[@for='black']");
    public static final By COMMENT_INPUT = By.xpath("//input[@placeholder='Комментарий для курьера']");
    public static final By BUTTON_ORDER = By.cssSelector(".Order_Buttons__1xGrp > .Button_Middle__1CSJM:nth-child(2)");
    public static final By BUTTON_YES = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text()='Да']");
    public static final By BUTTON_VIEW_ORDER = By.xpath(".//button[contains(@class, 'Button_Button__ra12g')][contains(text(), 'Посмотреть статус')]");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void fillOrder(UserInfo userInfo, RentInfo rentInfo) {
        fillUserInfo(userInfo);
        //кликаем далее
        clickElement(OrderPage.BUTTON_NEXT);
        fillRentInfo(rentInfo);
    }

    public void clickOrderButton() {
        clickElement(OrderPage.BUTTON_ORDER);
    }

    public void clickYesButton() {
        clickElement(OrderPage.BUTTON_YES);
    }

    public void clickViewOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(OrderPage.BUTTON_VIEW_ORDER));
        clickElement(OrderPage.BUTTON_VIEW_ORDER);

    }

    public void fillUserInfo(UserInfo user) {
        setInputField(OrderPage.NAME_INPUT, user.getName());
        setInputField(OrderPage.SURNAME_INPUT, user.getSurname());
        setInputField(OrderPage.ADDRESS_INPUT, user.getAddress());

        clickElement(OrderPage.METRO_STATION_INPUT);
        clickElement(By.cssSelector(String.format(OrderPage.METRO_STATION_CSS_FORMAT, user.getMetroStation())));

        setInputField(OrderPage.PHONE_INPUT, user.getPhone());
    }

    public void fillRentInfo(RentInfo rentInfo) {
        setInputField(OrderPage.DATE_INPUT, rentInfo.getOrderDate());
        clickElement(OrderPage.CALENDAR_SELECTED_DAY);
        clickElement(OrderPage.RENTTERMFIELD);
        clickElement(By.xpath(String.format(OrderPage.RENTA_OPTION_FORMAT, rentInfo.getRentalPeriod())));

        if (rentInfo.getColor() == SamokatColor.GRAY) {
            clickElement(OrderPage.GREY_CHECKBOX);
        } else {
            clickElement(OrderPage.BLACK_CHECKBOX);
        }
    }

}
