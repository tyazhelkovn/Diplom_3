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

    //Меню Сосусы после выбора
    @FindBy(how = How.XPATH,using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']")
    private SelenideElement sauceMenu;

    //Меню Начинки после выбора
    @FindBy(how = How.XPATH,using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']")
    private SelenideElement fillingMenu;

    //Меню Булки после выбора
    @FindBy(how = How.XPATH,using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']")
    private SelenideElement rollsMenu;


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

    public SelenideElement getRollsMenu() {
        return rollsMenu;
    }

    public SelenideElement getSauceMenu() {
        return sauceMenu;
    }

    public SelenideElement getFillingMenu() {
        return fillingMenu;
    }
}
