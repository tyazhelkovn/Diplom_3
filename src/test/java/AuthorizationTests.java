import builder.UserRequests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobjects.AuthorizationPage;

import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTests {
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
    public void successAuthorizationThroughPersonCabinet () {
        user = new User("test_nt@ya.ru", "test_nt", "test_nt");
        userRequests.createUser(user);
        authorizationPage.clickPersonCabinetButton();
        authorizationPage.authorizationPage(user.getEmail(), user.getPassword());
        authorizationPage.getMakeBurgerButton().should(Condition.exactText("Соберите бургер"));
    }

    @Test
    public void successAuthorizationThroughEntryToAccount () {
        user = new User("test_nt@ya.ru", "test_nt", "test_nt");
        userRequests.createUser(user);
        authorizationPage.clickEntryToAccountButton();
        authorizationPage.authorizationPage(user.getEmail(), user.getPassword());
        authorizationPage.getMakeBurgerButton().should(Condition.exactText("Соберите бургер"));
    }

    @Test
    public void successAuthorizationThroughRegistration () {
        user = new User("test_nt@ya.ru", "test_nt", "test_nt");
        userRequests.createUser(user);
        authorizationPage.clickEntryToAccountButton();
        authorizationPage.clickToRegistrationButton();
        authorizationPage.clickToAuthorizationButton();
        authorizationPage.authorizationPage(user.getEmail(), user.getPassword());
        authorizationPage.getMakeBurgerButton().should(Condition.exactText("Соберите бургер"));
    }

    @Test
    public void successAuthorizationThroughRecoveryPassword () {
        user = new User("test_nt@ya.ru", "test_nt", "test_nt");
        userRequests.createUser(user);
        authorizationPage.clickEntryToAccountButton();
        authorizationPage.clickRestorePasswordButton();
        authorizationPage.clickToAuthorizationButton();
        authorizationPage.authorizationPage(user.getEmail(), user.getPassword());
        authorizationPage.getMakeBurgerButton().should(Condition.exactText("Соберите бургер"));
    }

    @Test
    public void successAuthorizationAndMoveToPersonCabinet() {
        user = new User("test_nt@ya.ru", "test_nt", "test_nt");
        userRequests.createUser(user);
        authorizationPage.clickEntryToAccountButton();
        authorizationPage.authorizationPage(user.getEmail(), user.getPassword());
        authorizationPage.clickPersonCabinetButton();
        authorizationPage.getProfileLabel().should(Condition.exactText("Профиль"));
    }

    @Test
    public void successAuthorizationAndMoveToConstructor() {
        user = new User("test_nt@ya.ru", "test_nt", "test_nt");
        userRequests.createUser(user);
        authorizationPage.clickEntryToAccountButton();
        authorizationPage.authorizationPage(user.getEmail(), user.getPassword());
        authorizationPage.clickPersonCabinetButton();
        authorizationPage.clickConstructorButton();
        authorizationPage.getMakeBurgerButton().should(Condition.exactText("Соберите бургер"));
    }
}
