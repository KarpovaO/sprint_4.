import org.junit.Test;
public class OrderTest extends BaseTest {
    @Test
    public void testOrderUpperButton()  {
        gotoMainPage();
        //клик по верхней кнопке
        clickButton(MainPage.BUTTON_ORDER_TOP);

        UserInfo user = TestUserData.getUserInfo();
        RentInfo rent = TestUserData.getRandomRentInfo();
        OrderPage order = new OrderPage(driver);

        order.fillOrder(user, rent);

        order.clickOrderButton();
        order.clickYesButton();
        order.clickViewOrderButton();
    }

    @Test
    public void testOrderDownButton() {
        gotoMainPage();

        scrollIntoView(MainPage.BUTTON_ORDER_BOTTOM);
        //клик по нижней кнопке
        clickButton(MainPage.BUTTON_ORDER_BOTTOM);

        UserInfo user = TestUserData.getUserInfo();
        RentInfo rent = TestUserData.getRandomRentInfo();
        OrderPage order = new OrderPage(driver);

        order.fillOrder(user, rent);

        order.clickOrderButton();
        order.clickYesButton();
        order.clickViewOrderButton();
    }

}
