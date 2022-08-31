import builder.UserRequests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobjects.AuthorizationPage;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTests {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    UserRequests userRequests = new UserRequests();
    User user;

    @Before
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/ntyazhelkov/Downloads/WebDriver/bin/chromedriver");
        authorizationPage = open("https://stellarburgers.nomoreparties.site",
                AuthorizationPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (user != null) {
            String accessToken = userRequests.loginUser(user).then().extract().body().path("accessToken");
            userRequests.deleteUser(accessToken);
        }
    }

    @Test
    public void exitFromAcount () {
        user = new User("test_nt@ya.ru", "test_nt", "test_nt");
        userRequests.createUser(user);
        authorizationPage.clickPersonCabinetButton();
        authorizationPage.authorizationPage(user.getEmail(), user.getPassword());
        authorizationPage.clickPersonCabinetButton();
        authorizationPage.clickExitButton();
        authorizationPage.getEnterLabel().should(Condition.exactText("Вход"));
    }

    @Test
    public void toSauses () {
        authorizationPage.clickSaucesButton();
        authorizationPage.getSaucesLabel().should(Condition.exactText("Соусы"));
    }

    @Test
    public void toFillings () {
        authorizationPage.clickFillingsButton();
        authorizationPage.getFillingsLabel().should(Condition.exactText("Начинки"));
    }

    @Test
    public void toRolls () {
        authorizationPage.clickFillingsButton();
        authorizationPage.clickRollsButton();
        authorizationPage.getRollsLabel().should(Condition.exactText("Булки"));
    }
}
