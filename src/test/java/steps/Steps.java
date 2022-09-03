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
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    @Step
    public void openPageStep() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
        authorizationPage = open(BASE_URL,
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
    public void createUserStep(User user) {
        userRequests.createUser(user);
    }

    @Step("Click Person Cabinet Button")
    public void clickPersonCabinetButtonStep() {
        authorizationPage.clickPersonCabinetButton();
    }

    @Step("Step of Authorization")
    public void authorizationStep(User user) {
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
        authorizationPage.getSauceMenu().shouldBe(Condition.visible);
    }

    @Step("Click fillings button")
    public void clickFillingsButtonStep() {
        authorizationPage.clickFillingsButton();
    }

    @Step("Check filling's label on main page")
    public void checkFillingsLabelStep() {
        authorizationPage.getFillingMenu().shouldBe(Condition.visible);
    }

    @Step("Click rolls button")
    public void clickRollsButtonStep() {
        authorizationPage.clickRollsButton();
    }

    @Step("Check roll's label on main page")
    public void checkRollsLabelStep() {
        authorizationPage.getRollsMenu().shouldBe(Condition.visible);
    }

    @Step("Success registration")
    public void successRegistrationStep(User user) {
        authorizationPage.registrationPage(user.getEmail(), user.getPassword(), user.getName());
    }

    @Step("Fail registration with invalid password")
    public void failRegistrationStep(User user) {
        authorizationPage.registrationPage(user.getEmail(), user.getPassword(), user.getName());
    }

    @Step("Check text for inccorect password")
    public void checkTextForIncorrectPasswordStep() {
        authorizationPage.getIncorrectPassword();
    }
}
