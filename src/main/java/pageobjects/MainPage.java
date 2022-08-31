package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    //локатор для кнопки личного кабинета
    @FindBy(how = How.XPATH,using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personCabinetButton;

    //локатор заголовка Соберите бургер
    @FindBy(how = How.XPATH,using = ".//h1[text()='Соберите бургер']")
    private SelenideElement makeBurgerButton;

    //локатор для кнопки Войти в аккаунт
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement entryToAccountButton;

    //локатор кнопки Контсруктора
    @FindBy(how = How.XPATH,using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    //локатор кнопки Булки
    @FindBy(how = How.XPATH,using = ".//span[text()='Булки']")
    private SelenideElement rollsButton;

    //локатор кнопки Соусы
    @FindBy(how = How.XPATH,using = ".//span[text()='Соусы']")
    private SelenideElement saucesButton;

    //локатор кнопки Начинки
    @FindBy(how = How.XPATH,using = ".//span[text()='Начинки']")
    private SelenideElement fillingsButton;

    //локатор надписи Булки
    @FindBy(how = How.XPATH,using = ".//h2[text()='Булки']")
    private SelenideElement rollsLabel;

    //локатор надписи Соусы
    @FindBy(how = How.XPATH,using = ".//h2[text()='Соусы']")
    private SelenideElement saucesLabel;

    //локатор надписи Начинки
    @FindBy(how = How.XPATH,using = ".//h2[text()='Начинки']")
    private SelenideElement fillingsLabel;


    public void clickPersonCabinetButton() {
        personCabinetButton.click();
    }

    public SelenideElement getMakeBurgerButton() {
        return makeBurgerButton;
    }

    public void clickEntryToAccountButton() {
        entryToAccountButton.click();
    }

    public void clickConstructorButton() {
        constructorButton.click();
    }

    public void clickRollsButton() {
        rollsButton.click();
    }

    public void clickSaucesButton() {
        saucesButton.click();
    }

    public void clickFillingsButton() {
        fillingsButton.click();
    }

    public SelenideElement getRollsLabel() {
        return rollsLabel;
    }

    public SelenideElement getSaucesLabel() {
        return saucesLabel;
    }

    public SelenideElement getFillingsLabel() {
        return fillingsLabel;
    }
}
