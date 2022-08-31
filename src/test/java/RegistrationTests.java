import builder.UserRequests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobjects.AuthorizationPage;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTests {
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
        String accessToken = userRequests.loginUser(user).then().extract().body().path("accessToken");
        userRequests.deleteUser(accessToken);
    }

    @Test
    public void successRegistration () {
        user = new User("test_nt@ya.ru", "test_nt", "test_nt");
        authorizationPage.registrationPage(user.getEmail(), user.getPassword(), user.getName());
        authorizationPage.getEnterLabel().should(Condition.exactText("Вход"));

    }

    @Test
    public void failRegistrationWithIncorrectPassword () {
        user = new User("test_nt@ya.ru", "te", "test_nt");
        authorizationPage.registrationPage(user.getEmail(), user.getPassword(), user.getName());
        authorizationPage.getIncorrectPassword();
    }
}
