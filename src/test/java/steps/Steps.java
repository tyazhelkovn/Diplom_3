package steps;

import builder.UserRequests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import model.User;
import pageobjects.AuthorizationPage;

import static com.codeborne.selenide.Selenide.open;

public class Steps {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    UserRequests userRequests = new UserRequests();
    User user;

    @Step
    public void openPageStep() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        authorizationPage = open("https://stellarburgers.nomoreparties.site",
                AuthorizationPage.class);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Step("Removing test user")
    public void removeUserStep() {
        if (user != null) {
            String accessToken = userRequests.loginUser(user).then().extract().body().path("accessToken");
            userRequests.deleteUser(accessToken);
        }
    }

    @Step("Creating new user")
    public void createUserStep() {
        user = new User("test_nt@ya.ru", "test_nt", "test_nt");
        userRequests.createUser(user);
    }

    @Step("Click Person Cabinet Button")
    public void clickPersonCabinetButtonStep() {
        authorizationPage.clickPersonCabinetButton();
    }

    @Step("Step of Authorization")
    public void authorizationStep() {
        authorizationPage.authorizationPage(user.getEmail(), user.getPassword());
    }

    @Step("Check constructor's label on main page")
    public void checkExistingConstructorSpaceStep() {
        authorizationPage.getMakeBurgerButton().should(Condition.exactText("Соберите бургер"));
    }

    @Step("Click entry to account button")
    public void clickEntryToAccountButtonStep() {
        authorizationPage.clickEntryToAccountButton();
    }

    @Step("Click restore password button")
    public void clickRestorePasswordButtonStep() {
        authorizationPage.clickRestorePasswordButton();
    }

    @Step("Click registration button")
    public void clickToRegistrationButtonStep() {
        authorizationPage.clickToRegistrationButton();
    }

    @Step("Click authorization button")
    public void clickToAuthorizationButtonStep() {
        authorizationPage.clickToAuthorizationButton();
    }

    @Step("Check profile's label on person cabinet")
    public void checkProfileLabelStep() {
        authorizationPage.getProfileLabel().should(Condition.exactText("Профиль"));
    }

    @Step("Click constructor button")
    public void clickConstructorButtonStep() {
        authorizationPage.clickConstructorButton();
    }

    @Step("Click exit button")
    public void clickExitButtonStep() {
        authorizationPage.clickExitButton();
    }

    @Step("Check entry's label on authorization page")
    public void checkEntryLabelStep() {
        authorizationPage.getEnterLabel().should(Condition.exactText("Вход"));
    }

    @Step("Click sauces button")
    public void clickSaucesButtonStep() {
        authorizationPage.clickSaucesButton();
    }

    @Step("Check sauce's label on main page")
    public void checkSaucesLabelStep() {
        authorizationPage.getSaucesLabel().should(Condition.exactText("Соусы"));
    }

    @Step("Click fillings button")
    public void clickFillingsButtonStep() {
        authorizationPage.clickFillingsButton();
    }

    @Step("Check filling's label on main page")
    public void checkFillingsLabelStep() {
        authorizationPage.getFillingsLabel().should(Condition.exactText("Начинки"));
    }

    @Step("Click rolls button")
    public void clickRollsButtonStep() {
        authorizationPage.clickRollsButton();
    }

    @Step("Check roll's label on main page")
    public void checkRollsLabelStep() {
        authorizationPage.getRollsLabel().should(Condition.exactText("Булки"));
    }

    @Step("Success registration")
    public void successRegistrationStep() {
        user = new User("test_nt@ya.ru", "test_nt", "test_nt");
        authorizationPage.registrationPage(user.getEmail(), user.getPassword(), user.getName());
    }

    @Step("Fail registration with invalid password")
    public void failRegistrationStep() {
        user = new User("test_nt@ya.ru", "te", "test_nt");
        authorizationPage.registrationPage(user.getEmail(), user.getPassword(), user.getName());
    }

    @Step("Check text for inccorect password")
    public void checkTextForIncorrectPasswordStep() {
        authorizationPage.getIncorrectPassword();
    }
}
