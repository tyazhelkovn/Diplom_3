package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthorizationPage extends MainPage {

    //Поле ввода email при регистрации
    @FindBy(how = How.XPATH,using = ".//fieldset[2]//input[@name='name']")
    private SelenideElement registrationEmailField;

    //Поле ввода email при авторизации
    @FindBy(how = How.XPATH,using = ".//fieldset[1]//input[@name='name']")
    private SelenideElement authorizationEmailField;

    //Поле ввода
    @FindBy(how = How.XPATH,using = ".//input[@type='password']")
    private SelenideElement passwordField;

    //Кнопка перехода к регистрации
    @FindBy(how = How.XPATH,using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement toRegistrationButton;

    //Поле ввода Имени для регистрации
    @FindBy(how = How.XPATH,using = ".//fieldset[1]//input[@name='name']")
    private SelenideElement nameField;

    //Кнопка регистрации
    @FindBy(how = How.XPATH,using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    //Надпись ошибки некорректного пароля
    @FindBy(how = How.XPATH,using = ".//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPassword;

    //Текст входа
    @FindBy(how = How.XPATH,using = ".//h2[text()='Вход']")
    private SelenideElement enterLabel;

    //Кнопка входа
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement authorizationButton;

    //Кнопка входа из регистрации
    @FindBy(how = How.XPATH,using = ".//a[text()='Войти']")
    private SelenideElement authorizationFromRegistrationButton;

    //Кнопка востановления пароля
    @FindBy(how = How.XPATH,using = ".//a[text()='Восстановить пароль']")
    private SelenideElement restorePasswordButton;

    //Надпись Профиль в личном кабинете
    @FindBy(how = How.XPATH,using = ".//a[text()='Профиль']")
    private SelenideElement profileLabel;

    //Кнопка выхода из ЛК
    @FindBy(how = How.XPATH,using = ".//button[text()='Выход']")
    private SelenideElement exitButton;

    public void setRegistrationEmailField(String registrationEmailField) {
        this.registrationEmailField.setValue(registrationEmailField);
    }

    public void setPasswordField(String passwordField) {
        this.passwordField.setValue(passwordField);
    }

    public void setNameField(String nameField) {
        this.nameField.setValue(nameField);
    }

    public void setAuthorizationEmailField(String authorizationEmailField) {
        this.authorizationEmailField.setValue(authorizationEmailField);
    }

    public SelenideElement getEnterLabel() {
        return enterLabel;
    }

    public SelenideElement getProfileLabel() {
        return profileLabel;
    }

    public void clickToRegistrationButton() {
        toRegistrationButton.click();
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    public void clickAuthorizationButton() {
        authorizationButton.click();
    }

    public void clickToAuthorizationButton() {
        authorizationFromRegistrationButton.click();
    }

    public void clickRestorePasswordButton() {
        restorePasswordButton.click();
    }

    public void clickExitButton() {
        exitButton.click();
    }

    public void registrationPage(String email, String password, String name) {
        clickPersonCabinetButton();
        clickToRegistrationButton();
        setNameField(name);
        setRegistrationEmailField(email);
        setPasswordField(password);
        clickRegistrationButton();
    }

    public void authorizationPage(String email, String password) {
        setAuthorizationEmailField(email);
        setPasswordField(password);
        clickAuthorizationButton();
    }

    public SelenideElement getIncorrectPassword() {
        return incorrectPassword;
    }


}
